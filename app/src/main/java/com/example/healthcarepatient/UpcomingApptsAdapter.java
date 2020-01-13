package com.example.healthcarepatient;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingApptsAdapter extends RecyclerView<UpcomingApptsAdapter.UpcomingViewHolder>{

    public UpcomingApptsAdapter(@NonNull Context context) {
        super(context);
    }

    public UpcomingApptsAdapter(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UpcomingApptsAdapter(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static class UpcomingViewHolder extends RecyclerView.ViewHolder {

        public UpcomingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
