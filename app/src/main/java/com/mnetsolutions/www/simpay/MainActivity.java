package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView signup, resetPass;
    String pass_val, user_val;
    private EditText user, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login);
        signup = findViewById(R.id.sign_up);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        resetPass = findViewById(R.id.resetPass);

        user_val = user.getText().toString();
        pass_val = pass.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isValidate()){doLogin();} //do login here
                else{


                    user.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_circle_white_24dp, 0);
                    //user.drawableRight="@drawable/ic_check_circle_white_24dp"
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        resetPass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResetPassword.class);
                startActivity(intent);
            }
        });
    }

    private Boolean isValidate(){
        if(user_val.isEmpty()){
            //do something here
            user.setError("Enter Username",getResources().getDrawable(R.drawable.bg_bn));
            return false;
        }
        else if(pass_val.isEmpty()){
            user.setError("Enter Password",getResources().getDrawable(R.drawable.bg_bn));
            return false;
        }
        else {
            return true;
        }
    }

    private void doLogin(){
        Intent intent = new Intent(MainActivity.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}
