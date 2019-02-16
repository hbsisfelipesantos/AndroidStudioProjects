package com.example.felipesantos.bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
//            Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app",MODE_PRIVATE,null);
//            Criar Tabela
            bancoDados.execSQL("Create table if not exists pessoas(cod_pessoa primary Key, nome VARCHAR, idade INT(3))");
//            bancoDados.execSQL("insert into pessoas(nome, idade) values('Felipe',26)");
//            bancoDados.execSQL("insert into pessoas(nome, idade) values('Nathalia',21)");

            bancoDados.execSQL("update pessoas set idade = 22" +
            " where nome = 'Nathalia' ");

//            Recuperar pessoas
            String filtro = "lia";

//            String consulta = "select * from pessoas " +
//                    " WHERE nome like '%" + filtro + "%'";

            String consulta = "select * from pessoas " +
                    " WHERE nome like '%" + filtro + "%'";

            Cursor cursor = bancoDados.rawQuery(consulta, null);
            cursor.moveToFirst();
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            while(cursor != null) {

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);


                Log.i("Resultado - nome ", nome + " / idade:" + idade);
                cursor.moveToNext();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
