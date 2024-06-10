package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class ControleFornecedor {

    public static final String CAMINHO_FORNECEDORES = "Fornecedores.txt";

    private static GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();

    public static void inicializarArquivoFornecedores() {
        List<String[]>fornecedores = gerenciadorDeArquivos.lerArquivo(CAMINHO_FORNECEDORES);
        if (fornecedores.isEmpty()) {
            // Adiciona o cabeçalho ao arquivo
            String[] header = {"cnpj","nome","telefone","endereco","marca"};
            gerenciadorDeArquivos.adicionarLinha(CAMINHO_FORNECEDORES, header);
        }
    }

    public static void cadastrarFornecedor(String cnpj, String nome, String telefone, String endereco, String marca) {
        Fornecedor fornecedor = new Fornecedor(cnpj, nome, telefone, endereco, marca);
        gravarFornecedor(fornecedor);
    }

    public static void gravarFornecedor(Fornecedor fornecedor) {
        List<String[]> fornecedores = new ArrayList<>();
        fornecedores.add(new String[]{
            fornecedor.getCnpj(),
            fornecedor.getNome(),
            fornecedor.getTelefone(),
            fornecedor.getEndereco(),
            fornecedor.getMarca()
        });
        gerenciadorDeArquivos.adicionarLinha(CAMINHO_FORNECEDORES, fornecedores.get(0));
    }

    public static List<String[]> buscarFornecedores() {
        List<String[]> fornecedores = gerenciadorDeArquivos.lerArquivo(CAMINHO_FORNECEDORES);
        List<String[]> fornecedoresSemCabecalho = new ArrayList<>();
        for (int i = 1; i < fornecedores.size(); i++) {
            fornecedoresSemCabecalho.add(fornecedores.get(i));
        }
        return fornecedoresSemCabecalho;
    }
}
