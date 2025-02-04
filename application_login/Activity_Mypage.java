package com.example.application_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Mypage extends AppCompatActivity {

        Button bell_push, logout, withdrawal;
        ImageButton home_Btn,mypage_Btn,camera_Btn,file_Button;
        private FirebaseAuth mAuth;
        private DatabaseReference mData;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        mAuth = FirebaseAuth.getInstance();
        mData= FirebaseDatabase.getInstance().getReference();


        logout= findViewById(R.id.logout);
        withdrawal= findViewById((R.id.withdrawal));
        home_Btn= findViewById(R.id.home_Btn);
        camera_Btn= findViewById(R.id.camera_Btn);
        file_Button= findViewById(R.id.file_Button);
        mypage_Btn=findViewById(R.id.mypage_Btn);


        home_Btn.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Activity_Calendar.class);
            startActivity(intent);
        });

        camera_Btn.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Activity_Arcamera.class);
            startActivity(intent);
        });

        file_Button.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(),Activity_Keepfile.class);
            startActivity(intent);
        });

        withdrawal.setOnClickListener(view -> {
           Intent intent= new Intent(getApplicationContext(),Activity_Withdrawal.class);
           startActivity(intent);
       });
        logout.setOnClickListener(view -> {
            mAuth.signOut();
            Intent intent=new Intent(getApplicationContext(),Activity_Login01.class);
            startActivity(intent);
            // finish();
            Toast.makeText(Activity_Mypage.this, "로그아웃이 완료되었습니다.", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(getApplicationContext(),Activity_Mypage.class));
        });

    }
    public void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

}
