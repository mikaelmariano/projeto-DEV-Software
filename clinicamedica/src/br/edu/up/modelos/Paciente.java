package br.edu.up.modelos;

public class Paciente {
    private String cpf;
    private String sus;
    private String nome;
    private String dtNascimento;
    private String telefone;

    // Construtor
    public Paciente(String cpf, String sus, String nome, String dtNascimento, String telefone) {
        this.cpf = cpf;
        this.sus = sus;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
