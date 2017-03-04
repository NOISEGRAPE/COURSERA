package com.noisegrape.mascotasapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noisegrape.mascotasapp.pojo.Mascota;
import com.noisegrape.mascotasapp.R;
import com.noisegrape.mascotasapp.adapter.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by Miguel on 01/03/2017.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);



        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
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
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

}
