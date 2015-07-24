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
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Edit_Activity extends AppCompatActivity {
boolean count=true,flag=true;
    private Spinner spinner1;
    Vibrator mVibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        final EditText pin, name, passw,bg;
        final SharedPreferences pref= getSharedPreferences("Login", MODE_PRIVATE);
        final SharedPreferences.Editor e=pref.edit();

        mVibrator=(Vibrator)Edit_Activity.this.getSystemService(Context.VIBRATOR_SERVICE);
        name=(EditText)findViewById(R.id.name);
        passw=(EditText)findViewById(R.id.passw);
        /*bg=(EditText)findViewById(R.id.bg);*/
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String> ();
        list.add("Select Blood Group");
        list.add("A+");
        list.add("A-");
        list.add("B+");
        list.add("B-");
        list.add("AB+");
        list.add("AB-");
        list.add("O+");
        list.add("O-");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        addListenerOnButton();
        pin=(EditText)findViewById(R.id.pin);
         ImageButton save=(ImageButton)findViewById(R.id.done);
           save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mVibrator.vibrate(100);

                final Intent save = new Intent(getApplicationContext(), Login_Activity.class);

                if (name.getText().toString().equals("")) {
                    name.setHint("Name Missing");
                    count = false;

                    name.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            name.setHint("");
                            return false;
                        }
                    });
                }
                if (passw.getText().toString().equals("")||passw.getText().toString().length()!=10) {
                    passw.setText("");
                    passw.setHint("Invalid Phone no.");
                    count = false;

                    passw.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            passw.setHint("");
                            return false;
                        }
                    });
                }
                if (spinner1.getSelectedItem().toString().equals("Select Blood Group")) {
                    count = false;
                    flag = false;

                }
                if (pin.getText().toString().equals("")||pin.getText().toString().length()!=6) {
                    pin.setText("");
                    pin.setHint("Invalid Pincode ");
                    count = false;

                    pin.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            pin.setHint("");
                            return false;
                        }
                    });
                }

                if (flag == false) {
                    Toast t = Toast.makeText(getApplicationContext(), "Blood Group Missing", Toast.LENGTH_SHORT);
                    t.show();
                }


                if (count == true) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Edit_Activity.this);
                    builder.setCancelable(false);
                    builder.setMessage("Are you sure to save  Editted Details !!");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            e.putString("User", name.getText().toString());

                            e.apply();

                            startActivity(save);
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


                } else {
                    count = true;
                    flag = true;
                }
            }
        });
    }

    // Add spinner data

    public void addListenerOnSpinnerItemSelection(){

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //get the selected dropdown list value

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        /*btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(spinner1.getSelectedItem()),
                        Toast.LENGTH_LONG).show();
            }

        });*/

    }

}
