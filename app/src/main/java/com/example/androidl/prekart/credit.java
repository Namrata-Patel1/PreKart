package com.example.androidl.prekart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class credit extends AppCompatActivity {
    Spinner credit1,credit2;
    EditText nammee ,card;
    Button b1;
    final String months[] = {"EXPIRY MM", "JANUARY", "FEBRUARY", "MARCH", "APRIL" ,"MAY", "JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
    final String years[] = {"EXPIRY YYYY","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        nammee=(EditText)findViewById(R.id.editText100);
        card=(EditText)findViewById(R.id.editText101) ;
        credit1 = (Spinner) findViewById(R.id.spinner1);
        credit2 = (Spinner) findViewById(R.id.spinner2);
        b1 = (Button) findViewById(R.id.creditbutton);


        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, months);
        ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, years);
        credit1.setAdapter(a);
        credit2.setAdapter(a2);
        credit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        credit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent2, View view2, int position2, long id2) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
    public void onSubmit(View v)
    {
        String name = nammee.getText().toString();
        String cardNo =card .getText().toString();



        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(getApplicationContext(), "Enter name  !", Toast.LENGTH_SHORT).show();
            return;
        }
        if(cardNo.length()!=16)
        {
            Toast.makeText(getApplicationContext(), "card no should be 16 digits !", Toast.LENGTH_SHORT).show();
            return;
        }


        //  if() {
        // Toast.makeText(getApplicationContext(), "chard Number should be 16 digits", Toast.LENGTH_SHORT).show();
        // return;
        //  }

        else
        {


            Toast.makeText(getApplicationContext(),
                    "credit card option is not  available ", Toast.LENGTH_LONG)
                    .show();



        }


    }

}



