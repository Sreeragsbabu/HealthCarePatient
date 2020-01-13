package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcarepatient.data_models.Country;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout constraintLayoutCountry,constraintLayoutNext;

    TextView textViewCountry, textViewCode;
    EditText editText;

    static Country country = new Country("India", "+91");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent i = getIntent();

        constraintLayoutCountry = findViewById(R.id.constraintLayout_Select_country);
        constraintLayoutNext = findViewById(R.id.constraintLayout_next);
        textViewCountry = findViewById(R.id.textView_country);
        textViewCode = findViewById(R.id.textView_code);
        editText = findViewById(R.id.editTextPhoneNumber);

        textViewCountry.setText(country.getCountryname());
        textViewCode.setText(country.getCountrycode().toString());


        constraintLayoutCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        constraintLayoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = editText.getText().toString().trim();

                if (phoneNo.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter phone number",Toast.LENGTH_SHORT).show();
                }
                else if (phoneNo.length()!= 10) {
                    Toast.makeText(getApplicationContext(),"Enter valid phone number",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);
                    intent.putExtra("Phone_No", phoneNo);
                    startActivity(intent);
                }
            }
        });
    }

}
