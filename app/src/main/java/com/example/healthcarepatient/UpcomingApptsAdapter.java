package com.example.healthcarepatient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingApptsAdapter extends RecyclerView.Adapter<UpcomingApptsAdapter.UpcomingViewHolder>{
    Context context;
    FragmentManager fragmentManager;

    public UpcomingApptsAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_appts_item,parent,false);
        return new UpcomingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position) {

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpcomingViewHolder.bottomSheetAppointment.show(fragmentManager,"bottomsheet");
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class UpcomingViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        static BottomSheetAppointment bottomSheetAppointment;

        public UpcomingViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewDetails);
            bottomSheetAppointment = new BottomSheetAppointment();
        }
    }
}
