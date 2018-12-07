package com.example.androidl.prekart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidl.prekart.Common.Common;
import com.example.androidl.prekart.Database.Database;
import com.example.androidl.prekart.Model.Order;
import com.example.androidl.prekart.Model.Request;
import com.example.androidl.prekart.ViewHolder.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class crt extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference requests;

    TextView txtTotalPrice;
    FButton btnPlace;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    List<Order> cart= new ArrayList<>();
    CartAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crt);

        database = FirebaseDatabase.getInstance();
        requests = database.getReference("Request");

        recyclerView = (RecyclerView) findViewById(R.id.listcart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        txtTotalPrice=(TextView)findViewById(R.id.total);
        btnPlace=(FButton)findViewById(R.id.btnPlaceOrder);
        
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

         loadListFood();
    }

    private void showAlertDialog() {
//entering proper
         AlertDialog.Builder alertDialog=new AlertDialog.Builder(crt.this);
        alertDialog.setTitle("One more step!");
        alertDialog.setMessage("Enter Your Address:");

        final EditText edtAddress=new EditText(crt.this);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
          LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        edtAddress.setLayoutParams(lp);
        alertDialog.setView(edtAddress);
        alertDialog.setIcon(R.drawable.ic_local_grocery_store_black_24dp);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Request request=new Request(
                  Common.currentUser.getPhone(),
                        edtAddress.getText().toString(),
                        Common.currentUser.getName(),
                        txtTotalPrice.getText().toString(),cart

                );

                requests.child(String.valueOf(System.currentTimeMillis())).setValue(request);

                new Database(getBaseContext()).cleanCart();
                Intent n = new Intent(crt.this,Payment.class);
                startActivity(n);
                //finish();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();;

        }

    private void loadListFood() {

        cart=new Database(this).getCarts();
        adapter =new CartAdapter(cart,this);
        recyclerView.setAdapter(adapter);

        int total=0;
        for(Order order:cart)
            total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getQuantity()));

            Locale locale=new Locale("en","US");
            //one more format
            NumberFormat fmt=NumberFormat.getCurrencyInstance(locale);

        txtTotalPrice.setText(fmt.format(total));




    }
}
