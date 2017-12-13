//
// Created by famgy on 12/13/17.
//

#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <unistd.h>
#include <android/log.h>
#include <sys/inotify.h>

#define LOG_TAG "=====onEvent====="
#define LOGD(fmt, args...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, fmt, ##args)


extern "C"
JNIEXPORT jstring JNICALL
Java_com_suninfo_emm_myfirstandroidapp_MainActivity_uninstallFeedbackInit(JNIEnv *env, jobject thiZ) {

    LOGD("init start...");

    pid_t pid = fork();
    if (pid < 0) {
        LOGD("fork failed...");
    }else if (0 == pid) {
        int fileDescriptor = inotify_init();
        if (fileDescriptor < 0) {
            LOGD("inotify_init failed...");
            exit(1);
        }

        int watchDescriptor = inotify_add_watch(fileDescriptor, "/data/data/com.suninfo.emm.myfirstandroidapp", IN_DELETE);
        LOGD("watchDescriptor=%d", watchDescriptor);
        if (watchDescriptor < 0) {
            LOGD("inotify_add_watch failed...");
            exit(1);
        }

        void *p_buf = malloc(sizeof(struct inotify_event));
        if (p_buf == NULL) {
            LOGD("malloc failed...");
            exit(1);
        }

        LOGD("start observer...");
        size_t readBytes = read(fileDescriptor, p_buf, sizeof(struct inotify_event));

        free(p_buf);
        inotify_rm_watch(fileDescriptor, IN_DELETE);

        LOGD("uninstall");

        execlp("am", "am", "start", "--user", "0" ,"-a", "android.intent.action.VIEW", "-d", "http://www.suninfo.com", (char *)NULL);
    }

    std::string hello = "Hello from JNI";
    return env->NewStringUTF(hello.c_str());
}