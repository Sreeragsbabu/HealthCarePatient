package com.example.healthcarepatient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcarepatient.data_models.Patients;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    ArrayList<Patients> patients;
    Context context;

    public PatientAdapter(Context context,ArrayList<Patients> patients ) {
        this.patients = patients;
        this.context = context;
    }


    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_item,parent,false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {

        holder.imageViewPatient.setImageResource(patients.get(position).getPatient_image());
        holder.relation.setText(patients.get(position).getName());

        holder.constraintLayoutPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PatientDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class PatientViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayoutPatient;
        ImageView imageViewPatient;
        TextView relation;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPatient = itemView.findViewById(R.id.circleImageViewPatient);
            relation = itemView.findViewById(R.id.textViewRelation);
            constraintLayoutPatient = itemView.findViewById(R.id.constraintlayoutPatient);
        }
    }
        }