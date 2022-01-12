package com.nomad.android31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText userName, password;
    private ImageView imageAva;
    private TextView editPhoto;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        userName = findViewById(R.id.ed_name);
        password = findViewById(R.id.ed_surname);
        imageAva = findViewById(R.id.image_ava);
        editPhoto = findViewById(R.id.text_ava);
        btn = findViewById(R.id.btn);

        String user = getIntent().getStringExtra("user");
        String pass = getIntent().getStringExtra("pass");

        userName.setText(user);
        password.setText(pass);

        editPhoto.setOnClickListener(view -> {
            try {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageAva.setImageBitmap(bitmap);
        }
    }
}