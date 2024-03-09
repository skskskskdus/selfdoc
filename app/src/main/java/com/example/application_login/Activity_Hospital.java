package com.example.application_login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity_Hospital extends AppCompatActivity {
    Button button;
    EditText hospital_content, view_content2, view_content3;
    String text;
    private FirebaseDatabase mData;
    private DatabaseReference databaseReference;
    private  static  final String TAG="Activity_Hospital";
    private String value;
    private String hospital;
    private String time;
    private String memo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        hospital_content = findViewById(R.id.hospital_content);
        view_content2 = findViewById(R.id.view_content2);
        view_content3 = findViewById(R.id.view_content02);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {

            hospital_content = findViewById(R.id.hospital_content);
            view_content2 = findViewById(R.id.view_content2);
            view_content3 = findViewById(R.id.view_content02);

//            String text01=hospital_content.getText().toString();
//            String text02=view_content2.getText().toString();
//            String text03=view_content3.getText().toString();

            FirebaseDatabase mData = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = mData.getReference();

            DatabaseReference dataRef=databaseReference.child("hospital");
            DatabaseReference itemRef=dataRef.push();
            itemRef.child("hospital").setValue(hospital_content.getText().toString());
            itemRef.child("time").setValue(view_content2.getText().toString());
            itemRef.child("memeo").setValue(view_content3.getText().toString());

//            databaseReference.setValue(hospital_content.getText().toString());
//            databaseReference.setValue(view_content2.getText().toString());
//            databaseReference.setValue(view_content3.getText().toString());
//
            dataRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    StringBuffer buffer=new StringBuffer();
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                            buffer.append(dataSnapshot1.getKey()+":"+dataSnapshot.getValue()+"\n");
                        }
                        buffer.append("\n");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

//           databaseReference.addValueEventListener(new ValueEventListener() {
//               @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String text01= snapshot.getValue(String.class);
//                String text02=snapshot.getValue(String.class);
//                String text03=snapshot.getValue(String.class);
////                hospital_content.setText(text);
////                view_content2.setText(text);
////                view_content3.setText(text);
//                 Log.d(TAG, "Value is: " + value);
//            }
//
//              @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//                 Log.w(TAG, "Failed to read value.", error.toException());
//                }
//          });
//



      });

    }





}
