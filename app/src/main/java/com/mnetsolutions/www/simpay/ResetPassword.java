package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        final EditText phoneNumber = findViewById(R.id.phoneNumber);
        Button next = findViewById(R.id.next_btn);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String number = phoneNumber.getText().toString();

                if(!number.isEmpty()){
                    Intent i = new Intent(ResetPassword.this, ConfirmOTP.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(ResetPassword.this, ConfirmOTP.class);
                    startActivity(i);
                }
            }
        });
    }
}
