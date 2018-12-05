package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Merchant extends AppCompatActivity implements View.OnClickListener {

    ImageView back_btn;
    Button next;
    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        back_btn = findViewById(R.id.air2back_btn);
        next = findViewById(R.id.next_btn);
        amount = findViewById(R.id.amount);

        back_btn.setOnClickListener(this);
        next.setOnClickListener(this);

        String barcode = getIntent().getStringExtra("code"); //retrieve scanned code
        Toast.makeText(getApplicationContext(), barcode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.air2back_btn:i = new Intent(Merchant.this, Dashboard.class);
                startActivity(i);
                break;
            case R.id.next_btn:
                if(isValidated()){
                    i = new Intent(Merchant.this, MerchantPay.class);
                    startActivity(i);
                }
                else{

                }
                break;
        }
    }

    private boolean isValidated(){
        return true;
    }
}
