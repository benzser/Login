package com.example.benzser.login.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benzser.login.R;
import com.example.benzser.login.UserManager;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private EditText et_username, et_password, et_confirm;
    private TextView tv_register;
    private Context Context;
    private UserManager Manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initInstances();
        bindlistener();
    }

    private void initInstances() {
        Manager = new UserManager(this);
        Context = this;
        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        et_confirm = (EditText) findViewById(R.id.confirm_password);
        btn_register = (Button) findViewById(R.id.button_register);

    }

    public void bindlistener() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim().toLowerCase();
                String password = et_password.getText().toString();
                String confirmPassword = et_confirm.getText().toString();

                if(username ==""){
                    Toast.makeText(Context,"Please insert username",Toast.LENGTH_SHORT).show();
                }else if(password == ""){
                    Toast.makeText(Context,"Please insert pssword",Toast.LENGTH_SHORT).show();
                }else if(confirmPassword ==""){
                    Toast.makeText(Context,"Please insert confirm password",Toast.LENGTH_SHORT).show();
                }else {
                    if (password.equals(confirmPassword)) {
                        boolean isSuccess = Manager.registerUser(username, password);

                        if (isSuccess) {
                            String message = getString(R.string.register_success);
                            Toast.makeText(Context, message, Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            String message = getString(R.string.register_error_message);
                            Toast.makeText(Context, message, Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        String message = getString(R.string.register_password_error);
                        Toast.makeText(Context, message, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
