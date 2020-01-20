package com.example.healthcarepatient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayoutNext;
    static ImageView imageViewProfilePhoto;
    static BottomSheetProfile bottomSheetProfile;
    EditText firstname,lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstname = findViewById(R.id.editTextFirstname);
        lastname = findViewById(R.id.editTextLastname);

//        final String fname = firstname.getText().toString().trim();
//        final String lname = lastname.getText().toString().trim();

        constraintLayoutNext = findViewById(R.id.constraintLayoutProfileNext);

        imageViewProfilePhoto = findViewById(R.id.imageViewProfilePhoto);

        bottomSheetProfile = new BottomSheetProfile();

        imageViewProfilePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetProfile.show(getSupportFragmentManager(),"BottomSheet");
            }
        });

        constraintLayoutNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (firstname.getText().toString().trim().equals("demo") && lastname.getText().toString().trim().equals("demo")) {
                    Bundle extras = new Bundle();
                    extras.putInt("F_id",1);
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_SHORT).show();
                    firstname.getText().clear();
                    lastname.getText().clear();
                    firstname.requestFocus();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data.getData()!= null) {
            Uri uri = data.getData();
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageViewProfilePhoto.setImageBitmap(image);
                bottomSheetProfile.dismiss();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (requestCode ==0 && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageViewProfilePhoto.setImageBitmap(image);
            bottomSheetProfile.dismiss();
        }

    }
}
