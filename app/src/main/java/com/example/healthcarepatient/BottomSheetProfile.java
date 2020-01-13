package com.example.healthcarepatient;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetProfile extends BottomSheetDialogFragment {

    ConstraintLayout constraintLayoutCamera,constraintLayoutGallery,constraintLayoutRemove;
    static ImageView imageViewProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_profile,container,false);

        constraintLayoutCamera = v.findViewById(R.id.constraintLayoutCamera);
        constraintLayoutGallery = v.findViewById(R.id.constraintLayoutGallery);
        constraintLayoutRemove = v.findViewById(R.id.constraintLayoutRemove);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            constraintLayoutCamera.setEnabled(false);
            ActivityCompat.requestPermissions(getActivity(),new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }


        constraintLayoutCamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                getActivity().startActivityForResult(intentCamera,0);
                Toast.makeText(getContext(),"Camera",Toast.LENGTH_SHORT).show();
            }
        });

        constraintLayoutGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent();
                intentGallery.setType("image/*");
                intentGallery.setAction(Intent.ACTION_GET_CONTENT);
                getActivity().startActivityForResult(intentGallery,1);
                Toast.makeText(getContext(),"Gallery",Toast.LENGTH_SHORT).show();
            }
        });

        constraintLayoutRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProfileActivity.bottomSheetProfile.dismiss();
                ProfileActivity.imageViewProfilePhoto.setImageBitmap(null);

                }
        });
        return v;
    }
}
