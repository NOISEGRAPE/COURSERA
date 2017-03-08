package com.noisegrape.mascotasapp.db;

import android.content.ContentValues;
import android.content.Context;

import com.noisegrape.mascotasapp.R;
import com.noisegrape.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MigueGrape on 05/03/2017.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;



    public ConstructorMascotas(Context context){

        this.context = context;

    }

    public ArrayList<Mascota> obtenerDatos(){

        /*ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Roco", "23", R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Shiva", "15", R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Aime", "12", R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bolt", "18", R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Scooby", "26", R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }



    public ArrayList<Mascota> obtenerFavoritos() {
        BaseDatos db = new BaseDatos(context);

        return  db.obtenerTopFavoritos();
    }






    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "ROCO");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascota1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "SHIVA");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascota2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "AIME");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascota3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "BOLT");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascota4);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "SCOOBY");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascota5);

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
