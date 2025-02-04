package com.example.application_login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity_Record extends AppCompatActivity {
    Button button;
    EditText editText;
    String text;
    private FirebaseDatabase mData;
    private DatabaseReference databaseReference;
    private  static  final String TAG="Activity_Record";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        button=findViewById(R.id.button);
        editText=findViewById(R.id.view_content);

        button.setOnClickListener(v -> {
            FirebaseDatabase mData = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = mData.getReference("Record");

            databaseReference.setValue(editText.getText().toString());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Log.d(TAG, "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        });
    }




}

