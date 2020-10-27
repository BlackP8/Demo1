package com.example.demo1.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo1.HomeActivity;
import com.example.demo1.R;
import com.example.demo1.RegistrationActivity;
import com.example.demo1.ResetPassActivity;

public class LoginActivity extends AppCompatActivity {

    //Поля входа
    private EditText email_log;
    private EditText password_log;
    private Button btnLog;
    //Текстовые поля
    private TextView forgetpass;
    private TextView registerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }

    //Ввод данных пользователя для входа
    private void login() {
        email_log = findViewById(R.id.username_log);
        password_log = findViewById(R.id.password_log);
        btnLog = findViewById(R.id.log_in);
        forgetpass = findViewById(R.id.forgot_password);
        registerhere = findViewById(R.id.register_here);

        //Обработка кнопки вход
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                /*String email = email_log.getText().toString().trim();
                String password = password_log.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    email_log.setError("Введите email!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    password_log.setError("Введите пароль!");
                    return;
                }*/
            }
        });

        //Обработка поля регистрации
        registerhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
            }
        });

        //Обработка поля забыл пароль
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPassActivity.class));
            }
        });
    }
}