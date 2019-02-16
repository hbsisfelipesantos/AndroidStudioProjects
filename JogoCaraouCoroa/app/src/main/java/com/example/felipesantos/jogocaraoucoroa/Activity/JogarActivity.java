package com.example.felipesantos.jogocaraoucoroa.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.felipesantos.jogocaraoucoroa.R;

public class JogarActivity extends AppCompatActivity {

    private ImageView imageMoeda;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar);

        imageMoeda = findViewById(R.id.imageMoeda);
        btVoltar = findViewById(R.id.btVoltar);

//        recuperar dados
        Bundle dados = getIntent().getExtras();
        int numeroRandomico = dados.getInt("numero");
        if (numeroRandomico == 1) {
            imageMoeda.setImageResource(R.drawable.moeda_coroa);
        } else {
            imageMoeda.setImageResource(R.drawable.moeda_cara);
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
                finish();

            }
        });

    }


}
