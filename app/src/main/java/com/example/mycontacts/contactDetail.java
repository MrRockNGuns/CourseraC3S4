package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class contactDetail extends AppCompatActivity {

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvMail;
    private TextView tvBirth;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);



        //Obtengo parametros que se envian de Main
        Bundle parm  = getIntent().getExtras();
        String Name  = parm.getString(getResources().getString(R.string.pName));
        String Phone = parm.getString(getResources().getString(R.string.pPhone));
        String Mail  = parm.getString(getResources().getString(R.string.pEmail));
        //String Birth = parm.getString(getResources().getString(R.string.pDate));

        // Obtengo los Id
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvMail = (TextView) findViewById(R.id.tvMail);
        tvBirth = (TextView) findViewById(R.id.tvBirth);

        //tvBirth.setText(Birth);
        tvName.setText(Name);
        tvPhone.setText(Phone);
        tvMail.setText(Mail);

    }
    public void Call(View v) {
        String phone = tvPhone.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
    }

    public void sendMail(View v){
        String Mail = tvMail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, Mail);
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}