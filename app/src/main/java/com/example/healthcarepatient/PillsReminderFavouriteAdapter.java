package com.example.healthcarepatient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PillsReminderFavouriteAdapter extends RecyclerView.Adapter<PillsReminderFavouriteAdapter.PillsReminderFavouriteViewHolder> {

    Context context;
    private OnFavouriteItemListener newOnFavouriteItemListener;

    public PillsReminderFavouriteAdapter(Context context,OnFavouriteItemListener onFavouriteItemListener) {
        this.context = context;
        this.newOnFavouriteItemListener = onFavouriteItemListener;
    }

    @NonNull
    @Override
    public PillsReminderFavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pills_favourites_item,parent,false);
        return new PillsReminderFavouriteViewHolder(view,newOnFavouriteItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PillsReminderFavouriteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class PillsReminderFavouriteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        OnFavouriteItemListener onFavouriteItemListener;
        public PillsReminderFavouriteViewHolder(@NonNull View itemView,OnFavouriteItemListener onFavouriteItemListener) {
            super(itemView);
            this.onFavouriteItemListener = onFavouriteItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onFavouriteItemListener.onFavouriteItemClick(getAdapterPosition());
        }
    }

    public interface OnFavouriteItemListener {
        void onFavouriteItemClick(int position);
    }
}
