package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UploadRecordActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout constraintLayoutRecordHolder,constraintLayoutUploadRecord;
    ConstraintLayout constraintLayoutReport,constraintLayoutPrescription,constraintLayoutLabTest;
    ImageView imageViewAddMore,imageViewClose;
    ImageView imageViewReport,imageViewPrescription,imageViewLabTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_record);

        constraintLayoutRecordHolder = findViewById(R.id.constraintLayout_record_holder);
        constraintLayoutUploadRecord = findViewById(R.id.Upload_record);
        constraintLayoutReport = findViewById(R.id.Upload_record);
        constraintLayoutPrescription = findViewById(R.id.Upload_record);
        constraintLayoutLabTest = findViewById(R.id.Upload_record);
        imageViewAddMore = findViewById(R.id.imageView_add_more);
        imageViewClose = findViewById(R.id.imageView_close);
        imageViewReport = findViewById(R.id.imageViewRepot);
        imageViewPrescription = findViewById(R.id.imageViewPrescription);
        imageViewLabTest = findViewById(R.id.imageViewLabTest);

        constraintLayoutRecordHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RecordForActivity.class);
                startActivity(intent);
            }
        });

        constraintLayoutUploadRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EHRActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.constraint_layout_report:

//                imageViewReport.setBackgroundResource(R.drawable.report_blue);
        }
    }
}
