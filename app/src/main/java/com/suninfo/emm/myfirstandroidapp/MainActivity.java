package com.suninfo.emm.myfirstandroidapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity {
    public int imageSwitch = 0;
    ImageView imageView;
    ProgressBar progressBar;
    int progress = 0;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(MainActivity.this, "main-onCreate", Toast.LENGTH_SHORT).show();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());


        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (0 == imageSwitch)
                {
                    imageView.setImageResource(R.drawable.jelly_bean);
                    progressBar.setVisibility(View.VISIBLE);
                    imageSwitch = 1;
                }
                else if (1 == imageSwitch)
                {
                    //progressBar.setVisibility(View.INVISIBLE);

                    progress = progressBar.getProgress();
                    progress += 10;
                    progressBar.setProgress(progress);

                    imageView.setImageResource(R.drawable.ic_launcher);
                    imageSwitch = 0;
                }
            }
        });

        // Button
        Button bt_toast = (Button)findViewById(R.id.bt_toast);
        bt_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "toast show", Toast.LENGTH_SHORT).show();
            }
        });

        Button bt_search = (Button)findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button bt_browser = (Button)findViewById(R.id.bt_browser);
        bt_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowserActivity.class);
                startActivity(intent);
            }
        });

        Button bt_contact = (Button)findViewById(R.id.bt_contact);
        bt_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                intent.putExtra("new_contact", " zhangl : 18866556699");
                startActivity(intent);
            }
        });

        Button bt_dial = (Button)findViewById(R.id.bt_dial);
        bt_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button bt_exit = (Button)findViewById(R.id.bt_exit);
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("重要提示:");
                dialog.setMessage("是否要关闭程序");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                   public void onClick(DialogInterface dialog, int which) {
                       FileOutputStream out = null;
                       BufferedWriter writer = null;

                       final EditText et_note = (EditText) findViewById(R.id.et_note);
                       String inputText = et_note.getText().toString();

                       try{
                           out = openFileOutput("data", Context.MODE_APPEND);
                           writer = new BufferedWriter(new OutputStreamWriter(out));
                           writer.write(inputText);
                       } catch (IOException e) {
                           e.printStackTrace();
                       } finally {
                           try {
                               if (writer != null) {
                                   writer.close();
                               }
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }

                       System.exit(0);
                   }
                });
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.show();
            }
        });

        final EditText et_note = (EditText) findViewById(R.id.et_note);
        Button bt_show_edit = (Button)findViewById(R.id.bt_show_edit);
        bt_show_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = et_note.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();;
            }
        });

        Button bt_notify = (Button)findViewById(R.id.bt_notify);
        bt_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setTicker("新的通知");
                builder.setContentTitle("通知");
                builder.setContentText("点击查看详细内容");
                builder.setWhen(System.currentTimeMillis());
                builder.setAutoCancel(true);
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();
                //notification.flags = Notification.FLAG_NO_CLEAR;
                manager.notify(0, notification);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(MainActivity.this, "main-onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(MainActivity.this, "main-onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(MainActivity.this, "main-onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(MainActivity.this, "main-onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(MainActivity.this, "main-onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(MainActivity.this, "main-onRestart", Toast.LENGTH_SHORT).show();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
