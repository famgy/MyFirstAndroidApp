package com.suninfo.emm.myfirstandroidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText uname;
    private EditText upaswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;

        Toast.makeText(LoginActivity.this, xdpi+"*"+ydpi, Toast.LENGTH_SHORT).show();

        Button bt_login = (Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = (EditText) findViewById(R.id.account);
                upaswd = (EditText) findViewById(R.id.password);

                String name = uname.getText().toString();
                String passwd = upaswd.getText().toString();

                SharedPreferences.Editor editor = getSharedPreferences("userinfo", MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("passwd", passwd);
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
