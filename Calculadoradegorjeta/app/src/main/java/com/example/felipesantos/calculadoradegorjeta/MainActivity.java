package com.example.felipesantos.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etDigiteUmvalor;
    private TextView tvProcentagem;
    private SeekBar sbPorcentagem;
    private TextView tvGorjeta;
    private TextView tvTotal;

    private double porcentagemDaGorjeta = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDigiteUmvalor = findViewById(R.id.etDigiteUmValor);
        tvProcentagem = findViewById(R.id.tvPorcentagem);
        sbPorcentagem = findViewById(R.id.sbPorcentagem);
        tvGorjeta = findViewById(R.id.tvGorjeta);
        tvTotal = findViewById(R.id.tvTotal);

        if(etDigiteUmvalor.getText().length() != 0) {
            sbPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    tvProcentagem.setText(sbPorcentagem.getProgress() + "%");
                    porcentagemDaGorjeta = sbPorcentagem.getProgress();
                    calcular();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        } else {
            etDigiteUmvalor.setText("0.0");
        }
    }
        public void calcular () {
            if(etDigiteUmvalor.getText().length() != 0) {
                double valorConta ;

                valorConta = Double.parseDouble(etDigiteUmvalor.getText().toString());
                double gorjeta = (porcentagemDaGorjeta / 100) * valorConta;
                tvGorjeta.setText("R$ " + Math.round(gorjeta));

                double total = gorjeta + valorConta;
                tvTotal.setText("R$ " + Math.round(total));
            } else {
                etDigiteUmvalor.setText("0.0");
            }


        }
    }

