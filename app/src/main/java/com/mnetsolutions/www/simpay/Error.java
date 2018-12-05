package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Error extends AppCompatActivity {

    private TextView dashboard;
    private ImageView dash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        dashboard = findViewById(R.id.return_dashboard);
        dash = findViewById(R.id.dashboard);

        dashboard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Error.this, Dashboard.class);
                startActivity(i);
            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Error.this, Dashboard.class);
                startActivity(i);
            }
        });
    }
}
