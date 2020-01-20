package com.example.healthcarepatient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetAppointment extends BottomSheetDialogFragment {

    ConstraintLayout constraintLayoutCancel,constraintLayoutReschedule,constraintLayoutViewDetails;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_appointment,container,false);

        constraintLayoutCancel = v.findViewById(R.id.constraintLayoutCancelAppointment);
        constraintLayoutReschedule = v.findViewById(R.id.constraintLayoutRescheduleAppointment);
        constraintLayoutViewDetails = v.findViewById(R.id.constraintLayoutViewDetailsAppointment);

        constraintLayoutViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AppointmentDetails.class);
                startActivity(intent);
            }
        });


        return v;
    }
}
