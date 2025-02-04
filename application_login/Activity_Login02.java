package com.example.application_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Login02 extends AppCompatActivity {
    Button button,button_02;
    private EditText Et_Name,Et_email,Et_Pw,Et_Repw;
    private FirebaseAuth mAuth;
    private DatabaseReference mData;

    @Override
    protected void onCreate( @NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login02);

        mAuth = FirebaseAuth.getInstance();
        mData= FirebaseDatabase.getInstance().getReference();

        Et_email=findViewById(R.id.Et_email);
        Et_Pw=findViewById(R.id.Et_Pw);

        Button button_01= findViewById(R.id.button);
        button_01.setOnClickListener(v -> {

            //로그인 요청
            String email = Et_email.getText().toString();
            String pw = Et_Pw.getText().toString();


            Intent intent01=new Intent(getBaseContext(),Activity_Mypage.class);
            intent01.putExtra("email",email);
            intent01.putExtra("password",pw);
            startActivity(intent01);

            Intent intent02=new Intent(getApplicationContext(),Activity_Calendar.class);
            startActivity(intent02);


            mAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(Activity_Login02.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //로그인 성공, 캘린더 화면으로 이동&로그인 성공 메세지
                        Toast.makeText(Activity_Login02.this, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                        //finish();, 현재 액티비티 파괴
                    }else{
                        //로그인 실패
                        Toast.makeText(Activity_Login02.this, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        });


        //회원가입 버튼 눌리면
        Button button_02= findViewById(R.id.button_02);
        button_02.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Activity_Signup.class);
            startActivity(intent);
        });

        ImageButton imageButton= findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Activity_Login01.class);
            startActivity(intent);
        });


    }
}