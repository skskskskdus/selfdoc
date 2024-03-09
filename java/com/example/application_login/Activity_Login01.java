package com.example.application_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity_Login01 extends AppCompatActivity {

    ImageButton kakao_Button,email_Button;
    Button email_join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login01);

        kakao_Button=(ImageButton)findViewById(R.id.kakao_Button);
        email_Button=(ImageButton)findViewById(R.id.email_Button);

        ImageButton imageButton=(ImageButton)findViewById(R.id.email_Button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_Signup.class);
                startActivity(intent);
            }
        });
        Button email_join=(Button)findViewById(R.id.email_join);
        email_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Activity_Login02.class);
                startActivity(intent);
            }
        });




    }
}