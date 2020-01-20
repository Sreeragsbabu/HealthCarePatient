package com.example.healthcarepatient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class EhrPageAdapter extends FragmentPagerAdapter {

    private int tab_no = 2;

    public EhrPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new EHR_Shared_Fragment();
            case 1:
                return  new EHR_Myfiles_Fragment();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tab_no;
    }
}
