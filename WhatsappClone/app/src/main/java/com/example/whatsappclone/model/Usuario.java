package com.example.whatsappclone.model;

public class Usuario {
    private String Nome, Email, Senha;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha) {
        Nome = nome;
        Email = email;
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
