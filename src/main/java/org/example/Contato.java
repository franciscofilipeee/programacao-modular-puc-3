package org.example;

public class Contato {

    protected String nome;

    protected String email;

    protected String telefone;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void mostrarContato() {
        System.out.println("Nome: " + this.nome + "\nEmail: " + this.email + "\nTelefone: " + this.telefone);
    }
}
