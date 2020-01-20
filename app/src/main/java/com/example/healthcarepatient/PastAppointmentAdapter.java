package com.example.healthcarepatient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class PastAppointmentAdapter extends RecyclerView.Adapter<PastAppointmentAdapter.PastAppointmentViewHolder>{

    Context context;
    FragmentManager fragmentManager;

    public PastAppointmentAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }





    @NonNull
    @Override
    public PastAppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.past_appts_item,parent,false);
        return new PastAppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastAppointmentViewHolder holder, final int position) {
        holder.constraintLayoutRebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Rebook Appointment",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class PastAppointmentViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayoutRebook;

        public PastAppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayoutRebook = itemView.findViewById(R.id.constraintLayout_Rebook);
        }
    }


}
