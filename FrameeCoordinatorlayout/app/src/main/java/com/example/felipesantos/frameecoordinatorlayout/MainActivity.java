package com.example.felipesantos.frameecoordinatorlayout;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.Carregando);
        frameLayout.setVisibility(View.GONE);
    }

    public void abrir(View view){
        frameLayout.setVisibility(View.VISIBLE);
    }
}
