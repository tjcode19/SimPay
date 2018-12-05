package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPassword extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        final EditText nPass = findViewById(R.id.editText_pass);
        final EditText cPass = findViewById(R.id.editText_cp);
        Button next = findViewById(R.id.newPass_btn);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String npass = nPass.getText().toString();
                String cpass = cPass.getText().toString();

                if(!npass.isEmpty() && !cpass.isEmpty()){
                    Intent i = new Intent(NewPassword.this, Success.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(NewPassword.this, Error.class);
                    startActivity(i);
                }
            }
        });
    }
}
