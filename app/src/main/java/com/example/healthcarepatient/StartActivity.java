package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.concurrent.TimeUnit;

public class StartActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout,constraintLayoutCircle1,constraintLayoutCircle2,constraintLayoutCircle3;

    private int index ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        constraintLayoutCircle1 = findViewById(R.id.circle1);
        constraintLayoutCircle2 = findViewById(R.id.circle2);
        constraintLayoutCircle3 = findViewById(R.id.circle3);


        final ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);
        constraintLayout = findViewById(R.id.getStarted);

        viewFlipper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                index = viewFlipper.getDisplayedChild();

                switch (index) {
                    case 0:
                        circle(index);
                        break;
                    case 1:
                        circle(index);
                        break;
                    case 2:
                        circle(index);
                        break;
                }
            }
        });

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
//                Toast.makeText(StartActivity.this,"getting Started", Toast.LENGTH_SHORT).show();
            }
        });

        constraintLayoutCircle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = viewFlipper.getDisplayedChild();
                viewFlipper.setDisplayedChild(0);
                circle(index);
            }
        });

        constraintLayoutCircle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = viewFlipper.getDisplayedChild();
                viewFlipper.setDisplayedChild(1);
                circle(index);
            }
        });

        constraintLayoutCircle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 index = viewFlipper.getDisplayedChild();
                 viewFlipper.setDisplayedChild(2);
                circle(index);
            }
        });

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_img_flipper));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(imageView);

        ImageView imageView1 = new ImageView(getApplicationContext());
        imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_img_flipper2));
        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(imageView1);

        ImageView imageView2 = new ImageView(getApplicationContext());
        imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_img_flipper1));
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(imageView2);

        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(3000);


    }

    public void circle(int index) {

        constraintLayoutCircle1.setBackgroundDrawable(ContextCompat.getDrawable(StartActivity.this, R.drawable.btn_circle_grey));
        constraintLayoutCircle2.setBackgroundDrawable(ContextCompat.getDrawable(StartActivity.this, R.drawable.btn_circle_grey));
        constraintLayoutCircle3.setBackgroundDrawable(ContextCompat.getDrawable(StartActivity.this, R.drawable.btn_circle_grey));

        switch (index) {
            case 0:
                constraintLayoutCircle1.setBackgroundDrawable(ContextCompat.getDrawable(StartActivity.this, R.drawable.btn_circle_blue));
                break;
            case 1:
                constraintLayoutCircle2.setBackgroundDrawable(ContextCompat.getDrawable(StartActivity.this, R.drawable.btn_circle_blue));
                break;
            case 2:
                constraintLayoutCircle3.setBackgroundDrawable(ContextCompat.getDrawable(StartActivity.this, R.drawable.btn_circle_blue));
                break;

        }
    }
}





