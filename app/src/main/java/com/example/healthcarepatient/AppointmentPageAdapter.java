package com.example.healthcarepatient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AppointmentPageAdapter extends FragmentPagerAdapter {

    private int num_tabs = 2;

    public AppointmentPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new UpcomingFragment();
            case 1:
                return new PastFragment();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return num_tabs;
    }
}
