package com.noisegrape.mascotasapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.noisegrape.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MigueGrape on 05/03/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;


    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_MASCOTAS + "(" +

                ConstantesBaseDatos.TABLE_MASCOTAS_ID     + "INTEGER PRIMARY KEY AUTOINCREMENT,"+

                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +

                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO   + " INTEGER " +

                ")";


        db.execSQL(queryCrearTablaMascota);


        String queryCrearTablaLikesMascota = "CREATE TABLE"+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +

                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+

                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "INTEGER ,"+

                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + "INTEGER, "+

                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +

                "REFERENCES"+ ConstantesBaseDatos.TABLE_MASCOTAS + " ("+ ConstantesBaseDatos.TABLE_MASCOTAS_ID +") " +

                ")";



        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();

    }
}
