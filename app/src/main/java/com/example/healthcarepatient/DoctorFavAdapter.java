package com.example.healthcarepatient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class DoctorFavAdapter extends RecyclerView.Adapter<DoctorFavAdapter.DoctorFavViewHolder> {
    Context context;

    public DoctorFavAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DoctorFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_doctors_item,parent,false);
        return new DoctorFavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorFavViewHolder holder, int position) {

        holder.imageViewFav_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure,you want to remove doctor from your favourite list?").setCancelable(false)
                        .setPositiveButton("REMOVE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"Removed ",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Alerts!");
                alert.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class DoctorFavViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewFav_doctor;

        public DoctorFavViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFav_doctor = itemView.findViewById(R.id.imageView_fav);

        }
    }
}
