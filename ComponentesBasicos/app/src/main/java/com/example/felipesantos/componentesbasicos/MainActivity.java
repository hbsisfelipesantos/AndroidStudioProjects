package com.example.felipesantos.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resultado;
    private CheckBox cbBranco, cbVerde, cbVermelho;
    List<String> chek = new ArrayList<String>();
    private RadioGroup rgEstoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = (TextInputEditText) findViewById(R.id.etNomeProduto);
        resultado = (TextView) findViewById(R.id.tvResultado);
        cbBranco = findViewById(R.id.cbBranco);
        cbVerde = findViewById(R.id.cbVerde);
        cbVermelho = findViewById(R.id.cbVermelho);
        rgEstoque = findViewById(R.id.rgEstoque);

        verificaRadioButton();
    }

    public void verificarCheck() {

        chek.clear();

        if (cbBranco.isChecked()) {
            chek.add(cbBranco.getText().toString());
        }
        if (cbVerde.isChecked()) {
            chek.add(cbVerde.getText().toString());
        }
        if (cbVermelho.isChecked()) {
            chek.add(cbVermelho.getText().toString());
        }
        resultado.setText((CharSequence) chek);

    }

    public void verificaRadioButton() {
        rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbSim) {
                    resultado.setText("Sim");
                } else {
                    resultado.setText("Não");
                }
            }
        });
    }

    public void btEnviar(View view) {
        /*String nomeProduto = campoProduto.getText().toString();
        resultado.setText(nomeProduto);
        */
/*
        verificarCheck();
*/

    }
}

