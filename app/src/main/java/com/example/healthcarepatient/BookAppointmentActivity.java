package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.healthcarepatient.data_models.Patients;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class BookAppointmentActivity extends AppCompatActivity implements DialogListener {

    CoordinatorLayout coordinatorLayout;
    RecyclerView recyclerViewPatient;
    PatientAdapter patientAdapter;
    ConstraintLayout constraintLayoutConfirm;
    DialogFragment dialogFragment;

    Patients add = new Patients("Add",R.drawable.ic_add);
    Patients myself = new Patients("My Self",R.drawable.myself);

    ArrayList<Patients> patientList = new ArrayList<Patients>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        coordinatorLayout = findViewById(R.id.cordinatorLayout);
        recyclerViewPatient = findViewById(R.id.recyclerPatient);

        patientList.add(add);
        patientList.add(myself);

        Snackbar snackbar = Snackbar.make(coordinatorLayout,"You are Booking an appointment with",Snackbar.LENGTH_INDEFINITE);
        View view = snackbar.getView();

        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
        TextView textView = view.findViewById(R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        snackbar.show();

        recyclerViewPatient.setLayoutManager(new GridLayoutManager(getApplicationContext(),1,RecyclerView.HORIZONTAL,false));
        recyclerViewPatient.setHasFixedSize(true);
        patientAdapter = new PatientAdapter(getApplicationContext(),patientList);
        recyclerViewPatient.setAdapter(patientAdapter);

        constraintLayoutConfirm = findViewById(R.id.constraintLayoutConfirm);

        constraintLayoutConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment = new ConfirmAlertDialogFragment(BookAppointmentActivity.this);
                dialogFragment.setCancelable(false);
                dialogFragment.show(getSupportFragmentManager(),"Custom Dialog");

            }
        });


    }

    @Override
    public void onOkay() {
        dialogFragment.dismiss();

        Bundle extras = new Bundle();
        extras.putInt("F_id",4);
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        intent.putExtras(extras);
        startActivity(intent);

//        MyAppointmentFragment myAppointmentFragment = new MyAppointmentFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container,myAppointmentFragment);
//        fragmentTransaction.commit();

    }
}
