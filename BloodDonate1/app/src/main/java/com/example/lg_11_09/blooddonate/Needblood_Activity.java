package com.example.lg_11_09.blooddonate;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Needblood_Activity extends AppCompatActivity {
    boolean count=true;
    boolean flag=true;
    private Spinner spinner1;
    Vibrator mVibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needblood_);
        mVibrator=(Vibrator)Needblood_Activity.this.getSystemService(Context.VIBRATOR_SERVICE);

        ImageButton se=(ImageButton)findViewById(R.id.search);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Select Blood Group");
        list.add("A+");
        list.add("A-");
        list.add("B+");
        list.add("B-");
        list.add("AB+");
        list.add("AB-");
        list.add("O+");
        list.add("O-");

        /*final EditText bg=(EditText)findViewById(R.id.bg);*/
        final EditText pin=(EditText)findViewById(R.id.pin);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        addListenerOnButton();

        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mVibrator.vibrate(100);
                Intent se=new Intent(getApplicationContext(),Search_Activity.class);
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
                if (spinner1.getSelectedItem().toString().equals("Select Blood Group"))
                {
                    count = false;
                    flag=false;

                }
                if(flag==false)
                {
                    Toast t=Toast.makeText(getApplicationContext(),"Blood Group Missing",Toast.LENGTH_SHORT);
                    t.show();
                }



                if(count==true){

                    startActivity(se);
                    finish();
                }
                else
                { count=true;
                flag=true;
            }}
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
