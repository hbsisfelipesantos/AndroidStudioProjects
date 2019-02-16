package com.example.felipesantos.classesemetodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cao cao = new Cao();
        cao.setCorPesoTamanho("Malhado", 7.8, 3);
        System.out.println(cao.getCor());
        System.out.println(cao.getPeso());
        System.out.println(cao.getTamanho());
        cao.dormir();
        cao.correr();
        cao.latir();


        Passaro passaro = new Passaro();
        passaro.setCorPesoTamanho("Azul", 1.5, 1);
        System.out.println(passaro.getCor());
        System.out.println(passaro.getPeso());
        System.out.println(passaro.getTamanho());
        passaro.dormir();
        passaro.correr();
        passaro.voar();





        /*
        Animal animal = new Animal();
animal.correr();
*/
        /*
        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Felipe";
        funcionario.salario = 2000.00;

        System.out.printf("Meu salario é: R$ %.2f\n", funcionario.getSalario(500, 50) - 20);
*/
       /* Casa minhaCasa = new Casa();

        minhaCasa.cor = "Blue";
        System.out.println(minhaCasa.cor);
        minhaCasa.abrirPorta();
        */

    }
}
