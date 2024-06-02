package br.edu.up.controles;

import java.util.List;
import java.util.ArrayList;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Pessoa;
import br.edu.up.modelos.PessoaPaciente;

public class ControleDePessoas {

    private GerenciadorDeArquivos gArquivos = new GerenciadorDeArquivos();

    private List<Pessoa> clientes;

    public ControleDePessoas() {
        this.clientes = gArquivos.getClientes();
    }

    public void incluir(Pessoa cliente) {
        this.clientes.add(cliente);
    }

    public List<Pessoa> getClientes() {
        return clientes;
    }

    public PessoaPaciente getPessoa(String sus) {

        List<PessoaPaciente> pessoas = getClientesPessoa();
        for (PessoaPaciente clientePessoa : pessoas) {
            if (clientePessoa.getSus().equals(sus)) {
                return clientePessoa;
            }
        }
        return null;
    }

    public List<PessoaPaciente> getClientesPessoa() {
        List<PessoaPaciente> lista = new ArrayList<>();
        for (Pessoa cliente : clientes) {
            if (cliente instanceof PessoaPaciente) {
                PessoaPaciente cp = (PessoaPaciente) cliente;
                lista.add(cp);
            }
        }
        return lista;
    }

    public boolean gravarDados() {
        // boolean retorno = gArquivos.gravar(clientes);
        // return retorno;
        return gArquivos.gravar(clientes);
    }

}
