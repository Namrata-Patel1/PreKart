package com.example.androidl.prekart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    TextView food_cname,food_cquant,food_cprice;
    Button payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        food_cname=(TextView)findViewById(R.id.food_cname);
        food_cquant=(TextView)findViewById(R.id.food_cquant);
        food_cprice=(TextView)findViewById(R.id.food_cprice);
        payment=(Button)findViewById(R.id.payment);

        Intent i=getIntent();
        Bundle b=i.getExtras();

        int y=Integer.parseInt(b.getString("Cquant"));
        int t=Integer.parseInt(b.getString("Cprice"));
        int z=y*t;
        String e=String.valueOf(z);

        food_cname.setText(b.getString("Cname"));
        food_cquant.setText(b.getString("Cquant"));
        food_cprice.setText(e);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Payment.class);
                startActivity(i);
            }
        });
    }
}
