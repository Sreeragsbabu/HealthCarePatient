package com.example.healthcarepatient;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;

public class TimeSlotActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textViewDate,textViewToday;

    private boolean expandedM,expandedA,expandedE = false;
    private boolean bm1 = false;

    private int check=0;

    ConstraintLayout morning,afternoon,evening,constraintLayoutContinue;
    ConstraintLayout morninghide,afternoonhide,eveninghide;
    ConstraintLayout m1,m2,m3,m4,m5,m6,m7,m8;
    ConstraintLayout a1,a2,a3,a4,a5,a6,a7,a8;
    ConstraintLayout e1,e2,e3,e4,e5,e6,e7,e8;

    TextView tm1,tm2,tm3,tm4,tm5,tm6,tm7,tm8;
    TextView ta1,ta2,ta3,ta4,ta5,ta6,ta7,ta8;
    TextView te1,te2,te3,te4,te5,te6,te7,te8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        textViewDate = findViewById(R.id.textViewDate);
        textViewToday = findViewById(R.id.textViewToday);

        Calendar endDate = Calendar.getInstance(TimeZone.getTimeZone("IST"));
        endDate.add(Calendar.YEAR,1);
        Calendar startDate = Calendar.getInstance(TimeZone.getTimeZone("IST"));
        startDate.add(Calendar.WEEK_OF_MONTH,-1);
        Date selectDate =  new Date();

        textViewToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        final HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this,R.id.calendarView).startDate(startDate.getTime()).endDate(endDate.getTime())
                .datesNumberOnScreen(5).showMonthName(false).textColor(Color.DKGRAY,Color.WHITE)
                .selectorColor(Color.parseColor("#1976d2"))
                .textSizeDayNumber(18).textSizeDayName(14)
                .defaultSelectedDate(selectDate)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Date date, int position) {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
                textViewDate.setText(dateFormat.format(date));

            }
        });

        morning = findViewById(R.id.morning);
        afternoon = findViewById(R.id.afternoon);
        evening = findViewById(R.id.evening);
        constraintLayoutContinue = findViewById(R.id.constraintlayoutContinue);

        morninghide = findViewById(R.id.constraintlayout_morning_hide);
        afternoonhide = findViewById(R.id.constraintlayout_afternoon_hide);
        eveninghide = findViewById(R.id.constraintlayout_evening_hide);

        init();

        constraintLayoutContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check ==1) {
                    Intent intent = new Intent(getApplicationContext(),BookAppointmentActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"select one time slot",Toast.LENGTH_SHORT).show();
                }


            }
        });


        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandedM) {
                    morninghide.setVisibility(View.GONE);
                    expandedM = !expandedM;
                }else {
                    morninghide.setVisibility(View.VISIBLE);
                    expandedM = !expandedM;
                }

            }
        });

        afternoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandedA) {
                    afternoonhide.setVisibility(View.GONE);
                    expandedA = !expandedA;
                }else {
                    afternoonhide.setVisibility(View.VISIBLE);
                    expandedA = !expandedA;

                }
            }
        });

        evening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandedE) {
                    eveninghide.setVisibility(View.GONE);
                    expandedE = !expandedE;
                }else {
                    eveninghide.setVisibility(View.VISIBLE);
                    expandedE = !expandedE;
                }
            }
        });


        m1 = findViewById(R.id.morningT1);
        m1.setOnClickListener(this);
        m2 = findViewById(R.id.morningT2);
        m2.setOnClickListener(this);
        m3 = findViewById(R.id.morningT3);
        m3.setOnClickListener(this);
        m4 = findViewById(R.id.morningT4);
        m4.setOnClickListener(this);
        m5 = findViewById(R.id.morningT5);
        m5.setOnClickListener(this);
        m6 = findViewById(R.id.morningT6);
        m6.setOnClickListener(this);
        m7 = findViewById(R.id.morningT7);
        m7.setOnClickListener(this);
        m8 = findViewById(R.id.morningT8);
        m8.setOnClickListener(this);

        a1 = findViewById(R.id.afternoonT1);
        a1.setOnClickListener(this);
        a2 = findViewById(R.id.afternoonT2);
        a2.setOnClickListener(this);
        a3 = findViewById(R.id.afternoonT3);
        a3.setOnClickListener(this);
        a4 = findViewById(R.id.afternoonT4);
        a4.setOnClickListener(this);
        a5 = findViewById(R.id.afternoonT5);
        a5.setOnClickListener(this);
        a6 = findViewById(R.id.afternoonT6);
        a6.setOnClickListener(this);
        a7 = findViewById(R.id.afternoonT7);
        a7.setOnClickListener(this);
        a8 = findViewById(R.id.afternoonT8);
        a8.setOnClickListener(this);

        e1 = findViewById(R.id.eveningT1);
        e1.setOnClickListener(this);
        e2 = findViewById(R.id.eveningT2);
        e2.setOnClickListener(this);
        e3 = findViewById(R.id.eveningT3);
        e3.setOnClickListener(this);
        e4 = findViewById(R.id.eveningT4);
        e4.setOnClickListener(this);
        e5 = findViewById(R.id.eveningT5);
        e5.setOnClickListener(this);
        e6 = findViewById(R.id.eveningT6);
        e6.setOnClickListener(this);
        e7 = findViewById(R.id.eveningT7);
        e7.setOnClickListener(this);
        e8 = findViewById(R.id.eveningT8);
        e8.setOnClickListener(this);

        tm1 = findViewById(R.id.textViewm1);
        tm2 = findViewById(R.id.textViewm2);
        tm3 = findViewById(R.id.textViewm3);
        tm4 = findViewById(R.id.textViewm4);
        tm5 = findViewById(R.id.textViewm5);
        tm6 = findViewById(R.id.textViewm6);
        tm7 = findViewById(R.id.textViewm7);
        tm8 = findViewById(R.id.textViewm8);

        ta1 = findViewById(R.id.textViewaf1);
        ta2 = findViewById(R.id.textViewaf2);
        ta3 = findViewById(R.id.textViewaf3);
        ta4 = findViewById(R.id.textViewaf4);
        ta5 = findViewById(R.id.textViewaf5);
        ta6 = findViewById(R.id.textViewaf6);
        ta7 = findViewById(R.id.textViewaf7);
        ta8 = findViewById(R.id.textViewaf8);

        te1 = findViewById(R.id.textViewe1);
        te2 = findViewById(R.id.textViewe2);
        te3 = findViewById(R.id.textViewe3);
        te4 = findViewById(R.id.textViewe4);
        te5 = findViewById(R.id.textViewe5);
        te6 = findViewById(R.id.textViewe6);
        te7 = findViewById(R.id.textViewe7);
        te8 = findViewById(R.id.textViewe8);

    }

    public void init() {
        morninghide.setVisibility(View.GONE);
        afternoonhide.setVisibility(View.GONE);
        eveninghide.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View v) {

        check =0;
        m1.setBackgroundResource(R.drawable.time_box_grey);
        m2.setBackgroundResource(R.drawable.time_box_grey);
        m3.setBackgroundResource(R.drawable.time_box_grey);
        m4.setBackgroundResource(R.drawable.time_box_grey);
        m5.setBackgroundResource(R.drawable.time_box_grey);
        m6.setBackgroundResource(R.drawable.time_box_grey);
        m7.setBackgroundResource(R.drawable.time_box_grey);
        m8.setBackgroundResource(R.drawable.time_box_grey);

        a1.setBackgroundResource(R.drawable.time_box_grey);
        a2.setBackgroundResource(R.drawable.time_box_grey);
        a3.setBackgroundResource(R.drawable.time_box_grey);
        a4.setBackgroundResource(R.drawable.time_box_grey);
        a5.setBackgroundResource(R.drawable.time_box_grey);
        a6.setBackgroundResource(R.drawable.time_box_grey);
        a7.setBackgroundResource(R.drawable.time_box_grey);
        a8.setBackgroundResource(R.drawable.time_box_grey);

        e1.setBackgroundResource(R.drawable.time_box_grey);
        e2.setBackgroundResource(R.drawable.time_box_grey);
        e3.setBackgroundResource(R.drawable.time_box_grey);
        e4.setBackgroundResource(R.drawable.time_box_grey);
        e5.setBackgroundResource(R.drawable.time_box_grey);
        e6.setBackgroundResource(R.drawable.time_box_grey);
        e7.setBackgroundResource(R.drawable.time_box_grey);
        e8.setBackgroundResource(R.drawable.time_box_grey);

        tm1.setTextColor(getResources().getColor(R.color.black));
        tm2.setTextColor(getResources().getColor(R.color.light_black));
        tm3.setTextColor(getResources().getColor(R.color.black));
        tm4.setTextColor(getResources().getColor(R.color.light_black));
        tm5.setTextColor(getResources().getColor(R.color.light_black));
        tm6.setTextColor(getResources().getColor(R.color.black));
        tm7.setTextColor(getResources().getColor(R.color.light_black));
        tm8.setTextColor(getResources().getColor(R.color.black));

        ta1.setTextColor(getResources().getColor(R.color.black));
        ta2.setTextColor(getResources().getColor(R.color.light_black));
        ta3.setTextColor(getResources().getColor(R.color.black));
        ta4.setTextColor(getResources().getColor(R.color.light_black));
        ta5.setTextColor(getResources().getColor(R.color.light_black));
        ta6.setTextColor(getResources().getColor(R.color.black));
        ta7.setTextColor(getResources().getColor(R.color.light_black));
        tm1.setTextColor(getResources().getColor(R.color.black));


        te1.setTextColor(getResources().getColor(R.color.black));
        te2.setTextColor(getResources().getColor(R.color.light_black));
        te3.setTextColor(getResources().getColor(R.color.black));
        te4.setTextColor(getResources().getColor(R.color.light_black));
        te5.setTextColor(getResources().getColor(R.color.light_black));
        te6.setTextColor(getResources().getColor(R.color.black));
        te7.setTextColor(getResources().getColor(R.color.light_black));
        te8.setTextColor(getResources().getColor(R.color.black));





        switch (v.getId()) {

            case R.id.morningT1:
                if (!bm1) {
                    m1.setBackgroundResource(R.drawable.underline_blue);
                    tm1.setTextColor(getResources().getColor(R.color.white));
                    bm1 = !bm1;
                    check++;
                }
                else {
                    m1.setBackgroundResource(R.drawable.time_box_grey);
                    tm1.setTextColor(getResources().getColor(R.color.black));
                    bm1 = !bm1;
                    check--;
                }
                break;
            case R.id.morningT2:
                m2.setBackgroundResource(R.drawable.underline_blue);
                tm2.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.morningT3:
                m3.setBackgroundResource(R.drawable.underline_blue);
                tm3.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.morningT4:
                m4.setBackgroundResource(R.drawable.underline_blue);
                tm4.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.morningT5:
                m5.setBackgroundResource(R.drawable.underline_blue);
                tm5.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.morningT6:
                m6.setBackgroundResource(R.drawable.underline_blue);
                tm6.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.morningT7:
                m7.setBackgroundResource(R.drawable.underline_blue);
                tm7.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.morningT8:
                m8.setBackgroundResource(R.drawable.underline_blue);
                tm8.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;

            case R.id.afternoonT1:
                a1.setBackgroundResource(R.drawable.underline_blue);
                ta1.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT2:
                a2.setBackgroundResource(R.drawable.underline_blue);
                ta2.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT3:
                a3.setBackgroundResource(R.drawable.underline_blue);
                ta3.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT4:
                a4.setBackgroundResource(R.drawable.underline_blue);
                ta4.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT5:
                a5.setBackgroundResource(R.drawable.underline_blue);
                ta5.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT6:
                a6.setBackgroundResource(R.drawable.underline_blue);
                ta6.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT7:
                a7.setBackgroundResource(R.drawable.underline_blue);
                ta7.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.afternoonT8:
                a8.setBackgroundResource(R.drawable.underline_blue);
                ta8.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;

            case R.id.eveningT1:
                e1.setBackgroundResource(R.drawable.underline_blue);
                te1.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT2:
                e2.setBackgroundResource(R.drawable.underline_blue);
                te2.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT3:
                e3.setBackgroundResource(R.drawable.underline_blue);
                te3.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT4:
                te4.setBackgroundResource(R.drawable.underline_blue);
                ta8.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT5:
                e5.setBackgroundResource(R.drawable.underline_blue);
                te5.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT6:
                e6.setBackgroundResource(R.drawable.underline_blue);
                te6.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT7:
                e7.setBackgroundResource(R.drawable.underline_blue);
                te7.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;
            case R.id.eveningT8:
                e8.setBackgroundResource(R.drawable.underline_blue);
                te8.setTextColor(getResources().getColor(R.color.white));
                check++;
                break;

        }

    }
}
