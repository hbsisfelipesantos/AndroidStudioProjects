package com.example.felipesantos.preferenciasdousuario;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btSalvar;
    private TextInputEditText editNome;
    private TextView textResusltado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSalvar = findViewById(R.id.btSalvar);
        editNome = findViewById(R.id.editNome);
        textResusltado = findViewById(R.id.textResultado);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

//                Validar nome
                if (editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_SHORT).show();
                }else{
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textResusltado.setText("Olá, " + nome);
                }
            }
        });
// recupera dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

//        Validar se temos o nome preferencias
        if(preferences.contains("nome")){

            String nome = preferences.getString("nome","Olá, usuário não definido");
            textResusltado.setText("Olá, " + nome);

        }else{
            textResusltado.setText("Olá, usuário não definido");
        }
    }
}
