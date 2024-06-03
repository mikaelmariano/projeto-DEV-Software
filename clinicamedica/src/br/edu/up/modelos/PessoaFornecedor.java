package br.edu.up.modelos;

public class PessoaFornecedor extends Pessoa{

    protected String CNPJ;

    protected String Marca;


    public PessoaFornecedor(String nome, String telefone, String email, String endereco) {
        
        super(nome, telefone, email, endereco);

    
    }


    @Override
    public String toCSV() {
    
        return null;
    }

    

    

}
