package com.suninfo.emm.myfirstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(ContactActivity.this, "contact-onCreate", Toast.LENGTH_SHORT).show();
        //Toast.makeText(ContactActivity.this, getClass().getSimpleName(), Toast.LENGTH_SHORT).show();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contact);

        Intent intent = getIntent();
        String data = intent.getStringExtra("new_contact");

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.contact_third);
        tv.setText(data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(ContactActivity.this, "contact-onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(ContactActivity.this, "contact-onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(ContactActivity.this, "contact-onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(ContactActivity.this, "contact-onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(ContactActivity.this, "contact-onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(ContactActivity.this, "contact-onRestart", Toast.LENGTH_SHORT).show();
    }
}
