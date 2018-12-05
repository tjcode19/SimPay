package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmOTP extends AppCompatActivity {
    EditText otp;
    TextView resOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_otp);

        Button cotp = findViewById(R.id.confirmotp_btn);
        otp = findViewById(R.id.otp_input);
        resOTP = findViewById(R.id.resendOTP_txt);

        cotp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String otpS = otp.getText().toString();

                if(!otpS.isEmpty()){
                    Intent i = new Intent(ConfirmOTP.this, NewPassword.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(ConfirmOTP.this, NewPassword.class);
                    startActivity(i);
                }
            }
        });
        resOTP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ConfirmOTP.this, ResetPassword.class);
                startActivity(i);
            }
        });

    }

}
