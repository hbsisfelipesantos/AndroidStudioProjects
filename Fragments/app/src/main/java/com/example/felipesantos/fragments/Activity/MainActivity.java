package com.example.felipesantos.fragments.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.felipesantos.fragments.R;
import com.example.felipesantos.fragments.fragment.ContatosFragment;
import com.example.felipesantos.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btConversa, btContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btContato = findViewById(R.id.btContato);
        btConversa = findViewById(R.id.btConversa);

//        Remover sombra da ActionBar
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();

//        Configurar objeto para o fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        btContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frameConteudo, contatosFragment);
                transaction1.commit();
            }
        });
        btConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.frameConteudo, conversasFragment);
                transaction2.commit();
            }
        });
    }
}
