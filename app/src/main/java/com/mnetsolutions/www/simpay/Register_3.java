package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_3 extends AppCompatActivity {
    private Button complete_btn;
    private EditText pass, cpass;
    String passW, cpassW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister_3);

        complete_btn = findViewById(R.id.complete);
        pass = findViewById(R.id.passWord);
        cpass = findViewById(R.id.c_password);

        complete_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                passW = pass.getText().toString();
                cpassW = cpass.getText().toString();

                if(isValidated(passW, cpassW)){
                    Intent i = new Intent(Register_3.this, Dashboard.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(Register_3.this, Dashboard.class);
                    startActivity(i);
                }
            }
        });
    }

    private boolean isValidated(String p, String cp){
        if(p.isEmpty()){
            return false;
        }
        else if(cp.isEmpty()){
            return false;
        }
        else if(p!=cp){
            return false;
        }
        else {
            return true;
        }
    }
}
