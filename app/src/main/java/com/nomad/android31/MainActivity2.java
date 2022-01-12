package com.nomad.android31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        userName = findViewById(R.id.ed_name);
        password = findViewById(R.id.ed_surname);

        String user = getIntent().getStringExtra("user");
        String pass = getIntent().getStringExtra("pass");

        userName.setText(user);
        password.setText(pass);

    }
}