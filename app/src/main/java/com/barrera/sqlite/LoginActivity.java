package com.barrera.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    private MaterialButton btnLogin, btnRegister;
    private EditText eTxtEmail, eTxtPassword;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnLogin.setOnClickListener(click -> {
            String pass = eTxtPassword.getText().toString();
            String email = eTxtEmail.getText().toString();

            if (pass.isEmpty() || pass == "" || email.isEmpty() || email == "") {
                Toast.makeText(this, "Debe de ingresar los 2 campos.", Toast.LENGTH_SHORT).show();
            } else {
                Cursor c = db.getLogin(email, pass);
                if (c.moveToFirst()) {
                    Toast.makeText(this, "Inicio sesión exitoso.", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(this, HomeInfo.class);
                    home.putExtra("email", c.getString(1));
                    home.putExtra("name", c.getString(2));
                    home.putExtra("username", c.getString(3));
                    home.putExtra("genre", c.getString(5));
                    startActivity(home);
                    finish();
                } else {
                    Toast.makeText(this, "Datos ingresados son incorrectos.", Toast.LENGTH_SHORT).show();
                }
                c.close();
            }
        });

        btnRegister.setOnClickListener(click -> {
            Intent register = new Intent(this, RegisterActivity.class);
            startActivity(register);
            finish();
        });
    }

    private void init() {
        db = new DatabaseHelper(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        eTxtEmail = findViewById(R.id.login_email);
        eTxtPassword = findViewById(R.id.login_password);
    }
}