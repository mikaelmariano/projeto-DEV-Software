package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Paciente;
import br.edu.up.modelos.Medico;
import br.edu.up.modelos.Fornecedor;

public class GerenciadorDeArquivos {

    private String header = "nome;telefone;email;endereco;cpf;crm;sus;cnpj;marca;especialidade";
    private String nomeDoArquivo = "C:\\temp\\pessoas.csv";

    public List<Object> getPessoas() {
        List<Object> listaDePessoas = new ArrayList<>();

        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);

            // Armazeno cabeçalho
            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String nome = dados[0];
                String telefone = dados[1];
                String email = dados[2];
                String endereco = dados[3];
                String cpf = dados[4];
                String crm = dados[5];
                String sus = dados[6];
                String cnpj = dados[7];
                String marca = dados[8];
                String especialidade = dados[9];

                if (!cpf.isEmpty() && !sus.isEmpty()) {
                    Paciente paciente = new Paciente(nome, telefone, email, endereco, cpf, sus);
                    listaDePessoas.add(paciente);
                } else if (!crm.isEmpty()) {
                    Medico medico = new Medico(nome, telefone, email, endereco, crm, cpf, especialidade);
                    listaDePessoas.add(medico);
                } else if (!cnpj.isEmpty()) {
                    Fornecedor fornecedor = new Fornecedor(nome, telefone, email, endereco, cnpj, marca);
                    listaDePessoas.add(fornecedor);
                }
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        return listaDePessoas;
    }

    public boolean gravar(List<Object> pessoas) {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for (Object pessoa : pessoas) {
                if (pessoa instanceof Paciente) {
                    gravador.println(((Paciente) pessoa).toCSV());
                } else if (pessoa instanceof Medico) {
                    gravador.println(((Medico) pessoa).toCSV());
                } else if (pessoa instanceof Fornecedor) {
                    gravador.println(((Fornecedor) pessoa).toCSV());
                }
            }
            gravador.close();

            return true;
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }

        return false;
    }
}