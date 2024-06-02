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
import br.edu.up.modelos.PessoaPaciente;

public class GerenciadorDeArquivos {

    private String header = "";
    private String nomeDoArquivo = "C:\\temp\\pessoas.csv";

    public List<Pessoa> getPessoas() {

        List<Pessoa> listaDePessoas = new ArrayList<>();

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
                String telefone = dados[1];
                String email = dados[2];
                String endereco = dados[3];
                String cpf = dados[4];
                 if (cpf != null && !cpf.equals("")) {
                    //Paciente
                     String sus = dados[5];

                     Pessoa pessoa = new PessoaPaciente(nome, telefone, email,
                             endereco, cpf, sus);
                     listaDePessoas.add(pessoa);
                 }
                //  else if (cnpj != null && !cnpj.equals("")) {
                //     //Fornecedor

                //  }else {
                //     //Medico
                //  }

            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        return listaDePessoas;
    }

    public boolean gravar(List<Pessoa> pessoas) {

        try {
            // GRAVAR UM ARQUIVO DE TEXTO
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for (Pessoa pessoa : pessoas) {
                gravador.println(pessoa.toCSV());
            }
            gravador.close();

            return true;

        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }

        return false;
    }

}
