package br.edu.up.modelos;

public class Paciente {

    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;
    private String cpf;
    private String sus;

    public String getSus() {
        return this.sus;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Paciente(String nome, String telefone, String email, String endereco, String cpf, String sus) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.sus = sus;
    }

    public String toCSV() {
        return nome + ";" + telefone + ";" + email + ";" + endereco + ";" + cpf + ";" + sus + ";";
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email + ", Endereço: " + endereco + ", CPF: " + cpf + ", SUS: " + sus;
    }
}