package br.edu.up.modelos;

public class PessoaMedico extends Pessoa{

    protected String CRM;
    protected String CPF;
    protected String Especialidade;

    public PessoaMedico(String nome, String telefone, String email, String endereco) {
        
        super(nome, telefone, email, endereco);

    
    }

    

    @Override
    public String toCSV() {
        
        return "";
    }

    

}
