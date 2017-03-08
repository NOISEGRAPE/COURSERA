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

    ArrayList<Mascota> listaMascotas;
    private RecyclerView rvMascotas;
    private ConstructorMascotas constructorMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        iniciarListaMascotas();
        iniciarAdaptador();
    }

    public void iniciarAdaptador(){

        //Asigno ordern inverso por likes de la lista de mascotas
        Comparator<Mascota> comparador = Collections.reverseOrder();
        Collections.sort(listaMascotas, comparador);

        ArrayList<Mascota> topFive = new ArrayList<Mascota>(listaMascotas.subList(0,4));

        //Solo mantengo los 5 primeros => Top 5
        MascotaAdaptador adaptador = new MascotaAdaptador(topFive, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void iniciarListaMascotas(){

        constructorMascotas = new ConstructorMascotas(getBaseContext());

        listaMascotas = constructorMascotas.obtenerFavoritos();


    }
}











/*



package com.noisegrape.mascotasapp;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;

        import com.noisegrape.mascotasapp.adapter.MascotaAdaptador;
        import com.noisegrape.mascotasapp.pojo.Mascota;

        import java.util.ArrayList;

/**
 * Created by Miguel on 02/03/2017.
 */

/*
public class FavoritosActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitle("   Petagram Favoritos");
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Scooby", "26", R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Roco", "23", R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bolt", "18", R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Shiva", "15", R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Aime", "12", R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
}
*/