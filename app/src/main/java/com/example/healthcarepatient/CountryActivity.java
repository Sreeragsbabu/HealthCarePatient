package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthcarepatient.data_models.Country;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCountry;
    CountryAdapter countryAdapter;
    Context context;
    ConstraintLayout constraintLayout;
    EditText searchText;
    private String stringSearch;
    private TextView countryName,countryCode;

    Country c1 = new Country("India", "+91");
    Country c2 = new Country("Afghanistan", "+93");
    Country c3 = new Country("Albania", "+355");
    Country c4 = new Country("Algeria", "+213");
    Country c5 = new Country("American Samoa", "+1-684");
    Country c6 = new Country("Andorra", "+376");
    Country c7 = new Country("Brazil", "+55");
    Country c8 = new Country("China", "+53");
    Country c9 = new Country("Croatia", "+293");
    Country c10 = new Country("Denmark", "+9443");

    ArrayList<Country> countries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countries.add(c4);
        countries.add(c5);
        countries.add(c6);
        countries.add(c7);
        countries.add(c8);
        countries.add(c9);
        countries.add(c10);

        searchText = findViewById(R.id.editTextSearch);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringSearch = searchText.getText().toString().trim();
                filter(stringSearch);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        constraintLayout = findViewById(R.id.constraintLayoutBackButton);
         constraintLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onBackPressed();
             }
         });

        recyclerViewCountry = findViewById(R.id.recycler_country_id);
        recyclerViewCountry.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewCountry.setHasFixedSize(true);
        countryAdapter = new CountryAdapter(countries, getApplicationContext() );
        recyclerViewCountry.setAdapter(countryAdapter);

    }

    private void filter(String stringSearch) {
        ArrayList<Country> filteredCountries = new ArrayList<>();
        for (Country country : countries) {
            if (country.getCountryname().toLowerCase().contains(stringSearch.toLowerCase()) || country.getCountrycode().toLowerCase().contains(stringSearch.toLowerCase())) {
                filteredCountries.add(country);
            }
        }
        countryAdapter.filterList(filteredCountries);

    }
}
