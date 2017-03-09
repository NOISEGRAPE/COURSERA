package com.noisegrape.mascotasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Miguel on 08/03/2017.
 */

public class ContactoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void enviarEmail(){
        try{

            EditText edtNombre = (EditText) findViewById(R.id.txtNombreContacto);
            EditText edtEmail = (EditText) findViewById(R.id.txtEmailContacto);
            EditText edtMensaje = (EditText) findViewById(R.id.txtMensaje);

            String nombreContacto = edtNombre.getText().toString();
            String emailContacto = edtEmail.getText().toString();
            String mensaje = edtMensaje.getText().toString();


        }catch(Exception ex){
            ex.printStackTrace();
            Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
        }


    }
}
