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

public class SalesFragment extends Fragment implements View.OnClickListener {

    private CardView airtime, internet, lotto, mobile_money, tv, utilities;
    private ImageView logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales, container, false);

        logout = view.findViewById(R.id.air2back_btn);
        logout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.air2back_btn:i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
                break;
            case R.id.back_arr:i = new Intent(getActivity(), Dashboard.class);
                startActivity(i);
                break;
            default: break;
        }

    }

}
