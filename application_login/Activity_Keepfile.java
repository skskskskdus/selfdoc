package com.example.application_login;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;


import static com.example.application_login.R.id.surfaceView;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Activity_Keepfile extends AppCompatActivity {

    Uri uri;
    ImageView imageView;
    ImageButton upload_Button;
    ImageButton save_Button;

    private final DatabaseReference root= FirebaseDatabase.getInstance().getReference("Image");
    private final StorageReference reference=FirebaseStorage.getInstance().getReference();

    private static int REQUEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keepfile);

        upload_Button = findViewById(R.id.upload_Button);
        save_Button = findViewById(R.id.save_Button);
        imageView = findViewById(R.id.image_view);


        ImageButton imageButton_01 = (ImageButton) findViewById(R.id.home_Btn);
        imageButton_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Calendar.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton_02 = (ImageButton) findViewById(R.id.mypage_Btn);
        imageButton_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Mypage.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton_03 = (ImageButton) findViewById(R.id.camera_Btn);
        imageButton_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Arcamera.class);
                startActivity(intent);
            }
        });
        //진단서 등록시 이벤트리스
        save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uri !=null){
                    uploadToFirebase(uri);
                }else{
                    Toast.makeText(Activity_Keepfile.this ,"사진을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //진단서 등록 버튼 리스너 (카메라)~
        upload_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                //startActivityResult.launch(intent);

               // Intent intent = new Intent(Activity_Keepfile.this,LaunchActivity.class);
               //


            }
        });

    }

    private void showDialog(){
        String choice[] = {"갤러리에서 가져오기", "카메라로 사진찍기"};
        AlertDialog.Builder photoDia = new AlertDialog.Builder(Activity_Keepfile.this);

        photoDia.setTitle("선택하세요");

        photoDia.setItems(choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                if(which == 0){
                    REQUEST = 300;
                    intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                }else{
                    REQUEST = 200;
                    //intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent = new Intent(Activity_Keepfile.this,CameraConfig.class);
                }
                startActivityResult.launch(intent);
            }
        });
        AlertDialog dialog = photoDia.create();
        dialog.show();
    }

    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d("@@@", String.valueOf(result.getResultCode()));
                    if( result.getResultCode() == RESULT_OK && result.getData() != null){

                        if(REQUEST == 200){
                            Log.d("@@@", "정상진입");
                            Bitmap bitmap = byteArrayToBitmap((byte[]) result.getData().getExtras().get("data"));
                            imageView.setImageBitmap(bitmap);
                        }
                        else if(REQUEST == 300){
                            uri = result.getData().getData();

                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                                imageView.setImageBitmap(bitmap);
                            }catch (FileNotFoundException e){
                                e.printStackTrace();
                            }catch (IOException e){
                                e.printStackTrace();
                            }

                        }

                    }
                }
            });

    private Bitmap byteArrayToBitmap( byte[] byteArray ) {
        Bitmap bitmap = BitmapFactory.decodeByteArray( byteArray, 0, byteArray.length ) ;
        return bitmap ;
    }
    //파이어베이스 이미지 업로드
    private void uploadToFirebase(Uri uri) {
        StorageReference fileRef=reference.child(System.currentTimeMillis()+"."
                +getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //이미지 모델에 담기
                        Model model=new Model(uri.toString());
                        //키로 아이디 생성
                        String modelId=root.push().getKey();

                        //데이터 넣기
                        root.child(modelId).setValue(model);

                        Toast.makeText(Activity_Keepfile.this, "업로드 성공",Toast.LENGTH_SHORT).show();

                        imageView.setImageResource(R.drawable.file_01);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Activity_Keepfile.this, "업로드 실패",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private String getFileExtension(Uri uri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();

        return mime.getExtensionFromMimeType(cr.getType(uri));
    }


    }









