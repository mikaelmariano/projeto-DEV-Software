package br.edu.up.modelos;

public class Medico {

    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;
    protected String CRM;
    protected String CPF;
    protected String Especialidade;

    public Medico(String nome, String telefone, String email, String endereco, String CRM, String CPF,
            String Especialidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.CRM = CRM;
        this.CPF = CPF;
        this.Especialidade = Especialidade;
    }

    public String toCSV() {
        return nome + ";" + telefone + ";" + email + ";" + endereco + ";" + CPF + ";" + CRM + ";;" + Especialidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email + ", Endereço: " + endereco + ", CRM: "
                + CRM + ", CPF: " + CPF + ", Especialidade: " + Especialidade;
    }
}