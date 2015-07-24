package com.example.lg_11_09.blooddonate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;


public class Donate_Activity extends AppCompatActivity {
    int count=1;
    Vibrator mVibrator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_);
        final SharedPreferences pref= getSharedPreferences("Login", MODE_PRIVATE);
        final SharedPreferences.Editor e=pref.edit();
        final EditText name, passw ;

        if(pref.contains("User")){
            Intent i=new Intent(getApplicationContext(),Login_Activity.class);
            startActivity(i);
            finish();
        }

        name=(EditText)findViewById(R.id.name);
        passw=(EditText)findViewById(R.id.phone);
        Button b=(Button)findViewById(R.id.login);

        mVibrator=(Vibrator)Donate_Activity.this.getSystemService(Context.VIBRATOR_SERVICE);

        if(pref.contains("User")) {
            name.setText(pref.getString("User", "Wrong Answer"));
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mVibrator.vibrate(100);
                Intent b = new Intent(getApplicationContext(), Login_Activity.class);


                if (name.getText().toString().equals("")) {
                    name.setHint("Name Missing");
                    name.setHintTextColor(Color.RED);
                    count = 0;

                    name.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            name.setHint("");
                            return false;
                        }
                    });
                }/* else
                    count = 1;*/
                if (passw.getText().toString().equals("")||passw.getText().toString().length()!=10) {
                    passw.setText("");
                    passw.setHint("Invalid Phone no.");
                    passw.setHintTextColor(Color.RED);

                    count = 0;

                    passw.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            passw.setHint("");
                            return false;
                        }
                    });
                } /*else
                    count = 1;*/
                if (count == 0) {
                    Toast t = Toast.makeText(getApplicationContext(), "Fields Missing !!", Toast.LENGTH_SHORT);
                    t.show();
                    count=1;

                }
                else {
                    e.putString("User", name.getText().toString());

                    e.apply();
                    startActivity(b);
                    finish();
                }
            }});


        ImageButton nd=(ImageButton)findViewById(R.id.nd);
        nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nd=new Intent(getApplicationContext(),NewDonor_Activity.class);

                startActivity(nd);
                finish();
            }
        });
    }

  


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
