package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PillsReminderActivity extends AppCompatActivity implements View.OnClickListener, PillsReminderFavouriteAdapter.OnFavouriteItemListener {

    RecyclerView recyclerViewPillsFavourites;
    PillsReminderFavouriteAdapter pillsReminderFavouriteAdapter;
    ConstraintLayout constraintLayoutPillsMorning,constraintLayoutPillsAfternoon,constraintLayoutPillsEvening,constraintLayoutPillsNight;
    TextView textViewPillsMorning,textViewPillsAfternoon,textViewPillsEvening,textViewPillsNight;
    ImageView imageViewPillsMor1,imageViewPillsMor2,imageViewPillsAft1,imageViewPillsAft2,imageViewPillsEve1,imageViewPillsEve2,imageViewPillsNight1,imageViewPillsNight2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pills_reminder);

        constraintLayoutPillsMorning = findViewById(R.id.constraintLayoutPillsMorning);
        constraintLayoutPillsMorning.setOnClickListener(this);
        constraintLayoutPillsAfternoon = findViewById(R.id.constraintLayoutPillsAfternoon);
        constraintLayoutPillsAfternoon.setOnClickListener(this);
        constraintLayoutPillsEvening = findViewById(R.id.constraintLayoutPillsEvening);
        constraintLayoutPillsEvening.setOnClickListener(this);
        constraintLayoutPillsNight = findViewById(R.id.constraintLayoutPillsNight);
        constraintLayoutPillsNight.setOnClickListener(this);

        textViewPillsMorning = findViewById(R.id.textViewPillsMorning);
        textViewPillsAfternoon = findViewById(R.id.textViewPillsAfternoon);
        textViewPillsEvening = findViewById(R.id.textViewPillsEvening);
        textViewPillsNight = findViewById(R.id.textViewPillsNight);

        imageViewPillsMor1 = findViewById(R.id.imageViewPillsMor1);
        imageViewPillsMor2 = findViewById(R.id.imageViewPillsMor2);
        imageViewPillsAft1 = findViewById(R.id.imageViewPillsAft1);
        imageViewPillsAft2 = findViewById(R.id.imageViewPillsAft2);
        imageViewPillsEve1 = findViewById(R.id.imageViewPillsEve1);
        imageViewPillsEve2 = findViewById(R.id.imageViewPillsEve2);
        imageViewPillsNight1 = findViewById(R.id.imageViewPillsNight1);
        imageViewPillsNight2 = findViewById(R.id.imageViewPillsNight2);


        recyclerViewPillsFavourites = findViewById(R.id.recyclerViewPillsFavourite);
        recyclerViewPillsFavourites.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerViewPillsFavourites.setHasFixedSize(true);
        pillsReminderFavouriteAdapter = new PillsReminderFavouriteAdapter(getApplicationContext(),this);
        recyclerViewPillsFavourites.setAdapter(pillsReminderFavouriteAdapter);
    }

    @Override
    public void onClick(View v) {

        constraintLayoutPillsMorning.setBackgroundResource(R.drawable.btn_circle_white1);
        textViewPillsMorning.setTextColor(getResources().getColor(R.color.black));
        imageViewPillsMor1.setImageResource(R.drawable.pills_blue);
        imageViewPillsMor2.setImageResource(R.drawable.circle_orange);

        constraintLayoutPillsAfternoon.setBackgroundResource(R.drawable.btn_circle_white1);
        textViewPillsAfternoon.setTextColor(getResources().getColor(R.color.black));
        imageViewPillsAft1.setImageResource(R.drawable.pills_orange);
        imageViewPillsAft2.setImageResource(R.drawable.circle_blue);

        constraintLayoutPillsEvening.setBackgroundResource(R.drawable.btn_circle_white1);
        textViewPillsEvening.setTextColor(getResources().getColor(R.color.black));
        imageViewPillsEve1.setImageResource(R.drawable.ic_syringe);
        imageViewPillsEve2.setImageResource(R.drawable.circle_orange);

        constraintLayoutPillsNight.setBackgroundResource(R.drawable.btn_circle_white1);
        textViewPillsNight.setTextColor(getResources().getColor(R.color.black));
        imageViewPillsNight1.setImageResource(R.drawable.pills_blue);
        imageViewPillsNight2.setImageResource(R.drawable.circle_red);

        textViewPillsMorning.setTextColor(getResources().getColor(R.color.black));
        textViewPillsAfternoon.setTextColor(getResources().getColor(R.color.black));
        textViewPillsEvening.setTextColor(getResources().getColor(R.color.black));
        textViewPillsNight.setTextColor(getResources().getColor(R.color.black));

        switch (v.getId()) {
            case R.id.constraintLayoutPillsMorning:
                constraintLayoutPillsMorning.setBackgroundResource(R.drawable.btn_circle_blue1);
                textViewPillsMorning.setTextColor(getResources().getColor(R.color.white));
                imageViewPillsMor1.setImageResource(R.drawable.pills_white);
                imageViewPillsMor2.setImageResource(R.drawable.circle_white);
                break;

            case R.id.constraintLayoutPillsAfternoon:
                constraintLayoutPillsAfternoon.setBackgroundResource(R.drawable.btn_circle_blue1);
                textViewPillsAfternoon.setTextColor(getResources().getColor(R.color.white));
                imageViewPillsAft1.setImageResource(R.drawable.pills_white);
                imageViewPillsAft2.setImageResource(R.drawable.circle_white);
                break;

            case R.id.constraintLayoutPillsEvening:
                constraintLayoutPillsEvening.setBackgroundResource(R.drawable.btn_circle_blue1);
                textViewPillsEvening.setTextColor(getResources().getColor(R.color.white));
                imageViewPillsEve1.setImageResource(R.drawable.ic_syringe_white);
                imageViewPillsEve2.setImageResource(R.drawable.circle_white);
                break;

            case R.id.constraintLayoutPillsNight:
                constraintLayoutPillsNight.setBackgroundResource(R.drawable.btn_circle_blue1);
                textViewPillsNight.setTextColor(getResources().getColor(R.color.white));
                imageViewPillsNight1.setImageResource(R.drawable.pills_white);
                imageViewPillsNight2.setImageResource(R.drawable.circle_white);
                break;
        }


    }

    @Override
    public void onFavouriteItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(),MedicinesActivity.class);
        startActivity(intent);
    }
}
