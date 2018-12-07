package com.example.androidl.prekart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class debit extends AppCompatActivity {
    Spinner debit1,debit2,debit3;
    EditText ed1,ed2;
    final String months[] = {"EXPIRY MM", "JANUARY", "FEBRUARY", "MARCH", "APRIL" ,"MAY", "JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
    final String years[] = {"EXPIRY YYYY","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037"};
    final String banks[] = {"CHOOSE A BANK","All Visa/Master Card Debit Card","All Rupay Debit Cards","All SBI Maestro Bank","All Citibank Maestro Bank"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit);
        debit1=(Spinner)findViewById(R.id.spinner1);
        debit2=(Spinner)findViewById(R.id.spinner3);
        debit3=(Spinner)findViewById(R.id.spinner5);
        ed1=(EditText)findViewById(R.id.editText100);
        ed2=(EditText) findViewById(R.id.editText101);


        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_item, months);
        ArrayAdapter a2=new ArrayAdapter(this, android.R.layout.simple_spinner_item, years);
        ArrayAdapter a3=new ArrayAdapter(this, android.R.layout.simple_spinner_item, banks);

        debit1.setAdapter(a);
        debit2.setAdapter(a2);
        debit3.setAdapter(a3);
        debit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        { @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        debit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent2, View view2, int position2, long id2) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        debit3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view3, int position3, long id3) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
    public void onSubmit(View v)
    {
        String name33 = ed1.getText().toString();
        String cardNo33 =ed2.getText().toString();

        if (TextUtils.isEmpty(name33)) {
            Toast.makeText(getApplicationContext(), "Enter name !", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(cardNo33)) {
            Toast.makeText(getApplicationContext(), "Enter " +
                    "card No", Toast.LENGTH_SHORT).show();
            return;
        }
        if(cardNo33.length()!=16)
        {
            Toast.makeText(getApplicationContext(), "card no should be 16 digits !", Toast.LENGTH_SHORT).show();
            return;
        }

        else
        {

            Toast.makeText(getApplicationContext(),
                    "debit card option is not  available ", Toast.LENGTH_LONG)
                    .show();

        }

    }

}
