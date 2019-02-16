package com.example.felipesantos.listadetarefas.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "TAREFAS";

    public DbHelper(Context context) {
        super(context, DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                "(id INTERGER PRIMARY KEY ," +
                " nome TEXT NOT NULL);";

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar tabela");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar tabela" + e.getMessage());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE " + TABELA_TAREFAS + ";";


        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao deletar tabela");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao deletar tabela" + e.getMessage());
        }
        onCreate(db);

    }
}
