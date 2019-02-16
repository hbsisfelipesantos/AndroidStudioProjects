package com.example.felipesantos.cardview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.example.felipesantos.cardview.Adapter.Adapter;
import com.example.felipesantos.cardview.R;
import com.example.felipesantos.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagem = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

//        Adaptador
        Adapter adapter = new Adapter(postagem);
        recyclerPostagem.setAdapter(adapter);
        prepararPostagem();

//        layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerPostagem.setLayoutManager(layoutManager);
//        ((LinearLayoutManager) layoutManager).setOrientation(((LinearLayoutManager) layoutManager).HORIZONTAL);
    }

    public void prepararPostagem() {
        Postagem p = new Postagem("Felipe Santos", "#Viajem!!", R.drawable.imagem1);
        this.postagem.add(p);

        p = new Postagem("Felipe Santos", "tezto grande hahahahahahahahaha", R.drawable.imagem2);
        this.postagem.add(p);

        p = new Postagem("Felipe Santos", "texto pequeno", R.drawable.imagem3);
        this.postagem.add(p);

        p = new Postagem("Felipe Santos", "teste teste teste teste teste", R.drawable.imagem4);
        this.postagem.add(p);

    }

}
