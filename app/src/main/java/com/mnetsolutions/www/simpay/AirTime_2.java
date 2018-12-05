package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AirTime_2 extends AppCompatActivity {
    private TextView phone, network;
    private EditText amount, pin;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_time2);

        Button next_btn = findViewById(R.id.btn_next);
        ImageView back = findViewById(R.id.air2back_btn);
        phone = findViewById(R.id.phone_txt);
        network = findViewById(R.id.network_txt);
        amount = findViewById(R.id.amount_ro);
        pin = findViewById(R.id.card_pin);
        logo = findViewById(R.id.logo_img);

        Intent intent = getIntent();
        String ph = intent.getStringExtra("phone");
        String amt = intent.getStringExtra("amount");
        String netw = intent.getStringExtra("net");

        phone.setText(ph);
        amount.setText("NGN "+amt);
        network.setText(netw);
        setLogo(netw);

        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String card_pin = pin.getText().toString();
                if(isValidated(card_pin)) {
                    Intent i = new Intent(AirTime_2.this, Success.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(AirTime_2.this, "Enter Card PIN", Toast.LENGTH_LONG).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(AirTime_2.this, AirTime.class);
                startActivity(i);
            }
        });
    }

    private boolean isValidated(String pin){

        if(pin.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    private void setLogo(String net){
//        Toast.makeText(this, net, Toast.LENGTH_SHORT).show();
        switch (net){
            case "MTN":
                logo.setBackgroundResource(R.drawable.mtn);
                break;
            case "Airtel":
                logo.setBackgroundResource(R.drawable.airtel);
                break;
            case "9Mobile":
                logo.setBackgroundResource(R.mipmap.mobile);
                break;
            case "Glo":
                logo.setBackgroundResource(R.drawable.glo);
                break;
            default:
                break;
        }
    }
}
