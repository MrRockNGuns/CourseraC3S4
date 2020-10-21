package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Mail;
    private DatePicker Date;
    private EditText Phone;
    private EditText Description;
    ArrayList<Contact> contactos;

    private RecyclerView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
//        Toolbar setSupportActionBar(miActionBar);
        /**
           Name  = (EditText) findViewById(R.id.etFullname);
           Mail  = (EditText) findViewById(R.id.etEmail);
           Phone  = (EditText) findViewById(R.id.etPhone);
           Description  = (EditText) findViewById(R.id.etDescription);
           Date = (DatePicker) findViewById(R.id.dpCalendar);
         **/
        /**
            ArrayList<String> contactNames = new ArrayList<>();
            for (Contact contacto: contactos){
                contactNames.add(contacto.getName());
            }
        **/
        contactList = (RecyclerView) findViewById(R.id.rvContacts);

        //Linear Layout
       LinearLayoutManager llm = new LinearLayoutManager(this);
       llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Grid Layout
        //GridLayoutManager glm = new GridLayoutManager(this,2);


        //contactList.setLayoutManager(glm); // ahora el recicleView se comporta como linear Layout
        contactList.setLayoutManager(llm); // ahora el recicleView se comporta como linear Layout

        startContacts();
        startAdapter();

    }


    public void startAdapter(){
        ContactAdapter adapter = new ContactAdapter(contactos,this);
        contactList.setAdapter(adapter);
    }

    public void Next(View v){
        String name = Name.toString();
        String phone = Mail.toString();
        String email = Phone.toString();
        String desc = Description.toString();
        String date = Date.toString();

        Intent confirmData = new Intent(MainActivity.this, contactDetail.class);
        confirmData.putExtra(getResources().getString(R.string.pName),name);
        confirmData.putExtra(getResources().getString(R.string.pPhone),phone);
        confirmData.putExtra(getResources().getString(R.string.pEmail),email);
        //confirmData.putExtra(getResources().getString(R.string.pPhone),desc);
        //confirmData.putExtra(getResources().getString(R.string.pDate),date);
        startActivity(confirmData);

    }

    public void startContacts(){
        contactos = new ArrayList<Contact>();
        contactos.add(new Contact(R.drawable.photo_camera,"Boris Pessano","11112222","boris@email.com"));
        contactos.add(new Contact(R.drawable.phone_call,"Claudia Lobato","33334444","Claudia@email.com"));
        contactos.add(new Contact(R.drawable.settings,"Karen Antunez","55556666","Karen@email.com"));
        contactos.add(new Contact(R.drawable.monitor,"Miguel Leclerc","99990000","Leclerc@email.com"));
        contactos.add(new Contact(R.drawable.envelope,"Martin Garabal","77778888","MGarabal@email.com"));
    }
}