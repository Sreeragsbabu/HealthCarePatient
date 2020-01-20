package com.example.healthcarepatient;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomsheetEhrAddRecord extends BottomSheetDialogFragment {

    ConstraintLayout constraintLayoutCameraEhr,constraintLayoutGalleryEhr,constraintLayoutDocumentEhr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_ehr_add_record,container,false);

        constraintLayoutCameraEhr = view.findViewById(R.id.constraintLayoutCamera_ehr);
        constraintLayoutGalleryEhr = view.findViewById(R.id.constraintLayoutGallery_ehr);
        constraintLayoutDocumentEhr = view.findViewById(R.id.constraintLayoutDocument_ehr);


        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            constraintLayoutCameraEhr.setEnabled(false);
            ActivityCompat.requestPermissions(getActivity(),new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }

        constraintLayoutCameraEhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCameraEhr = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCameraEhr,0);
            }
        });

        constraintLayoutGalleryEhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGalleryEhr = new Intent();
                intentGalleryEhr.setType("image/*");
                intentGalleryEhr.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intentGalleryEhr,1);
            }

        });

        constraintLayoutDocumentEhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDocumentEhr = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intentDocumentEhr.addCategory(Intent.CATEGORY_OPENABLE);
                intentDocumentEhr.setType("*/*");
                startActivityForResult(intentDocumentEhr,2);
                Toast.makeText(getContext(),"Document",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 0: {
                Intent intent = new Intent(getContext(),UploadRecordActivity.class);
                startActivity(intent);
            }
            case 1: {
                Intent intent = new Intent(getContext(),UploadRecordActivity.class);
                startActivity(intent);
            }

            case 2:{
                Intent intent = new Intent(getContext(),UploadRecordActivity.class);
                startActivity(intent);
            }
        }
//        if (requestCode == 0) {

//        }

    }
}
