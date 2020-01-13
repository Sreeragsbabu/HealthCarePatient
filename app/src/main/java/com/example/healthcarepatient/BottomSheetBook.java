package com.example.healthcarepatient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetBook extends BottomSheetDialogFragment {

    RadioButton radioButtonPhone, radioButtonVideo,radioButtonVisit;
    ConstraintLayout constraintLayoutBook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.bottom_sheet_call,container,false);

        radioButtonPhone = v.findViewById(R.id.radioButtonPhone);
        radioButtonVideo = v.findViewById(R.id.radioButtonVideo);
        radioButtonVisit = v.findViewById(R.id.radioButtonVisit);
        constraintLayoutBook = v.findViewById(R.id.constraintLayoutBookTime);

        radioButtonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButtonVideo.setChecked(false);
                radioButtonVisit.setChecked(false);
                Toast.makeText(getContext(),"phone",Toast.LENGTH_SHORT).show();
            }
        });

        radioButtonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButtonPhone.setChecked(false);
                radioButtonVisit.setChecked(false);
                Toast.makeText(getContext(),"video",Toast.LENGTH_SHORT).show();
            }
        });

        radioButtonVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButtonPhone.setChecked(false);
                radioButtonVideo.setChecked(false);
                Toast.makeText(getContext(),"visit",Toast.LENGTH_SHORT).show();
            }
        });

        constraintLayoutBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonPhone.isChecked() || radioButtonVideo.isChecked() || radioButtonVisit.isChecked()) {
                    Intent intent = new Intent(getContext(),TimeSlotActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getContext(),"select any optiom",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }
}
