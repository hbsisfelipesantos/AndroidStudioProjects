package com.example.felipesantos.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void abrirtToast(View view) {
//        Toast.makeText(getApplicationContext(),"Botão pressionado", Toast.LENGTH_LONG).show();
        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplication());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(imagem);
        toast.show();
    }
}