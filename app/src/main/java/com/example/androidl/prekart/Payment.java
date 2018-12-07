package com.example.androidl.prekart;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    RadioGroup rg;
    RadioButton cod,canteencard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        rg = (RadioGroup) findViewById(R.id.rg);
        cod = (RadioButton) findViewById(R.id.cod);
        canteencard = (RadioButton) findViewById(R.id.canteencard);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.cod:
                        Toast.makeText(Payment.this, "Redirecting to paytm page for transaction!", Toast.LENGTH_SHORT).show();

                        Intent kl=new Intent(Payment.this,pay.class);
                        startActivity(kl);
                        break;
                    case R.id.canteencard:
                        Toast.makeText(Payment.this, "Under maintainence", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }
    public void onCredit(View v) {


        Intent i = getIntent();
        i = new Intent(Payment.this, credit.class);
        startActivity(i);
    }
    public void onDebit(View v) {


        Intent i = getIntent();
        i = new Intent(Payment.this, debit.class);
        startActivity(i);
    }
    }

