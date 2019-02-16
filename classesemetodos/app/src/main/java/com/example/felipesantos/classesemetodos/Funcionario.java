package com.example.felipesantos.classesemetodos;

public class Funcionario {
    String nome;
    double salario;

   double getSalario(double bonus, double descontoAdd) {
        this.salario -= this.salario * 0.1;
        this.salario += bonus;
        this.salario -= descontoAdd;
        //System.out.println(this.salario);
       return this.salario;
    }
}
