package com.example.healthcarepatient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcarepatient.data_models.Doctor;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.Console;
import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {


    ArrayList<Doctor> doctors;
    Context context;
    FragmentManager fragmentManager;

    public DoctorAdapter(ArrayList<Doctor> doctors, Context context, FragmentManager fragmentManager) {
        this.doctors = doctors;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_item,parent,false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DoctorViewHolder holder, int position) {
        holder.imageViewDoctor.setImageResource(doctors.get(position).getDoctorImage());
        holder.textview_doctor_name.setText(doctors.get(position).getDoctorName());
        holder.textview_category.setText(doctors.get(position).getDoctorCategory());
        holder.textView_google_api.setText(doctors.get(position).getGoogleApi());
        holder.textView_rating.setText(String.valueOf(doctors.get(position).getDoctorRating()));
        holder.textView_likes.setText(String.valueOf(doctors.get(position).getLikes()));
        holder.textView_likes_percentage.setText(String.valueOf("("+doctors.get(position).getLikePercentage()+")%"));
        holder.textView_call_book.setText(doctors.get(position).getCall());

        holder.constraintLayoutCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoctorViewHolder.bottomSheetBook.show(fragmentManager,"bottomsheet");
            }
        });

    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewDoctor;
        ConstraintLayout constraintLayoutCall;
        TextView textview_doctor_name, textview_category, textView_google_api, textView_rating, textView_years, textView_likes,
                textView_likes_percentage,textView_call_book;

        static BottomSheetBook bottomSheetBook;


        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewDoctor = itemView.findViewById(R.id.imageview_doctor);
            textview_doctor_name = itemView.findViewById(R.id.textview_doctor_name);
            textview_category = itemView.findViewById(R.id.textview_category);
            textView_google_api = itemView.findViewById(R.id.textView_google_api);
            textView_rating = itemView.findViewById(R.id.textView_rating);
            textView_years = itemView.findViewById(R.id.textView_years);
            textView_likes = itemView.findViewById(R.id.textView_likes);
            textView_likes_percentage = itemView.findViewById(R.id.textView_likes_percentage);
            textView_call_book = itemView.findViewById(R.id.textView_call_book);
            constraintLayoutCall = itemView.findViewById(R.id.constraint_layout_call_book);
            bottomSheetBook = new BottomSheetBook();
        }
    }
}
