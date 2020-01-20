package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class AppointmentDetails extends AppCompatActivity {

    ConstraintLayout constraintLayoutRescheduleBooking,constraintLayoutCancelBooking;
    CoordinatorLayout coordinatorLayoutCancel;
    ImageView imageViewCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        constraintLayoutRescheduleBooking = findViewById(R.id.constraintLayoutRescheduleBooking);
        constraintLayoutCancelBooking = findViewById(R.id.constraintLayoutCancelBooking);

        coordinatorLayoutCancel = findViewById(R.id.cordinatorLayoutCancel);
        imageViewCancel = findViewById(R.id.imageViewConfirmGreen);

        constraintLayoutCancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintLayoutCancelBooking.setVisibility(View.GONE);
                constraintLayoutRescheduleBooking.setVisibility(View.GONE);
                imageViewCancel.setImageResource(R.drawable.ic_cancel_appointment);

                Snackbar snackbar = Snackbar.make(coordinatorLayoutCancel,"Appointment Has been Cancelled",Snackbar.LENGTH_INDEFINITE);
                View view = snackbar.getView();

                view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red));
                TextView textView = view.findViewById(R.id.snackbar_text);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else {
                    textView.setGravity(Gravity.CENTER_HORIZONTAL);
                }
                snackbar.show();

                Bundle extras = new Bundle();
                extras.putInt("F_id",4);
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        constraintLayoutRescheduleBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TimeSlotActivity.class);
                startActivity(intent);
            }
        });
    }
}
