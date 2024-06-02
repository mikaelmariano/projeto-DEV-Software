package br.edu.up.controles;

import java.util.List;
import java.util.ArrayList;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Pessoa;
import br.edu.up.modelos.PessoaPaciente;

public class ControleDePessoas {

    private GerenciadorDeArquivos gArquivos = new GerenciadorDeArquivos();

    private List<Pessoa> pessoas;

    public ControleDePessoas() {
        this.pessoas = gArquivos.getPessoas();
    }

    public void incluir(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
////
    public PessoaPaciente getPessoa(String sus) {

        List<PessoaPaciente> pessoas = getPessoasPaciente();
        for (PessoaPaciente pessoaPaciente : pessoas) {
            if (pessoaPaciente.getSus().equals(sus)) {
                return pessoaPaciente;
            }
        }
        return null;
    }

    public List<PessoaPaciente> getPessoasPaciente() {
        List<PessoaPaciente> lista = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof PessoaPaciente) {
                PessoaPaciente pp = (PessoaPaciente) pessoa;
                lista.add(pp);
            }
        }
        return lista;
    }

    public boolean gravarDados() {
        // boolean retorno = gArquivos.gravar(clientes);
        // return retorno;
        return gArquivos.gravar(pessoas);
    }

}