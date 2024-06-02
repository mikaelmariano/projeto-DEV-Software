package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Pessoa;
// import br.edu.up.modelos.ClientePessoa;

public class GerenciadorDeArquivos {

    private String header = "";
    private String nomeDoArquivo = "C:\\temp\\clientes.csv";

    public List<Pessoa> getClientes() {

        List<Pessoa> listaDeClientes = new ArrayList<>();

        try {
            // LER UM ARQUIVO DE TEXTO
            File arquivoLeitura = new File(nomeDoArquivo);
            // Scanner leitor = new Scanner(System.in); //Teclado
            Scanner leitor = new Scanner(arquivoLeitura);

            // Armazeno cabeçalho
            header = leitor.nextLine();

            // Enquanto tiver linha no arquivo
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String nome = dados[0];
                String cpf = dados[1];
                String dataNasc = dados[2];
                String endereco = dados[3];
                String sus = dados[4];
                // if (cpf != null && !cpf.equals("")) {
                //     // pessoa
                //     double peso = Double.parseDouble(dados[6]);
                //     double altura = Double.parseDouble(dados[7]);

                //     Cliente cliente = new ClientePessoa(nome, telefone, email,
                //             credito, emprestado, cpf, peso, altura);
                //     listaDeClientes.add(cliente);

                // } else {
                //     // empresa
                //     String cnpj = dados[8];
                //     String inscricao = dados[9];
                //     int ano = Integer.parseInt(dados[10]);

                //     Cliente cliente = new ClienteEmpresa(nome, telefone, email, cnpj, inscricao, ano);
                //     listaDeClientes.add(cliente);
                // }
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        return listaDeClientes;
    }

    public boolean gravar(List<Pessoa> clientes) {

        try {
            // GRAVAR UM ARQUIVO DE TEXTO
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for (Pessoa cliente : clientes) {
                gravador.println(cliente.toCSV());
            }
            gravador.close();

            return true;

        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }

        return false;
    }

}
