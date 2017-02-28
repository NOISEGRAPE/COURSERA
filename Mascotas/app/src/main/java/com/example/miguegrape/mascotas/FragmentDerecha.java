package com.example.miguegrape.mascotas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miguegrape.mascotas.FavoritosActivity;
import com.example.miguegrape.mascotas.MascotasActivity;

import java.util.ArrayList;


public class FragmentDerecha extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    public FragmentDerecha() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_derecha, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        glm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(glm);

        iniciarListaMascotas();


        return v;
    }



    public void iniciarListaMascotas(){


        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bacondo", "26", R.drawable.perrito2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bacondo", "23", R.drawable.perrito2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bacondo", "18", R.drawable.perrito2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bacondo", "15", R.drawable.perrito2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bacondo", "12", R.drawable.perrito2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));









    }


}