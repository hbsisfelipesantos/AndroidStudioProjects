package com.example.felipesantos.atmconsultoria.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.felipesantos.atmconsultoria.R;
import com.example.felipesantos.atmconsultoria.fragment.ClientesFragment;
import com.example.felipesantos.atmconsultoria.fragment.PrincipalFragment;
import com.example.felipesantos.atmconsultoria.fragment.ServicoFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.frameContainer, principalFragment);
        fragment.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer, principalFragment);
            fragment.commit();
        } else if (id == R.id.nav_sevicos) {
            ServicoFragment servicoFragment = new ServicoFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer, servicoFragment);
            fragment.commit();

        } else if (id == R.id.nav_clientes) {
            ClientesFragment clientesFragment = new ClientesFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer, clientesFragment);
            fragment.commit();

        } else if (id == R.id.nav_contato) {
            enviarEmail();
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(this, SobreActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void enviarEmail(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atmconsultoria@gmail.com", "ozzfelipe@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo app");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem Automatica");

        //configurar apps para email
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Escolha o app de emial"));


    }
}
