package com.example.miguegrape.menuopcionescontextopopup;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getSupportFragmentManager().beginTransaction().add(R.id.mifragment,new MiFragment()).commit();

        TextView tvNombre  = (TextView) findViewById(R.id.tvNombre);

        registerForContextMenu(tvNombre);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){

            case R.id.mRefresh:

                Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_refresh),Toast.LENGTH_LONG).show();

                break;


            case R.id.mAbout:

                Intent intent = new Intent(this,ActivityAbout.class);
                startActivity(intent);
                break;

            case R.id.mSettings:
                Intent i = new Intent(this,ActivitySettings.class);
                startActivity(i);
                break;




        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        getMenuInflater().inflate(R.menu.menu_contexto,menu);
        //MenuInflater inflater = new MenuInflater(this);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mEdit:
                //Intent

                Toast.makeText(this,getResources().getString(R.string.menu_edit),Toast.LENGTH_SHORT).show();
                break;


            case R.id.mDelete:
                //Intent

                Toast.makeText(this,getResources().getString(R.string.menu_delete),Toast.LENGTH_SHORT).show();
                break;
        }




        return super.onContextItemSelected(item);

    }



     public void levantarmenuPopUp(View v){

         ImageView imagen = (ImageView) findViewById(R.id.imgImagen);
         PopupMenu popupMenu = new PopupMenu(this,imagen);
         popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

         popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
             @Override
             public boolean onMenuItemClick(MenuItem item) {

                 switch (item.getItemId()){

                     case R.id.mView:
                         Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_view),Toast.LENGTH_LONG).show();
                         break;

                     case R.id.mViewDetail:
                         Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_view_detail),Toast.LENGTH_LONG).show();
                         break;
                 }


                 return true;
             }
         });

         popupMenu.show();


     }








}
