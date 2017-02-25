package com.example.miguegrape.mascotas;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


import java.util.ArrayList;
/**
 * Created by Miguel on 20/02/2017.
 */

public class MascotasActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitle("                Petagram");
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Roco", "23", R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Shiva", "15", R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Aime", "12", R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bolt", "18", R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Scooby", "26", R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                Intent intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                return true;


            case R.id.mContacto:
                showDialogoContacto();
                break;



            case R.id.mAcercaDe:
                showDialogoAcercaDe();
                break;


        }
        return super.onOptionsItemSelected(item);
    }





    private void showDialogoContacto() {
        final Dialog dialog = new Dialog(MascotasActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_contacto);

        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.WHITE));


        dialog.show();
    }

    private void showDialogoAcercaDe() {
        final Dialog dialog = new Dialog(MascotasActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_acerca_de);

        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.WHITE));


        dialog.show();
    }




}
