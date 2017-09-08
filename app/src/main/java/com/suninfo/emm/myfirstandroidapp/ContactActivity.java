package com.suninfo.emm.myfirstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toast.makeText(ContactActivity.this, "contact-onCreate", Toast.LENGTH_SHORT).show();
        //Toast.makeText(ContactActivity.this, getClass().getSimpleName(), Toast.LENGTH_SHORT).show();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contact);

        Intent intent = getIntent();
        final String newData = intent.getStringExtra("new_contact");

        String[] sList = new String[]
                {
                    "wangzl : 18666999991",
                    "eangzl : 18666999992",
                    "fangzl : 18666999993",
                    "gangzl : 18666999994",
                    "hangzl : 18666999996",
                    "jangzl : 18666999999",
                    "jangzl : 18666999999",
                    "kangzl : 18666999999",
                    "langzl : 18666999999",
                    "vangzl : 18666999999",
                    "xangzl : 18666999999",
                    "cangzl : 18666999999",
                    "vangzl : 18666999999",
                    "bangzl : 18666999999",
                    "nangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    "wangzl : 18666999999",
                    newData
                };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ContactActivity.this, android.R.layout.simple_list_item_1, sList);

        ListView listView = (ListView) findViewById(R.id.list_contact_view);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(ContactActivity.this, "contact-onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(ContactActivity.this, "contact-onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(ContactActivity.this, "contact-onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(ContactActivity.this, "contact-onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(ContactActivity.this, "contact-onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(ContactActivity.this, "contact-onRestart", Toast.LENGTH_SHORT).show();
    }
}
