package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AirTime extends AppCompatActivity implements View.OnClickListener {

    CardView mtn, glo, airtel, mobile;
    TextView mtn_txt, glo_txt, airtel_txt, mobile_txt;
    private EditText phone, amount;
    private String network = "";
    LinearLayout mtnL;
    private final static int RESULT_PICK_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_time);

        mtn = findViewById(R.id.mtn);
        glo = findViewById(R.id.glo);
        airtel = findViewById(R.id.airtel);
        mobile = findViewById(R.id.mobile);
        ImageView cont = findViewById(R.id.contacts);
        phone = findViewById(R.id.phone);
        amount = findViewById(R.id.amount);
        mtnL = findViewById(R.id.mtnL);

        mtn_txt = findViewById(R.id.mtn_txt);
        glo_txt = findViewById(R.id.glo_txt);
        airtel_txt = findViewById(R.id.airtel_txt);
        mobile_txt = findViewById(R.id.mobile_txt);

        mtn.setOnClickListener(this);
        glo.setOnClickListener(this);
        airtel.setOnClickListener(this);
        mobile.setOnClickListener(this);

        cont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                readContact();
            }
        });

        Button next_btn = findViewById(R.id.btn_next);
        ImageView back = findViewById(R.id.air2back_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String ph, amt;
                ph = phone.getText().toString();
                amt = amount.getText().toString();
                if(isValidated(ph,amt, network)){
                    Intent i = new Intent(AirTime.this, AirTime_2.class);
                    i.putExtra("phone", ph);
                    i.putExtra("amount", amt);
                    i.putExtra("net", network);
                    startActivity(i);
                }
                else{
                    Toast.makeText(AirTime.this, "Enter phone number and amount", Toast.LENGTH_LONG).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(AirTime.this, Dashboard.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mtn:
               // mtn.setCardBackgroundColor(getResources().getColor(R.color.colorOrange));
                mtn.setBackground(getResources().getDrawable(R.drawable.card_bg));
                network = "MTN";

                glo.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                airtel.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                mobile.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                break;

            case R.id.glo:
                glo.setBackground(getResources().getDrawable(R.drawable.card_bg));
                network = "Glo";

                mtn.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                airtel.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                mobile.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                break;

            case R.id.airtel:
                airtel.setBackground(getResources().getDrawable(R.drawable.card_bg));
                network = "Airtel";

                mtn.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                glo.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                mobile.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                break;

            case R.id.mobile:
                mobile.setBackground(getResources().getDrawable(R.drawable.card_bg));
                network = "9Mobile";

                mtn.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                glo.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                airtel.setBackground(getResources().getDrawable(R.drawable.unset_card_bg));
                break;

            default: break;
        }

    }



    public void readContact(){
        try {
            Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            startActivityForResult(contactPickerIntent,
                    RESULT_PICK_CONTACT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_PICK_CONTACT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                contactPicked(data);
            }
        }
    }

    private void contactPicked(Intent data) {
        Cursor cursor = null;
        try {
            String phoneNo = null ;
            // getData() method will have the Content Uri of the selected contact
            Uri uri = data.getData();
            //Query the content uri
            cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            // column index of the phone number
            int  phoneIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            phoneNo = cursor.getString(phoneIndex);
            phoneNo=phoneNo.replaceAll("\\s+","");
            phone.setText(phoneNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValidated(String ph, String amt, String nt){

        if(ph.isEmpty() || amt.isEmpty() || nt.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }


}
