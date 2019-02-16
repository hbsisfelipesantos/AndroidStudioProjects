package com.example.felipesantos.classesemetodos;

class Cao extends Animal{

    void latir(){
        System.out.println("Latir");
    }
    void correr(){
        super.correr();
        System.out.println("Cão");
    }

}
