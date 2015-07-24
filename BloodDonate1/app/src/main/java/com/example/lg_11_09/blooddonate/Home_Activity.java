package com.example.lg_11_09.blooddonate;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class Home_Activity extends AppCompatActivity {
   /* http://blood-cloud.appspot.com/*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        final ImageButton dona=(ImageButton)findViewById(R.id.donate);
        ImageButton req=(ImageButton)findViewById(R.id.request);
        ImageButton b=(ImageButton)findViewById(R.id.about);
        dona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dona = new Intent(getApplicationContext(), Donate_Activity.class);
                startActivity(dona);
            }
        });
       req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent req=new Intent(getApplicationContext(),Needblood_Activity.class);
                startActivity(req);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), AboutUS_Activity.class);
                startActivity(b);
            }
        });
        ImageButton s=(ImageButton)findViewById(R.id.set);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), HowtoUse_Activity.class);
                startActivity(s);
            }
        });
    }


}
