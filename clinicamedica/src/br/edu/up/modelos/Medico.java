package br.edu.up.modelos;

public class Medico {

    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String CRM;
    private String CPF;
    private String Especialidade;

    public Medico(String nome, String telefone, String email, String endereco, String CRM, String CPF, String Especialidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.CRM = CRM;
        this.CPF = CPF;
        this.Especialidade = Especialidade;
    }
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCRM() {
        return CRM;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEspecialidade(String especialidade) {
        this.Especialidade = especialidade;
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