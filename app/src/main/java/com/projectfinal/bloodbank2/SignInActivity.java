package com.projectfinal.bloodbank2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class SignInActivity extends AppCompatActivity {

    EditText usernameEt, passwordEt;
    Button submitBt;
    private DatabaseReference mDatabase;
    private DatabaseReference  adminRef;
    String fUsername, fPassword;
    //TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        usernameEt = (EditText)findViewById(R.id.usernameEt);
        passwordEt = (EditText)findViewById(R.id.passwordEt);
        submitBt = (Button)findViewById(R.id.submitBt);
        //tt = (TextView)findViewById(R.id.tt);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        adminRef = mDatabase.child("userAdmin");



        adminRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                fUsername = dataSnapshot.child("username").getValue().toString();
                fPassword = dataSnapshot.child("password").getValue().toString();
                //tt.setText(fUsername +" " + fPassword);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
    });

        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();
                if(username != null && password != null){
                    if(username.equals(fUsername)  && password.equals(fPassword)){

                        Intent intent = new Intent(SignInActivity.this, RequestList.class);
                        startActivity(intent);

                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "login failed",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

            }
        });



}

}

