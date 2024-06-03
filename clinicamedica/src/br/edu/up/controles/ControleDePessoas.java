package br.edu.up.controles;

import java.util.List;
import java.util.ArrayList;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Paciente;
import br.edu.up.modelos.Medico;
import br.edu.up.modelos.Fornecedor;

public class ControleDePessoas {

    private GerenciadorDeArquivos gArquivos = new GerenciadorDeArquivos();

    private List<Object> pessoas;

    public ControleDePessoas() {
        this.pessoas = gArquivos.getPessoas();
    }

    public void incluir(Object pessoa) {
        this.pessoas.add(pessoa);
    }

    public List<Object> getPessoas() {
        return pessoas;
    }

    public List<Paciente> getPacientes() {
        List<Paciente> lista = new ArrayList<>();
        for (Object pessoa : pessoas) {
            if (pessoa instanceof Paciente) {
                lista.add((Paciente) pessoa);
            }
        }
        return lista;
    }

    public List<Medico> getMedicos() {
        List<Medico> lista = new ArrayList<>();
        for (Object pessoa : pessoas) {
            if (pessoa instanceof Medico) {
                lista.add((Medico) pessoa);
            }
        }
        return lista;
    }

    public List<Fornecedor> getFornecedores() {
        List<Fornecedor> lista = new ArrayList<>();
        for (Object pessoa : pessoas) {
            if (pessoa instanceof Fornecedor) {
                lista.add((Fornecedor) pessoa);
            }
        }
        return lista;
    }

    public boolean gravarDados() {
        return gArquivos.gravar(pessoas);
    }
}