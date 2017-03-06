package com.noisegrape.mascotasapp.presentador;

import android.content.Context;

import com.noisegrape.mascotasapp.adapter.MascotaAdaptador;
import com.noisegrape.mascotasapp.db.ConstructorMascotas;
import com.noisegrape.mascotasapp.fragment.IRecyclerViewFragmentView;
import com.noisegrape.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MigueGrape on 05/03/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,Context context){

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();

    }


    @Override
    public void obtenerMascotasBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
