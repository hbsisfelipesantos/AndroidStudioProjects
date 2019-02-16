package com.example.felipesantos.recyclerview.Activity.model;

public class Filme {

    private String tiuloFilme, genero, ano;

    public Filme(String tiuloFilme, String genero, String ano){
        this.tiuloFilme = tiuloFilme;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTiuloFilme() {
        return tiuloFilme;
    }

    public void setTiuloFilme(String tiuloFilme) {
        this.tiuloFilme = tiuloFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
