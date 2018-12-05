package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button next_btn;
    private TextView login_txt;
    private Spinner language_spin, server_spin;
    private String lang_val, server_val;

    String[] countryNames={"Uganda","Nigeria"};
    int flags[] = {R.drawable.flag_uganda, R.drawable.flag_nigeria};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        server_spin = findViewById(R.id.server);
        server_spin.setOnItemSelectedListener(this);

        language_spin = findViewById(R.id.language);
        language_spin.setOnItemSelectedListener(this);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,countryNames);
        server_spin.setAdapter(customAdapter);

        next_btn = findViewById(R.id.next);
        login_txt = findViewById(R.id.login);

        addLanguages();

        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Register_2.class);
                startActivity(i);
            }
        });

        login_txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

        lang_val = language_spin.getSelectedItem().toString();
        server_val = language_spin.getSelectedItem().toString();
        //Toast.makeText(getApplicationContext(), lang_val + "//"+ id , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    // add items into spinner dynamically
    public void addLanguages() {

        //nooofyears = (Spinner) findViewById(R.id.no_of_years);
        List<String> list = new ArrayList<String>();
        list.add("English");
        list.add("French");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_cus_style, list);
       // dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language_spin.setAdapter(dataAdapter);
    }
}
