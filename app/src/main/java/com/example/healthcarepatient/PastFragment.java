package com.example.healthcarepatient;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class PastFragment extends Fragment {

    Context context;
    RecyclerView recyclerViewPast;
    PastAppointmentAdapter pastAppointmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_past,container,false);

        recyclerViewPast = view.findViewById(R.id.recyclerViewPastAppointment);
        recyclerViewPast.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        recyclerViewPast.setHasFixedSize(true);
        pastAppointmentAdapter = new PastAppointmentAdapter(getContext(),getFragmentManager());
        recyclerViewPast.setAdapter(pastAppointmentAdapter);
        return view;



    }



}
