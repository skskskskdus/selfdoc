package com.example.application_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_BellPush extends AppCompatActivity {

    boolean isClicked;
    ImageButton home_Btn,mypage_Btn,pen_Btnc,camera_Btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bell_push);

        ImageButton imageButton_01=(ImageButton)findViewById(R.id.home_Btn);
        imageButton_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Activity_Calendar.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton_02=(ImageButton)findViewById(R.id.mypage_Btn);
        imageButton_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Activity_Mypage.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton_03=(ImageButton)findViewById(R.id.camera_Btn);
        imageButton_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Activity_Arcamera.class);
                startActivity(intent);
            }
        });



    }
}