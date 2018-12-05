package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Pattern;

public class Register_2 extends AppCompatActivity {
    private Button next_btn;
    private EditText creditCard, cardExp;
    static final Pattern CODE_PATTERN = Pattern.compile("([0-9]{0,4})|([0-9]{4}-)+|([0-9]{4}-[0-9]{0,4})+");
    TextView login;
    private static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_2);

        next_btn = findViewById(R.id.next);
        login = findViewById(R.id.login);

        creditCard = findViewById(R.id.card_number);
        cardExp = findViewById(R.id.card_exp_date);
        creditCard.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                Log.w("", "input" + s.toString());

                if (s.length() > 0 && !CODE_PATTERN.matcher(s).matches()) {
                    String input = s.toString();
                    String numbersOnly = keepNumbersOnly(input);
                    String code = formatNumbersAsCode(numbersOnly);

                    Log.w("", "numbersOnly" + numbersOnly);
                    Log.w("", "code" + code);

                    //creditCard.removeTextChangedListener(this);
                    creditCard.setText(code);
                    // You could also remember the previous position of the cursor
                    creditCard.setSelection(code.length());
                    creditCard.addTextChangedListener(this);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            private String keepNumbersOnly(CharSequence s) {
                return s.toString().replaceAll("[^0-9]", ""); // Should of course be more robust
            }

            private String formatNumbersAsCode(CharSequence s) {
                int groupDigits = 0;
                String tmp = "";
                for (int i = 0; i < s.length(); ++i) {
                    tmp += s.charAt(i);
                    ++groupDigits;
                    if (groupDigits == 4) {
                        tmp += " ";
                        groupDigits = 0;
                    }
                }
                return tmp;
            }
        });

        cardExp.addTextChangedListener(new TextWatcher() {
            private boolean mWasEdited = false;
            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s);
                // TODO Auto-generated method stub


                if (mWasEdited){

                    mWasEdited = false;
                    return;
                }

                // get entered value (if required)
                String enteredValue  = s.toString();

                //String newValue = "new value";

                // don't get trap into infinite loop
                mWasEdited = true;
                // just replace entered value with whatever you want
                String code = formatNumbersAsCode(enteredValue);
                cardExp.removeTextChangedListener(this);
                cardExp.setText(code);
                cardExp.setSelection(code.length());
                cardExp.addTextChangedListener(this);

                //s.replace(0, s.length(), newValue);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+count);
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+count);
              /*  if (before == 1 && count == 2 && s.charAt(s.length()-1) != '/') {
                    cardExp.setText(cardExp.getText().toString() + "/");
                }
                if (cardExp.getText().toString().toCharArray().length < 3) {
                    cardExp.setText(cardExp.getText().toString().replace("/", ""));
                }*/

            }

            private String formatNumbersAsCode(CharSequence s) {
                int groupDigits = 0; String lastInput ="";
                String tmp = "";
                for (int i = 0; i < s.length(); ++i) {
                    tmp += s.charAt(i);
                    ++groupDigits;
                    if (groupDigits == 2 && !lastInput.endsWith("/")) {
                        tmp += "/";
                        //groupDigits = 0;
                    }
                    else{}
                }
                return tmp;
            }
        });



        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Register_2.this, Register_3.class);
                startActivity(i);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Register_2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
