package br.edu.up.modelos;

public class Fornecedor {

    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;
    protected String CNPJ;
    protected String Marca;

    public Fornecedor(String nome, String telefone, String email, String endereco, String cNPJ, String marca) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.CNPJ = cNPJ;
        this.Marca = marca;
    }

    public String toCSV() {
        return nome + ";" + telefone + ";" + email + ";" + endereco + ";" + CNPJ + ";" + Marca;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email + ", Endereço: " + endereco
                + ", CNPJ: " + CNPJ + ", Marca: " + Marca;
    }
}
