package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MerchantPay extends AppCompatActivity implements View.OnClickListener{
    Button next;
    ImageView back_btn;
    EditText pin, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_pay);

        next = findViewById(R.id.next_btn);
        amount = findViewById(R.id.amount);
        amount.setEnabled(false);
        next.setOnClickListener(this);

        back_btn = findViewById(R.id.air2back_btn);
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.air2back_btn:i = new Intent(MerchantPay.this, Merchant.class);
                startActivity(i);
                break;
            case R.id.next_btn:i = new Intent(MerchantPay.this, Success.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
