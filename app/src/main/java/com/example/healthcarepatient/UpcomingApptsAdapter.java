package com.example.healthcarepatient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingApptsAdapter extends RecyclerView.Adapter<UpcomingApptsAdapter.UpcomingViewHolder>{

    @NonNull
    @Override
    public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_appts_item,parent,false);
        return new UpcomingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class UpcomingViewHolder extends RecyclerView.ViewHolder {

        public UpcomingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
