package com.example.felipesantos.classesemetodos;

class Passaro extends Animal{
    void voar(){
        System.out.println("Voar");
    }
    void correr(){
        super.correr();
        System.out.println("Passaro");
    }
}
