package com.example.felipesantos.jogocaraoucoroa.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.felipesantos.jogocaraoucoroa.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonJogar = findViewById(R.id.btJogar);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JogarActivity.class);

//                Passar dados
                int numeroRandomico = new Random().nextInt(2);
                intent.putExtra("numero", numeroRandomico);

                startActivity(intent);
            }
        });
    }


}
