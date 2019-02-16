package com.example.felipesantos.treino;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText etProduto;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    etProduto =  (TextInputEditText) findViewById(R.id.edProduto);
    tvResultado = (TextView) findViewById(R.id.tvResultado);
    }

    public void btEnviar(View view){
        tvResultado.setText(etProduto.getText().toString());
    }
}
