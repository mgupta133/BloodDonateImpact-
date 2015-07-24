package com.example.lg_11_09.blooddonate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Search_Activity extends ActionBarActivity {

    ListView list;
    String number="";
    List<Donor> myDonors=new ArrayList<Donor>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        populateDonorList();
        populateListView();
        clickCallListener();

    }



    private void populateDonorList() {

        myDonors.add(new Donor("Dheerpal","B+","9945781236"));
        myDonors.add(new Donor("Kira","AB+","454564"));
        myDonors.add(new Donor("Paul","B-","26589"));
        myDonors.add(new Donor("Harry ","O+","464623"));
        myDonors.add(new Donor("Ron","O-+","64564"));
        myDonors.add(new Donor("Tony","B+","487498432"));
        myDonors.add(new Donor("Thor","AB-","484156"));
        myDonors.add(new Donor("Superman","AB+","48431534"));
        myDonors.add(new Donor("Singham","AB+","64798"));
        myDonors.add(new Donor("Logan","O+","69859794"));
        myDonors.add(new Donor("Batman","B-","49751"));
        myDonors.add(new Donor("Loky","AB+","233137"));
        myDonors.add(new Donor("Hobbit","B+","167979"));
        myDonors.add(new Donor("Stark","A+","544664"));
        myDonors.add(new Donor("Bruce","A-","878789"));
        myDonors.add(new Donor("Wayne","A+","89898"));
        myDonors.add(new Donor("Bajrangi","A+","1345"));
        myDonors.add(new Donor("Bhaijaan","AB-","12345"));
        myDonors.add(new Donor("Baahubali","B-","8978"));
        myDonors.add(new Donor("Razia","AB+","89764"));
        myDonors.add(new Donor("Sultaan","B+","6464"));
        myDonors.add(new Donor("Tanuj","AB+","64645"));
        myDonors.add(new Donor("Trishtha","AB-","64646"));
        myDonors.add(new Donor("Billu","O+","54546"));
        myDonors.add(new Donor("Romanoff","O-","2454*9"));
        myDonors.add(new Donor("Hulk","B+","98746"));

    }

    private void populateListView() {
        ArrayAdapter<Donor> adapter = new MyListAdapter(getApplicationContext(),R.layout.layout,myDonors);
         list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Donor> {


        public MyListAdapter(Context applicationContext, int layout, List<Donor> myDonors) {
            super(getApplicationContext(),R.layout.layout,myDonors);


        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView=convertView;
            if(itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.layout,parent,false);
            }
            Donor currentDonor=myDonors.get(position);
            TextView name=(TextView)itemView.findViewById(R.id.name);
            name.setText(currentDonor.getName());
            TextView bg= (TextView) itemView.findViewById(R.id.bg);
            bg.setText(currentDonor.getBg());
            TextView contact= (TextView) itemView.findViewById(R.id.contact);
            contact.setText(currentDonor.getContact());
            return itemView;
        }
    }


    private void clickCallListener() {

        list= (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Donor currentDonor=myDonors.get(position);

                /*TextView contact=(TextView)view.findViewById(R.id.contact);*/
                number=currentDonor.getContact().toString();
                final Intent intent= new Intent(Intent.ACTION_DIAL);

                AlertDialog.Builder builder = new AlertDialog.Builder(Search_Activity.this);
                builder.setCancelable(false);
                builder.setMessage("Do you want to call the selected Donor ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent.setData(Uri.parse("tel:" + number));
                        startActivity(intent);
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
    }
}
