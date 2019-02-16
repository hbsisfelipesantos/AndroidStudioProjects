package com.example.felipesantos.passandodadosactivitiesprojeto;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nome, email;

    public Usuario(String nome, String emial) {
        this.nome = nome;
        this.email = emial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
