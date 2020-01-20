package com.example.healthcarepatient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EhrSharedAdapter extends RecyclerView.Adapter<EhrSharedAdapter.EhrViewHolder> {

    Context context;
    private OnEhrListener onEhrListener;

    public EhrSharedAdapter(Context context,OnEhrListener onEhrListener) {
        this.context = context;
        this.onEhrListener = onEhrListener;
    }

    @NonNull
    @Override
    public EhrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ehr_shared_files_item,parent,false);
        return new EhrViewHolder(view,onEhrListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EhrViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public static class EhrViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnEhrListener onEhrListener;
        ImageView imageView_ehr_details;

        public EhrViewHolder(@NonNull View itemView, final OnEhrListener onEhrListener) {
            super(itemView);
            this.onEhrListener = onEhrListener;
            imageView_ehr_details = itemView.findViewById(R.id.imageViewEhr_details);

            imageView_ehr_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onEhrListener.onEhrDotClick(getAdapterPosition());
                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnEhrListener {
        void onEhrDotClick(int position);
    }
}
