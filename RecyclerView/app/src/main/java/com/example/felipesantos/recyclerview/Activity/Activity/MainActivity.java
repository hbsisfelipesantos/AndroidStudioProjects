package com.example.felipesantos.recyclerview.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.felipesantos.recyclerview.Activity.RecyclerItemClickListener;
import com.example.felipesantos.recyclerview.Activity.model.Filme;
import com.example.felipesantos.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recylcerView);

//        Listagem de Filmes
        this.criarFilmes();


//        configurar adaptador

        com.example.felipesantos.recyclerview.Activity.Adapter.Adapter adapter = new com.example.felipesantos.recyclerview.Activity.Adapter.Adapter(listaFilmes);

//        evento de click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(), "item pressionado" + filme.getTiuloFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Clique longo " + filme.getTiuloFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));

//        configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes() {
        Filme filme = new Filme("Filme 1", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 2", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 3", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 4", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 5", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 6", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 7", "Genero 1", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Filme 8", "Genero 1", "2018");
        this.listaFilmes.add(filme);

    }
}
