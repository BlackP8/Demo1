package com.example.demo1.Controller.LoginRegistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo1.R;

public class RegistrationActivity extends AppCompatActivity {

    //Регистрационные данные
    private EditText email_reg;
    private EditText password_reg;
    private Button btnReg;
    //Поле уже зарегистрированы
    private TextView register_alr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registration();
    }

    //Регистрация пользователя
    private void registration () {
        email_reg = findViewById(R.id.username_reg);
        password_reg = findViewById(R.id.password_reg);
        btnReg = findViewById(R.id.btn_reg);
        register_alr = findViewById(R.id.alr_acc);

        //Обработчик кнопки регистрации
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_reg.getText().toString().trim();
                String password = password_reg.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    email_reg.setError("Введите email!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    password_reg.setError("Введите пароль!");
                    return;
                }
            }
        });

        //Обработчик поля уже зарегистрирован
        register_alr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}