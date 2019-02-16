package com.example.felipesantos.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etPrecoAlcool, etPrecoGasolina;
    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrecoAlcool = findViewById(R.id.etPrecoAlcool);
        etPrecoGasolina = findViewById(R.id.etPrecoGasolina);
        tvResultado = findViewById(R.id.tvResultado);

    }

    //recupera valores digitados
    public void calcularPreco(View view) {
        String precoAlcool = etPrecoAlcool.getText().toString();
        String precoGasolina = etPrecoGasolina.getText().toString();

//validar campos
        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {
            calcularMelhorPreco(precoAlcool, precoGasolina);
        } else {
            tvResultado.setText("Valores invalidos");
        }

    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina) {
        // converter String para numeros
        double precoAlcool = Double.parseDouble(pAlcool);
        double precoGasolina = Double.parseDouble(pGasolina);
/*

    Calculo melhor preço
    pAcool / pGasolina
    Se resultado > = 0.7 melhor utilzar gasolina
            senão melhor utilizar alcool
*/
        double resultado = precoAlcool / precoGasolina;
        if (resultado >= 0.7) {
            tvResultado.setText("Melhor utilizar Gasolina");
        } else {
            tvResultado.setText("Melhor usar Álcool");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}
