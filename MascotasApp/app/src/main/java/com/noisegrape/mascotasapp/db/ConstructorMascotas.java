package com.noisegrape.mascotasapp.db;

import android.content.Context;

import com.noisegrape.mascotasapp.R;
import com.noisegrape.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MigueGrape on 05/03/2017.
 */

public class ConstructorMascotas {


    private Context context;
    public ConstructorMascotas(Context context){

        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Roco", "23", R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Shiva", "15", R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Aime", "12", R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bolt", "18", R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Scooby", "26", R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        return mascotas;
    }
}
