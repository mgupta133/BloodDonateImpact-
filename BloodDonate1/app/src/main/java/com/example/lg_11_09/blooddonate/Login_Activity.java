package com.example.lg_11_09.blooddonate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class Login_Activity extends AppCompatActivity {

    Vibrator mVibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        final SharedPreferences pref= getSharedPreferences("Login", MODE_PRIVATE);
        final SharedPreferences.Editor e=pref.edit();

        Button op=(Button)findViewById(R.id.optout);
        Button lo=(Button)findViewById(R.id.logout);

        mVibrator=(Vibrator)Login_Activity.this.getSystemService(Context.VIBRATOR_SERVICE);
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVibrator.vibrate(100);
                final Intent op=new Intent(getApplicationContext(),Home_Activity.class);

                AlertDialog.Builder builder = new AlertDialog.Builder(Login_Activity.this);
                builder.setCancelable(false);
                builder.setMessage(" You will NO longer be a Donor. Are you sure to OPTOUT !!");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        e.clear();
                        e.apply();
                        e.commit();
                        startActivity(op);
                        Toast t= Toast.makeText(getApplicationContext(),"NOW you are not a Donor",Toast.LENGTH_LONG);
                        t.show();
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVibrator.vibrate(100);
                Intent lo=new Intent(getApplicationContext(),Donate_Activity.class);
                e.clear();
                e.apply();
                e.commit();
                startActivity(lo);
                finish();
            }
        });

        ImageButton edit=(ImageButton)findViewById(R.id.ed);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit=new Intent(getApplicationContext(),Edit_Activity.class);


                startActivity(edit);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_, menu);
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
