package com.example.healthcarepatient;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Console;


public class UpcomingFragment extends Fragment {

    RecyclerView recyclerViewUpcoming;
    UpcomingApptsAdapter upcomingApptsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_upcoming,container,false);

        FragmentManager fragmentManager = getFragmentManager();
        recyclerViewUpcoming = v.findViewById(R.id.recyclerViewUpcomingAppointments);
        recyclerViewUpcoming.setLayoutManager(new GridLayoutManager(v.getContext(),1));
        recyclerViewUpcoming.setHasFixedSize(true);
        upcomingApptsAdapter = new UpcomingApptsAdapter(getContext(),fragmentManager);
        recyclerViewUpcoming.setAdapter(upcomingApptsAdapter);

        return v;
    }




}
