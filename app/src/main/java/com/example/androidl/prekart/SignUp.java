package com.example.androidl.prekart;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.example.androidl.prekart.Model.User;

public class SignUp extends AppCompatActivity {
     MaterialEditText editName,editPhone,editPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        editName = (MaterialEditText)findViewById(R.id.editName);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        //Init database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
       final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mdialog = new ProgressDialog(SignUp.this);
                mdialog.setMessage("Please Wait");
                mdialog.show();

                 ValueEventListener valueEventListener = table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(editPhone.getText().toString()).exists())
                        {
                            mdialog.dismiss();
                            Toast.makeText(SignUp.this, "you are already Registered", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            mdialog.dismiss();
                            User user = new User(editName.getText().toString(), editPassword.getText().toString());
                            table_user.child(editPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
                            mdialog.dismiss();
                            finish();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
