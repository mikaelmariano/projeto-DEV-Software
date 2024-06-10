package br.edu.up.modelos;

public class Medico {
    private String cpf;
    private String crm;
    private String nome;
    private String especialidade;

    // Construtor
    public Medico(String cpf, String crm, String nome, String especialidade) {
        this.cpf = cpf;
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
