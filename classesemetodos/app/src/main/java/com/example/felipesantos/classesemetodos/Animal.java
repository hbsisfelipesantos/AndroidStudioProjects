package com.example.felipesantos.classesemetodos;

class Animal {
    int tamanho;
    String cor;
    double peso;

    void setCorPesoTamanho( String cor, double peso, int tamanho){
        this.cor = cor;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    String getCor(){
        return this.cor;
    }
    double getPeso(){
        return this.peso;
    }
    int getTamanho(){
        return this.tamanho;
    }

    void dormir(){
        System.out.println("Dormir");
    }
    void correr(){
        System.out.printf("Correr como um ");
    }

}
