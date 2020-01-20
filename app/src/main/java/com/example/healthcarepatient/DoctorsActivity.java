package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DoctorsActivity extends AppCompatActivity {

    RecyclerView recyclerViewFavDoctors;
    DoctorFavAdapter doctorFavAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        recyclerViewFavDoctors = findViewById(R.id.recyclerViewDoctors_fav);
        recyclerViewFavDoctors.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerViewFavDoctors.setHasFixedSize(true);

        doctorFavAdapter = new DoctorFavAdapter(DoctorsActivity.this);
        recyclerViewFavDoctors.setAdapter(doctorFavAdapter);
    }
}
