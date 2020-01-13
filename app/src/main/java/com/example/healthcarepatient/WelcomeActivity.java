package com.example.healthcarepatient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textViewAgree;

    TextView signUpTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textViewAgree = findViewById(R.id.agree_continue);

        textViewAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, StartActivity.class );
                startActivity(intent);
            }
        });

        SpannableString ss = new SpannableString("Tap \"Agree & Continue\" to accept the Patient Healthcare Terms of Service and Privacy Policy.");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(WelcomeActivity.this,TermsAndServicesActivity.class);
                startActivity(intent);
            }
        };

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(WelcomeActivity.this,PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpan,55,72, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpTerms = findViewById(R.id.terms_and_conditions);
        signUpTerms.setText(ss);
        signUpTerms.setMovementMethod(LinkMovementMethod.getInstance());
        signUpTerms.setHighlightColor(Color.TRANSPARENT);

        ss.setSpan(clickableSpan1,77,91,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpTerms = findViewById(R.id.terms_and_conditions);
        signUpTerms.setText(ss);
        signUpTerms.setMovementMethod(LinkMovementMethod.getInstance());
        signUpTerms.setHighlightColor(Color.TRANSPARENT);

    }
}
