package com.example.felipesantos.componentesdeinterface2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton tbEstado;
    private Switch sEstado;
    private CheckBox cbEstado;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbEstado = findViewById(R.id.tbEstado);
        sEstado = findViewById(R.id.sEstado);
        cbEstado = findViewById(R.id.cbEstado);
        tvResultado = findViewById(R.id.tvResultado);
        enviar();

    }

    public void enviar() {
        sEstado.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                                    if (sEstado.isChecked()) {
                                                        tvResultado.setText("Ligado");
                                                    } else {
                                                        tvResultado.setText("Desligado");
                                                    }
                                                }
                                            }
        );
    }

}
