package com.example.healthcarepatient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcarepatient.data_models.Country;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

    ArrayList<Country> countries;
    Context context;

    public CountryAdapter(ArrayList<Country> countries, Context context) {
        this.countries= countries;
        this.context = context;
    }
    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.cname.setText(countries.get(position).getCountryname());
        holder.ccode.setText(countries.get(position).getCountrycode());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                LoginActivity.country = countries.get(position);
                Intent i = new Intent(context, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void filterList(ArrayList<Country> filterdCountries) {
        countries = filterdCountries;
        notifyDataSetChanged();
    }


    public static class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemClickListener itemClickListener;

        private TextView cname, ccode;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            cname = itemView.findViewById(R.id.textView_country_name);
            ccode = itemView.findViewById(R.id.textView_country_code);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }
}
