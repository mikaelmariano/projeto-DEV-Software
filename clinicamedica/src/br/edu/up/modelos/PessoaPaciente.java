package br.edu.up.modelos;

public class PessoaPaciente extends Pessoa {

    private String sus;

    public String getSus() {
        return this.sus;
    }

    public PessoaPaciente(String nome, String cpf, String dataNasc, String endereco,
            String sus) {
        super(nome, cpf, dataNasc, endereco);
        this.sus = sus;
    }

    public String toCSV() {
        return nome + ";" + cpf + ";" + dataNasc + ";" + endereco + ";" + sus + ";;";
    }

}
