package com.noisegrape.mascotasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.noisegrape.mascotasapp.adapter.PageAdapter;
import com.noisegrape.mascotasapp.fragment.PerfilFragment;
import com.noisegrape.mascotasapp.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null){

            setSupportActionBar(toolbar);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = null;

        switch (item.getItemId()) {


            case R.id.mContacto:
                i = new Intent(this, ContactoActivity.class);
                break;


            case R.id.mAcercaDe:
                i = new Intent(this, AcercaActivity.class);
                break;


            case R.id.mFavoritos:
                 i = new Intent(this, FavoritosActivity.class);
                 break;
        }

        startActivity(i);

        return super.onOptionsItemSelected(item);
    }



/*
    private void showDialogoContacto() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_contacto);

        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.WHITE));


        dialog.show();
    }

    private void showDialogoAcercaDe() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_acerca_de);

        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.WHITE));


        dialog.show();
    }
*/



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_mascota);

    }
}
