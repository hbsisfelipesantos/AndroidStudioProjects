package com.example.felipesantos.passandodadosactivitiesprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);

//                instanciar objetos
                Usuario usuario = new Usuario("Felipe", "ozzfelipe@gmail.com");

//                passar dados
                intent.putExtra("nome", "Felipe");
                intent.putExtra("idade", 26);
                intent.putExtra("objeto", (Serializable) usuario);


                startActivity(intent);

            }
        });
    }
}
