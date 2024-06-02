package br.edu.up.modelos;

public abstract class Pessoa {
    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;

    public Pessoa(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

 
    public abstract String toCSV();
}
