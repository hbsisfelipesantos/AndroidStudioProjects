package com.example.felipesantos.listadetarefas.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.felipesantos.listadetarefas.Helper.TarefaDAO;
import com.example.felipesantos.listadetarefas.R;
import com.example.felipesantos.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

//        Recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

//        Configurar tarefa na caixa de texto
        if (tarefaAtual != null) {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.itemSalvar:
                // Executa ação para o item salvar
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if (tarefaAtual != null) {//Edição
                    String nomeTarefa = editTarefa.getText().toString();

                    if (!nomeTarefa.isEmpty()) {
                        nomeTarefa = editTarefa.getText().toString();
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

//                        Atualizar no BD
                        if (tarefaDAO.atualizar(tarefa)){

                            Toast.makeText(getApplicationContext(), "Sucesso ao atualizar tarefa", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa", Toast.LENGTH_SHORT).show();
                        }

                        finish();
                    }

                } else  {//Salvar
                    String nomeTarefa = editTarefa.getText().toString();
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);

                    if (tarefaDAO.salvar(tarefa)) {
                        Toast.makeText(getApplicationContext(), "Tarefa Salva", Toast.LENGTH_SHORT).show();

                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
                    }

                    finish();
                }


                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
