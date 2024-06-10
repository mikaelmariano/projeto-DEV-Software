package br.edu.up.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    public List<String[]> lerArquivo(String caminho) {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.split(";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public void escreverArquivo(String caminho, List<String[]> dados, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, append))) {
            for (String[] dado : dados) {
                if (dado.length == 1) {
                    writer.write(dado[0]);  // Escreve o cabeçalho
                } else {
                    writer.write(String.join(";", dado));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarLinha(String caminho, String[] linha) {
        List<String[]> linhas = new ArrayList<>();
        linhas.add(linha);
        escreverArquivo(caminho, linhas, true);
    }

    public void atualizarArquivo(String caminho, List<String[]> dados) {
        escreverArquivo(caminho, dados, false);
    }

    public void atualizarLinhaEspecifica(String caminho, List<String[]> linhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String[] linha : linhas) {
                bw.write(String.join(";", linha));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}
