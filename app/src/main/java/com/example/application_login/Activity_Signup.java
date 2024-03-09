package com.example.application_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Signup extends AppCompatActivity {
    ImageButton back_Button_02;
    private Button button_03;
    private EditText Et_Name, Et_email, Et_Pw, Et_Repw;
    private FirebaseAuth mAuth;
    private DatabaseReference mData;
    private View.OnClickListener OnClickListener;
    private Object mainActivity_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();
        back_Button_02 = findViewById(R.id.back_Button_02);
        button_03 = findViewById(R.id.button3);


        findViewById(R.id.back_Button_02).setOnClickListener(OnClickListener);

        back_Button_02.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Activity_Login01.class);
            startActivity(intent);
        });
        button_03.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Activity_Login02.class);
            startActivity(intent);

            mAuth = FirebaseAuth.getInstance();
            mData = FirebaseDatabase.getInstance().getReference();

            String name = ((EditText) findViewById(R.id.Et_Name)).getText().toString();
            String email = ((EditText) findViewById(R.id.Et_email)).getText().toString();
            String pw = ((EditText) findViewById(R.id.Et_Pw)).getText().toString();
            String pwcheck = ((EditText) findViewById(R.id.Et_Repw)).getText().toString();

            if (email.length() > 0 && pw.length() > 0 && pwcheck.length() > 0) {
                if (pw.equals(pwcheck)) {
                    Task<AuthResult> addOnCompleteListener
                            = mAuth.createUserWithEmailAndPassword(email, pw)
                            .addOnCompleteListener(task -> {
                                if ((task.isSuccessful())) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Activity_Signup.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (task.getException() != null) {
                                        Toast.makeText(Activity_Signup.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                } else {
                    Toast.makeText(Activity_Signup.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Activity_Signup.this, "이메일 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            }

        });


    }
}

