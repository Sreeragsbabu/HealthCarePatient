package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class EHRActivity extends AppCompatActivity {

    Toolbar toolbarEhr;
    TabLayout tabLayoutEhr;
    TabItem tabItemSharedFiles;
    TabItem tabItemMyFiles;
    ViewPager viewPagerEhr;
    EhrPageAdapter ehrPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ehr);

        toolbarEhr = findViewById(R.id.toolbar_ehr);
        tabLayoutEhr = findViewById(R.id.tabLayout_ehr);
        tabItemSharedFiles = findViewById(R.id.tab_item_shared_files);
        tabItemMyFiles = findViewById(R.id.tab_item_my_files);
        viewPagerEhr = findViewById(R.id.view_pager_ehr);

        ehrPageAdapter = new EhrPageAdapter(getSupportFragmentManager());
        viewPagerEhr.setAdapter(ehrPageAdapter);

        tabLayoutEhr.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerEhr.setCurrentItem(tab.getPosition());
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

        viewPagerEhr.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutEhr));

    }
}
