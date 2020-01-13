package com.example.healthcarepatient;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MyAppointmentFragment extends Fragment {

//    private Toolbar toolbar;
//    private TabLayout tabLayout;
//    ViewPager viewPager;
//    BookApptPageAdapter bookApptPageAdapter;
//    private TabItem tabUpcoming;
//    private TabItem tabPast;

    Toolbar toolbar;
    TabLayout tabLayout;
    AppointmentPageAdapter appointmentPageAdapter;
    ViewPager viewPager;
    TabItem tabUpcoming;
    TabItem tabPast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_appointment,container,false);

        toolbar = v.findViewById(R.id.toolbar_tabbed);
        tabLayout = v.findViewById(R.id.tabLayout);
        tabUpcoming = v.findViewById(R.id.tabUpcoming);
        tabPast = v.findViewById(R.id.tabPast);

        viewPager = v.findViewById(R.id.viewPagerBooking);

        appointmentPageAdapter = new AppointmentPageAdapter(getFragmentManager());
        viewPager.setAdapter(appointmentPageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==2) {

                }
                else if (tab.getPosition()==1) {


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return v;
    }

}
