package com.example.benzser.login.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benzser.login.R;
import com.example.benzser.login.UserManager;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText et_username, et_password;
    private TextView tv_register;
    private UserManager mManager;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initInstances();

    }

    private void initInstances() {
        mManager = new UserManager(this);

        mContext = this;
        btn_login = (Button) findViewById(R.id.button_login);
        et_username = (EditText) findViewById(R.id.edittext_username);
        et_password = (EditText) findViewById(R.id.edittext_password);
        tv_register = (TextView) findViewById(R.id.textview_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checklogin();
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Checklogin() {
        String username = et_username.getText().toString().trim().toLowerCase();
        String password = et_password.getText().toString().trim();

        boolean isSuccess = mManager.checkLoginValidate(username, password);

        if (isSuccess) {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
        } else {
            String message = getString(R.string.login_error_message);
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }
}
