package com.noisegrape.mascotasapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

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
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                Intent intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                return true;


            case R.id.mContacto:
                showDialogoContacto();
                break;


            case R.id.mAcercaDe:
                showDialogoAcercaDe();
                break;


        }
        return super.onOptionsItemSelected(item);
    }





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




    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        //tabLayout.getTabAt(0).setIcon(R.drawable.);
        //tabLayout.getTabAt(1).setIcon(R.drawable.);

    }
}
