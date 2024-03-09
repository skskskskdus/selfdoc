package com.example.application_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_loding02 extends AppCompatActivity {

    @Override
    protected void onCreate( @NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding02);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getApplicationContext(),Activity_Login01.class);
                Intent intent=new Intent(getApplicationContext(),LaunchActivity.class);
                startActivity(intent);
            }
        });
    }
}