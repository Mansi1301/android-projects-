package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myUdaipur = (TextView) findViewById(R.id.udaipur);
        myUdaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, UdaipurActivity.class);
                startActivity(intent);
            }

        });

        TextView myDelhi = (TextView) findViewById(R.id.delhi);
        myDelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DelhiActivity.class);
                startActivity(intent);
            }

        });

        TextView myMumbai = (TextView) findViewById(R.id.mumbai);
        myMumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MumbaiActivity.class);
                startActivity(intent);
            }

        });

        TextView myGoa = (TextView) findViewById(R.id.goa);
        myGoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, GoaActivity.class);
                startActivity(intent);
            }

        });
    }
}
