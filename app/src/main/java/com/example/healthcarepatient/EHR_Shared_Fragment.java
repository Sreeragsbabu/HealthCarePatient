package com.example.healthcarepatient;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class EHR_Shared_Fragment extends Fragment implements EhrSharedAdapter.OnEhrListener {

    RecyclerView recyclerViewEhr;
    EhrSharedAdapter ehrSharedAdapter;
    ConstraintLayout constraintLayoutAddRecord;
    BottomsheetEhrAddRecord bottomsheetEhrAddRecord;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ehr__shared_,container,false);

        constraintLayoutAddRecord = v.findViewById(R.id.constraintLayoutAddRecord);
        constraintLayoutAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheetEhrAddRecord = new BottomsheetEhrAddRecord();
                bottomsheetEhrAddRecord.show(getFragmentManager(),"BottomSheetAddRecord");
            }
        });

        recyclerViewEhr = v.findViewById(R.id.recyclerView_ehr);
        recyclerViewEhr.setLayoutManager(new GridLayoutManager(getActivity(),1));
        recyclerViewEhr.setHasFixedSize(true);
        ehrSharedAdapter = new EhrSharedAdapter(getContext(),this);
        recyclerViewEhr.setAdapter(ehrSharedAdapter);
        return v;
    }

    @Override
    public void onEhrDotClick(int position) {
        Toast.makeText(getContext(),"details bottom sheet",Toast.LENGTH_SHORT).show();
    }


}
