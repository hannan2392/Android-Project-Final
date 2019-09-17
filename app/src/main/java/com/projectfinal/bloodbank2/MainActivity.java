package com.projectfinal.bloodbank2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView unitAPos, unitBPos, unitOPos, unitABPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitAPos = (TextView) findViewById(R.id.unit_a_pos_tv);
        unitBPos = (TextView) findViewById(R.id.unit_b_pos_tv);
        unitOPos = (TextView) findViewById(R.id.unit_o_pos_tv);
        unitABPos = (TextView) findViewById(R.id.unit_ab_pos_tv);
    }



    public void request(View view) {
        Intent intent = new Intent(this, RequestForm.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_in:
                Intent intent = new Intent(this, SignInActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


