package com.barrera.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    private MaterialButton btnLogin, btnRegister;
    private EditText eTxtEmail, eTxtPassword, eTxtPasswordConfirm, eTxtName, eTxtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        btnLogin.setOnClickListener(click -> {
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
            finish();
        });

        btnRegister.setOnClickListener(click -> {
            String pass = eTxtPassword.getText().toString();
            String passConfirm = eTxtPasswordConfirm.getText().toString();
            String email = eTxtEmail.getText().toString();
            String name = eTxtName.getText().toString();
            String username = eTxtUsername.getText().toString();

            if (pass.isEmpty() || passConfirm.isEmpty() || email.isEmpty() || name.isEmpty() || username.isEmpty()) {
                Toast.makeText(this, "Todos los campos deben ser diligenciados.", Toast.LENGTH_SHORT).show();
            } else {
                if (!pass.equals(passConfirm)) {
                    Toast.makeText(this, "Las contraseñas deben ser identicas.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Registro exitoso, inicie sesión", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(this, LoginActivity.class);
                    startActivity(login);
                    finish();
                }
            }
        });
    }

    private void init() {
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        eTxtEmail = findViewById(R.id.email);
        eTxtPassword = findViewById(R.id.password);
        eTxtPasswordConfirm = findViewById(R.id.password_confirm);
        eTxtUsername = findViewById(R.id.username);
        eTxtName = findViewById(R.id.name);
    }
}