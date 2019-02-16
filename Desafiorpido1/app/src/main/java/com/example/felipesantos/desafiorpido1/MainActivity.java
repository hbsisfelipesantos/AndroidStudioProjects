package com.example.felipesantos.desafiorpido1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void texto2(View view) {
        TextView texto = findViewById(R.id.selectedNumber);
        int x = new Random().nextInt( 10);
                texto.setText("O número selecionado é: " + x);
    }


}
