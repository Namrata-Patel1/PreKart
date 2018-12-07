package com.example.androidl.prekart;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      Button  btnSignUp = (Button)findViewById(R.id.btnSignUp);
      Button  btnSignIn = (Button) findViewById(R.id.btnSignIn);
        TextView textSlogan = (TextView)findViewById(R.id.textSlogan);

          btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(MainActivity.this,SignIn.class);
                startActivity(signIn);
                Log.v("SignIn.this","CHECK POINT REACHED");


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUp);


            }
        });

    }
}
