package com.example.healthcarepatient;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class EHR_Myfiles_Fragment extends Fragment{

    FloatingActionButton floatingActionButton_ehr;
    BottomsheetEhrAddRecord bottomsheetEhrAddRecord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_ehr__myfiles_,container,false);

        floatingActionButton_ehr = v.findViewById(R.id.fab_ehr);
        floatingActionButton_ehr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheetEhrAddRecord = new BottomsheetEhrAddRecord();
                bottomsheetEhrAddRecord.show(getFragmentManager(),"BottomSheetEhrAddRecord");

            }
        });

        return v;
    }


}
