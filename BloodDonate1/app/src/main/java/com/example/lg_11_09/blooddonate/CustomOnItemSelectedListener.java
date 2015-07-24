package com.example.lg_11_09.blooddonate;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by LG-11-09 on 21-Jul-15.
 */
public class CustomOnItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,
                               long id) {

        /*Toast.makeText(parent.getContext(),
                "On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_LONG).show();*/

       /* String item = (String) parent.getItemAtPosition(pos);

        return item;*/

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
