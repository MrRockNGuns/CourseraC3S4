package com.example.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;



public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    public ContactAdapter(ArrayList<Contact> contactos, Activity activity){
        this.contacts = contactos;
        this.activity = activity;
    }

    ArrayList<Contact> contacts;
    Activity activity;

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Inicio el ContactViewHolder inflando layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent, false);
        return new ContactViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) { // asocia cada elemento de la lista con cada view
        final Contact contacto = contacts.get(position);
        holder.imgPhoto.setImageResource(contacto.getPhoto());
        holder.tvNombreCV.setText(contacto.getName());
        holder.tvPhoneCV.setText(contacto.getPhone());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(activity,contacto.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, contactDetail.class);
                intent.putExtra("Name", contacto.getName());
                intent.putExtra("Phone", contacto.getPhone());
                intent.putExtra("Email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Diste Like a " + contacto.getName(),Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPhoto;
        private TextView  tvNombreCV;
        private TextView  tvPhoneCV;
        private ImageButton btnLike;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto    = (ImageView) itemView.findViewById(R.id.iv_ContactPhoto);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvName);
            tvPhoneCV   = (TextView) itemView.findViewById(R.id.tvPhone);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
