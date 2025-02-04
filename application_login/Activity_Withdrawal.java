package com.example.application_login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Withdrawal extends AppCompatActivity {

    ImageButton withdrawal_Button;
    ImageButton back_Button;
    private FirebaseAuth mAuth;
    private DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);

        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        withdrawal_Button = findViewById(R.id.withdrawal_Button);
        back_Button = findViewById(R.id.back_Button);

        back_Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Activity_Mypage.class);
            startActivity(intent);
        });


        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_01);
        if (checkbox.isChecked()) {

        } else {

        }
        checkbox.setOnClickListener(v -> {

        });
        checkbox = (CheckBox) findViewById(R.id.checkbox_02);
        if (checkbox.isChecked()) {

        } else {

        }
        checkbox.setOnClickListener(v -> {

        });
        checkbox = (CheckBox) findViewById(R.id.checkbox_03);
        if (checkbox.isChecked()) {

        } else {

        }
        checkbox.setOnClickListener(v -> {

        });
        checkbox = (CheckBox) findViewById(R.id.checkbox_04);
        if (checkbox.isChecked()) {

        } else {

        }
        checkbox.setOnClickListener(v -> {

        });
        //회원탈퇴
        withdrawal_Button.setOnClickListener(v -> {
            user.delete();
            Intent intent=new Intent(getApplicationContext(),Activity_Login01.class);
            startActivity(intent);
            Toast.makeText((Activity_Withdrawal.this), "계정이 삭제 되었습니다", Toast.LENGTH_LONG).show();
            //finish();
        });
    }
    public void delete() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText((Activity_Withdrawal.this), "계정이 삭제 되었습니다", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}


