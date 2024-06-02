package br.edu.up.modelos;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String dataNasc;
    protected String endereco;

    public Pessoa(String nome, String cpf, String dataNasc, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

 
    public abstract String toCSV();
}
