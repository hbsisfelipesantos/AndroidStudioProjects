package com.example.felipesantos.listadetarefas.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.felipesantos.listadetarefas.Helper.DbHelper;
import com.example.felipesantos.listadetarefas.Helper.RecyclerItemClickListener;
import com.example.felipesantos.listadetarefas.Helper.TarefaDAO;
import com.example.felipesantos.listadetarefas.R;
import com.example.felipesantos.listadetarefas.activity.AdicionarTarefaActivity;
import com.example.felipesantos.listadetarefas.adapter.TarefaAdapter;
import com.example.felipesantos.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLista;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Tarefa tarefaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rvLista = findViewById(R.id.rvLista);


//        Adicionar evento de clique
        rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Recuperar tarefa
                Tarefa tarefaSelecionada = listaTarefas.get(position);

//                Enviar tarefa para tela AdicionarTarefa
                Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {
//                Recuperar tarefa
                tarefaSelecionada = listaTarefas.get(position);

//                Configura um AlertDialog
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

//                Configura titulo e mensagem
                dialog.setTitle("Confirmar exclusão");
                dialog.setMessage("Deseja excluir a terafa: " + tarefaSelecionada.getNomeTarefa() + "?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                        if (tarefaDAO.deletar(tarefaSelecionada)) {

                            carregarListaTarefas();

                            Toast.makeText(getApplicationContext(), "sucesso ao exluir tarefa", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(getApplicationContext(), "Erro ao exluir tarefa", Toast.LENGTH_SHORT).show();

                        }



                    }
                });

                dialog.setNegativeButton("Não", null);

                dialog.create();
                dialog.show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaTarefas() {

//        Listar tarefas
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();



        /*
         * Exibe lista de tarefas no RecyclerView
         */


//        Configurar um adapter
        tarefaAdapter = new TarefaAdapter(listaTarefas);

//        Configurar ReciclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvLista.setLayoutManager(layoutManager);
        rvLista.setHasFixedSize(true);
        rvLista.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvLista.setAdapter(tarefaAdapter);


    }

    @Override
    public void onStart() {
        carregarListaTarefas();
        super.onStart();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.itemSalvar:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
