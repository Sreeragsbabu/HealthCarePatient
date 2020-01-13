package com.example.healthcarepatient;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.healthcarepatient.data_models.Doctor;

import java.util.ArrayList;


public class MyDoctorsFragment extends Fragment {

    private RecyclerView recyclerViewDoctor;
    DoctorAdapter doctorAdapter;
    Context context;

    Doctor doctor1 = new Doctor(R.drawable.doctor1,"Dr. Sherley Billman","General Obstetrics","0.8 km away",4.5,8,125,40,"book","Today - 9:30 AM","Ayush Kumar");
    Doctor doctor2 = new Doctor(R.drawable.doctor2,"Dr. Vinay Misra","Gynecology","45,chandani chak,Noida",3.0,15,261,55,"book","Today - 9:30 AM","Ayush Kumar");
    Doctor doctor3 = new Doctor(R.drawable.doctor1,"Dr. Sherley Billman","General Obstetrics","0.8 km away",4.5,8,125,40,"book","Today - 9:30 AM","Ayush Kumar");
    Doctor doctor4 = new Doctor(R.drawable.doctor2,"Dr. Vinay Misra","Gynecology","45,chandani chak,Noida",3.0,15,261,55,"book","Today - 9:30 AM","Ayush Kumar");
    Doctor doctor5 = new Doctor(R.drawable.doctor1,"Dr. Sherley Billman","General Obstetrics","0.8 km away",4.5,8,125,40,"book","Today - 9:30 AM","Ayush Kumar");

    ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_my_doctors,container,false);

        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
        doctors.add(doctor5);

        FragmentManager fragmentManager = getFragmentManager();
        recyclerViewDoctor = v.findViewById(R.id.recyclerview_doctor);
        recyclerViewDoctor.setLayoutManager(new GridLayoutManager(v.getContext(),1));
        recyclerViewDoctor.setHasFixedSize(true);
        doctorAdapter = new DoctorAdapter(doctors,getActivity(),fragmentManager);
        recyclerViewDoctor.setAdapter(doctorAdapter);
        return v;

    }
}
