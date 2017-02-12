package com.example.miguegrape.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList <Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Miguel Ruiz","55-43-45-67-89","miguelruiz@gmail.com"));
        contactos.add(new Contacto("Andres Pacheco","55-23-45-67-89","andrespacheco@gmail.com"));
        contactos.add(new Contacto("Viridiana Velazquez","55-34-45-56-76","viridianavelazquez@gmail.com"));
        contactos.add(new Contacto("Gabriela Orozco","55-23-45-67-98","gabrielaorozco@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView)findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                startActivity(intent);
                finish();

            }
        });




    }
}
