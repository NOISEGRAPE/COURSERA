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
import com.noisegrape.mascotasapp.presentador.IRecyclerViewFragmentPresenter;
import com.noisegrape.mascotasapp.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Miguel on 01/03/2017.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {

        listaMascotas.setAdapter(adaptador);

    }
}
