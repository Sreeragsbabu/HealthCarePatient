package com.example.healthcarepatient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.home_bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer fragmentId = 1;
//        Integer fragmentId = extras.getInt("F_id");

        Fragment selectedFragment = null;
        switch (fragmentId) {
            case 1:
                selectedFragment = new HomeFragment();
                break;
            case 2:
                selectedFragment = new ChatsFragment();
                break;
            case 3:
                selectedFragment = new MyDoctorsFragment();
                break;
            case 4:
                selectedFragment = new MyAppointmentFragment();
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_my_appts);
                break;
            case 5:
                selectedFragment = new ProfileFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.bottom_nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.bottom_nav_chats:
                    selectedFragment = new ChatsFragment();
                    break;
                case R.id.bottom_nav_my_doctors:
                    selectedFragment = new MyDoctorsFragment();
                    break;
                case R.id.bottom_nav_my_appts:
                    selectedFragment = new MyAppointmentFragment();
                    break;
                case R.id.bottom_nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
