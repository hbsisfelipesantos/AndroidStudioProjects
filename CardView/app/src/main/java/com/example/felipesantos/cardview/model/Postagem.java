package com.example.felipesantos.cardview.model;

import android.widget.ImageView;

public class Postagem {
    private String nome, postagem;
    private int imagemPostagem;

    public Postagem() {
    }

    public Postagem(String nome, String postagem, int imagemPostagem) {
        this.nome = nome;
        this.postagem = postagem;
        this.imagemPostagem = imagemPostagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImagemPostagem() {
        return imagemPostagem;
    }

    public void setImagemPostagem(int imagemPostagem) {
        this.imagemPostagem = imagemPostagem;
    }
}
