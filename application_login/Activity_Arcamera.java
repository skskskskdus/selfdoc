package com.example.application_login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Arcamera extends AppCompatActivity {

    Button mbutton;
    Button mbutton2;
    Button mbutton3;

    ImageButton home_Btn,mypage_Btn,pen_Btnc,camera_Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcamera);

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

        mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/selfdoc_care/"));
                startActivity(urlintent);
            }
        });

        mbutton2 = findViewById(R.id.button2);
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/selfdoc_care/"));
                startActivity(urlintent);
            }
        });

        mbutton3 = findViewById(R.id.button3);
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/selfdoc_care/"));
                startActivity(urlintent);
            }
        });
    }


}