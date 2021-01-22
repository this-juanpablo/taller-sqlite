package com.barrera.sqlite;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeInfo extends AppCompatActivity {

    private TextView txtWelcome, txtName, txtUsername, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_info);
        init();

        Bundle data = getIntent().getExtras();

        txtWelcome.setText("Bienvenid" + (data.getString("genre").equals("Masculino") ? "o " : "a ") + data.getString("name"));
        txtName.setText("Nombre: " + data.getString("name"));
        txtUsername.setText("Username: " + data.getString("username"));
        txtEmail.setText("Email: " + data.getString("email"));
    }

    private void init() {
        txtWelcome = findViewById(R.id.homeWelcome);
        txtName = findViewById(R.id.homeName);
        txtUsername = findViewById(R.id.homeUsername);
        txtEmail = findViewById(R.id.homeEmail);
    }
}