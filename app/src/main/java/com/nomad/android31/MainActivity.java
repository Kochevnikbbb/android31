package com.nomad.android31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private Button btnGo;
    private TextInputEditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        btnGo = findViewById(R.id.btn);
        userName = findViewById(R.id.text_input_edit_text);
        password = findViewById(R.id.text_input_edit_password);

        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(image);
        
        btnGo.setOnClickListener(view -> {
            if (userName.getText().toString() != null && password.getText().toString().length() > 5){
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                intent.putExtra(user,"user");
                intent.putExtra(pass,"pass");
                startActivity(intent);


                Toast.makeText(this, "Вы успешно зашли", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Не правильные данные", Toast.LENGTH_SHORT).show();
            }

        });
        
    }
}