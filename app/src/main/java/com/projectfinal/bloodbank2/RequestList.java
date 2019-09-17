package com.projectfinal.bloodbank2;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class RequestList extends AppCompatActivity {


    ListView allusers;
    //ProgressDialog mProgressDialog;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    ListingAdapter adapter;
    ArrayList<User> users=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list);
        allusers=(ListView)findViewById(R.id.allusers);
        adapter=new ListingAdapter(RequestList.this,users);
        allusers.setAdapter(adapter);
        getDataFromServer();
    }

    public void getDataFromServer()
    {
        //showProgressDialog();
        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
                    {
                        User user=postSnapShot.getValue(User.class);
                        users.add(user);
                        adapter.notifyDataSetChanged();
                    }
                }
                //hideProgressDialog();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //hideProgressDialog();
            }
        });
    }

}
