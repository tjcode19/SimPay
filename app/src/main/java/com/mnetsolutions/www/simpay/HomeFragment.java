package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private CardView airtime, internet, lotto, mobile_money, tv, utilities, qrcode;
    private ImageView logout, qrcode_img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        airtime = view.findViewById(R.id.airtime);
        internet = view.findViewById(R.id.internet);
        lotto = view.findViewById(R.id.lotto);
        mobile_money = view.findViewById(R.id.mobile_money);
        tv = view.findViewById(R.id.tv);
        utilities = view.findViewById(R.id.utilities);
        logout = view.findViewById(R.id.air2back_btn);
        qrcode = view.findViewById(R.id.QRCode);
        qrcode_img = view.findViewById(R.id.QRCode_img);


        //Set click listener
        airtime.setOnClickListener(this);
        internet.setOnClickListener(this);
        lotto.setOnClickListener(this);
        mobile_money.setOnClickListener(this);
        tv.setOnClickListener(this);
        utilities.setOnClickListener(this);
        logout.setOnClickListener(this);
        qrcode.setOnClickListener(this);
        qrcode_img.setOnClickListener(this);


        return view;


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.airtime:i = new Intent(getActivity(), AirTime.class);
                startActivity(i);
                break;
            case R.id.air2back_btn:i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
                break;
            case R.id.QRCode:i = new Intent(getActivity(), QRScanner.class);
                startActivity(i);
                break;
            case R.id.QRCode_img:i = new Intent(getActivity(), QRScanner.class);
                startActivity(i);
                break;
            default: break;
        }

    }
}
