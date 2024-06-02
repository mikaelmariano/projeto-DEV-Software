package br.edu.up.telas;

import java.util.List;

import br.edu.up.controles.ControleDeClientes;
import br.edu.up.util.Prompt;
import br.edu.up.modelos.Pessoa;
import br.edu.up.modelos.PessoaPaciente;

public class TelaPrincipal {

    private ControleDeClientes controle = new ControleDeClientes();

    public void mostrarMenuPrincipal() {

        int op = 0;

        do {

            Prompt.limparConsole();
            Prompt.separador();
            Prompt.imprimir("MENU PRINCIPAL");
            Prompt.separador();

            Prompt.imprimir("1. Incluir cliente pessoa");
            Prompt.imprimir("2. Incluir cliente empresa");
            Prompt.imprimir("3. Mostrar dados cliente pessoa");
            Prompt.imprimir("4. Mostrar dados cliente empresa");
            Prompt.imprimir("5. Mostrar todos os clientes");
            Prompt.imprimir("6. Emprestar");
            Prompt.imprimir("7. Devolver");
            Prompt.imprimir("8. Sair");

            op = Prompt.lerInteiro();

            switch (op) {
                case 1:
                    // 1. Incluir cliente pessoa
                    mostrarMenuIncluirPessoas();
                    break;
                case 3:
                    // 3. Mostrar dados cliente pessoa
                    Prompt.separador();
                    Prompt.imprimir("LISTA DE CLIENTES PESSOA");
                    List<PessoaPaciente> listaPessoas = controle.getClientesPessoa();
                    for (PessoaPaciente clientePessoa : listaPessoas) {
                        Prompt.imprimir(clientePessoa);
                    }
                    Prompt.pressionarEnter();
                    break;
                case 5:
                    // 5. Mostrar todos os clientes
                    Prompt.separador();
                    Prompt.imprimir("LISTA DE CLIENTES");
                    List<Pessoa> clientes = controle.getClientes();
                    for (Pessoa cliente : clientes) {
                        Prompt.imprimir(cliente);
                    }
                    Prompt.pressionarEnter();
                    break;

            }

        } while (op != 8);

        if (controle.gravarDados()) {
            Prompt.imprimir("Dados gravados com sucesso!");
        } else {
            Prompt.imprimir("Erro na gravação do arquivo!");
        }
        Prompt.imprimir("Programa encerrado!");

    }


    private void mostrarMenuIncluirPessoas() {

        Prompt.separador();
        Prompt.imprimir("MENU INCLUIR PESSOA");
        Prompt.separador();

        Prompt.imprimir("Digite o nome;");
        String nome = Prompt.lerLinha();

        Prompt.imprimir("Digite o cpf;");
        String cpf = Prompt.lerLinha();

        Prompt.imprimir("Digite o dataNasc;");
        String dataNasc = Prompt.lerLinha();

        Prompt.imprimir("Digite o endereco;");
        String endereco = Prompt.lerLinha();

        Prompt.imprimir("Digite o sus;");
        String sus = Prompt.lerLinha();

        PessoaPaciente clientePessoa = new PessoaPaciente(nome, cpf, dataNasc, endereco, sus);
        controle.incluir(clientePessoa);
    }

}
