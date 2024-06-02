package br.edu.up.modelos;

public class PessoaPaciente extends Pessoa {

    private String cpf;
    private String sus;

    public String getSus() {
        return this.sus;
    }

    public String getCpf() {
        return this.cpf;
    }

    public PessoaPaciente(String nome, String telefone, String email, String endereco,
            String cpf, String sus) {
        super(nome, telefone, email, endereco);
        this.sus = sus;
        this.cpf = cpf;
    }

    public String toCSV() {
        return nome + ";" + telefone + ";" + email + ";" + endereco + ";" + cpf +";"+ sus + ";;;;";
    }

    @Override
    public String toString(){
        return nome + ";" + telefone + ";" + email + ";" + endereco + ";" + cpf +";"+ sus + ";;;;";
    }
}
