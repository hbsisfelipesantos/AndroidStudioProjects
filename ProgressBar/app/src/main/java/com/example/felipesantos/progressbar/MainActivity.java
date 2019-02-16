package com.example.felipesantos.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar progressBarCarregando;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBarCarregando = findViewById(R.id.pbCarregando);

    }

    public void carregarProgessBar(View view) {
        progresso += 10;
        progressBar.setProgress(progresso);

        progressBarCarregando.setVisibility(View.VISIBLE);

        for (int i = 0; i <= 100; i++){
            progressBar.setProgress(i);
        };


    }


}
