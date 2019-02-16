package com.example.felipesantos.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlerta(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
// setar um titulo
        dialog.setTitle("Dialog");
//        setar menssagem
        dialog.setMessage("mghdkjfhakj hkdjghfaksdhfkçagh çkdgh ak ghaçghaçkgjhaçk ghjadgçkjhadkgjhadfkjghaç agjdhaçkjdshgfçakdç jadghçad ghaçkdgj gadfkjhgçagkjhaçlgh akjghçakjdghaçkgj hdakjg hçkdshgçadg ha dçlagh dçlghaçlsgdalghjaçldgfha çlgdha " +
                "akdgfhçjal ghjla gdçlakgjals gladshj galkdgjla kgdflagkdjsçlgkjasdlgkj açlsdgkj a");
//        setar cancelamento de AlertDialog
        dialog.setCancelable(true);
//        setar icone
        dialog.setIcon(android.R.drawable.alert_dark_frame);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Sim selecionado", Toast.LENGTH_SHORT).show();

            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Não selecionado", Toast.LENGTH_SHORT).show();
            }
        });

//        criar e exibir Alertdialog
        dialog.create();
        dialog.show();


    }
}
