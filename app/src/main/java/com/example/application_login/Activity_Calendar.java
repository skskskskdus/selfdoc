package com.example.application_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_Calendar extends AppCompatActivity {

    CalendarView calendar;
    ImageButton hospital_Btn,diagnosis_Btn,approximately_Btn,record_Btn,mypage_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendar = findViewById(R.id.calendar);

        ImageButton imageButton_01=findViewById(R.id.hospital_Btn);

        ImageButton imageButton_02=findViewById(R.id.diagnosis_Btn);
        imageButton_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Activity_Keepfile.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton_04=findViewById(R.id.record_Btn);

        ImageButton imageButton_05=findViewById(R.id.camera_Btn);
        imageButton_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Activity_Arcamera.class);
                startActivity(intent);
            }
        });

        imageButton_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Activity_Hospital.class);
                startActivity(intent);
            }
        });

        imageButton_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Activity_Record.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton_06=findViewById(R.id.mypage_Btn);
        imageButton_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Activity_Mypage.class);
                startActivity(intent);
            }
        });
    }


}