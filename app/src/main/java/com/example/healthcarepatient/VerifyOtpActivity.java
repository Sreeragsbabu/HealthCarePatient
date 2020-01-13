package com.example.healthcarepatient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class VerifyOtpActivity extends AppCompatActivity {


    public int counter = 30;
    ConstraintLayout constraintLayoutBackButton,constraintLayoutResendCode,constraintLayoutTimer;
    TextView phoneNumber,timer;
    TextView textViewEdit;

    EditText otp1,otp2,otp3,otp4,otp5,otp6;
    String stringOtp1, stringOtp2,stringOtp3,stringOtp4,stringOtp5,stringOtp6;
    int c1=1,c2=1,c3=1,c4=1,c5=1,c6=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        constraintLayoutResendCode = findViewById(R.id.constraintResendCode);
        constraintLayoutTimer = findViewById(R.id.constraintLayoutTimer);
        constraintLayoutResendCode.setVisibility(View.INVISIBLE);

        constraintLayoutResendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayoutResendCode.setVisibility(View.INVISIBLE);
                constraintLayoutTimer.setVisibility(View.VISIBLE);
                timer();
            }
        });

        final Intent intent = getIntent();

        String phoneNo = intent.getStringExtra("Phone_No");

        otp1 = findViewById(R.id.textViewOtp1);
        otp2 = findViewById(R.id.textViewOtp2);
        otp3 = findViewById(R.id.textViewOtp3);
        otp4 = findViewById(R.id.textViewOtp4);
        otp5 = findViewById(R.id.textViewOtp5);
        otp6 = findViewById(R.id.textViewOtp6);

        otp1.requestFocus();
        otp1.setCursorVisible(true);

        //.........................................................OTP1......................................................................................

        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    stringOtp1 = otp1.getText().toString().trim();
                    if (stringOtp1.length()==1) {
                        otp1.clearFocus();
                        otp2.requestFocus();
                        otp2.setCursorVisible(true);
                        c1++;
                    }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        otp1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && stringOtp1.length()==0) {
                    otp1.setCursorVisible(true);
                }
                return false;
            }
        });

        //...............................................................OTP2......................................................................................

        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringOtp2 = otp2.getText().toString().trim();
                if (stringOtp2.length()==1) {
                    otp2.clearFocus();
                    otp3.requestFocus();
                    otp3.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        otp2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && stringOtp2.length()==0) {
                    otp2.clearFocus();
                    otp1.requestFocus();
                    otp1.setCursorVisible(true);
                }
                return false;
            }
        });

        //.................................................OTP3.......................................................................................

        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringOtp3 = otp3.getText().toString().trim();
                if (stringOtp3.length()==1) {
                    otp3.clearFocus();
                    otp4.requestFocus();
                    otp4.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        otp3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && stringOtp3.length()==0) {
                    otp3.clearFocus();
                    otp2.requestFocus();
                    otp2.setCursorVisible(true);
                }
                return false;
            }
        });

        //.............................................................OTP4.........................................................................................

        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringOtp4 = otp4.getText().toString().trim();
                if (stringOtp4.length()==1) {
                    otp4.clearFocus();
                    otp5.requestFocus();
                    otp5.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && stringOtp4.length()==0) {
                    otp4.clearFocus();
                    otp3.requestFocus();
                    otp3.setCursorVisible(true);
                }
                return false;
            }
        });

        //........................................................OTP5................................................................................

        otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringOtp5 = otp5.getText().toString().trim();
                if (stringOtp5.length()==1) {
                    c5++;
                    otp5.clearFocus();
                    otp6.requestFocus();
                    otp6.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    otp5.clearFocus();
                    otp4.requestFocus();
                    otp4.setCursorVisible(true);
                }
                return false;
            }
        });

        //..........................................................OTP6..........................................................................

        otp6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringOtp6 = otp6.getText().toString().trim();
                if (stringOtp1.equals("1") && stringOtp2.equals("1") && stringOtp3.equals("1") && stringOtp4.equals("1") && stringOtp5.equals("1") && stringOtp6.equals("1") ) {
                    Toast.makeText(getApplicationContext(),"verified",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && stringOtp6.length()==0) {
                    otp6.clearFocus();
                    otp5.requestFocus();
                    otp5.setCursorVisible(true);
                }
                return false;
            }
        });

        //.....................................................***..................................................................................

        phoneNumber = findViewById(R.id.code_phone_textview);
        textViewEdit = findViewById(R.id.textViewEdit);
        timer = findViewById(R.id.textViewTimer);
        phoneNumber.setText(LoginActivity.country.getCountrycode() + " "+ phoneNo);

        timer();


        textViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        constraintLayoutBackButton = findViewById(R.id.constraintLayoutBackButton);
        constraintLayoutBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void timer() {
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("0"+String.format("%d:%d ",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                counter--;
            }

            @Override
            public void onFinish() {
                constraintLayoutTimer.setVisibility(View.INVISIBLE);
                constraintLayoutResendCode.setVisibility(View.VISIBLE);
            }

        }.start();
    }

}
