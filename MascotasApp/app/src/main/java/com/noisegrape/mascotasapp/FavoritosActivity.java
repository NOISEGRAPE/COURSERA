package com.noisegrape.mascotasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.noisegrape.mascotasapp.adapter.MascotaAdaptador;
import com.noisegrape.mascotasapp.db.ConstructorMascotas;
import com.noisegrape.mascotasapp.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Miguel on 02/03/2017.
 */

public class FavoritosActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ConstructorMascotas constructorMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitle("   Petagram Favoritos");
        setSupportActionBar(miActionBar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        iniciarListaMascotas();
        iniciarAdaptador();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    public void iniciarAdaptador(){

        Comparator<Mascota> comparador = Collections.reverseOrder();
        Collections.sort(mascotas, comparador);
        ArrayList<Mascota> topFive = new ArrayList<Mascota>(mascotas.subList(0,4));
        MascotaAdaptador adaptador = new MascotaAdaptador(topFive, this);
        listaMascotas.setAdapter(adaptador);
    }




    public void iniciarListaMascotas(){

        constructorMascotas = new ConstructorMascotas(getBaseContext());
        mascotas = constructorMascotas.obtenerFavoritos();
    }


}


