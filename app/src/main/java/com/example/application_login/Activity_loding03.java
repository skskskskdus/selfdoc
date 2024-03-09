package com.example.application_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_loding03 extends AppCompatActivity {

    ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding03);

        ImageButton imageButton=(ImageButton) findViewById(R.id.imagebutton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_loding02.class);
                startActivity(intent);
            }
        });
    }
}