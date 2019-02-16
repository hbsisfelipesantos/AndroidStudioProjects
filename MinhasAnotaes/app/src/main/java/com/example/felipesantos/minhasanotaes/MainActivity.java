package com.example.felipesantos.minhasanotaes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editAnotacao;

    private AnotacaoPreferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (editAnotacao.getText().toString().equals("")) {
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    preferencias.salvarAnotacao(editAnotacao.getText().toString());
                    Snackbar.make(view, "Anotação salva com Sucesso", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }


        });

//        recuperar anotacao
        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")) {
            editAnotacao.setText(anotacao);
        }


    }


}
