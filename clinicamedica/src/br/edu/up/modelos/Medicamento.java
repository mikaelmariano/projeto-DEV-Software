package br.edu.up.modelos;

public class Medicamento extends Fornecedor {

    protected String nomeMedicamento;

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public Medicamento(String nome, String telefone, String email, String endereco, String cNPJ, String marca,
            String nomeMedicamento) {
        super(nome, telefone, email, endereco, cNPJ, marca);
        this.nomeMedicamento = nomeMedicamento;
    }

    @Override
    public String toString() {
        return "Medicamento [nomeMedicamento=" + nomeMedicamento + ", CNPJ=" + CNPJ + ", Marca=" + Marca + "]";
    }

    public String toCSV() {
        return nomeMedicamento + ";" + CNPJ + ";" + Marca;
    }
}