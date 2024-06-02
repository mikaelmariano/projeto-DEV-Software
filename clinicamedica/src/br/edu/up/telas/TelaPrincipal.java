package br.edu.up.telas;

import java.util.List;

import br.edu.up.controles.ControleDePessoas;
import br.edu.up.util.Prompt;
import br.edu.up.modelos.Pessoa;
import br.edu.up.modelos.PessoaPaciente;

public class TelaPrincipal {

    private ControleDePessoas controle = new ControleDePessoas();

    public void mostrarMenuPrincipal() {

        int op = 0;

        do {

            Prompt.limparConsole();
            Prompt.separador();
            Prompt.imprimir("MENU PRINCIPAL");
            Prompt.separador();

            Prompt.imprimir("1. Incluir Paciente"); //implementado por Mikael
            Prompt.imprimir("2. Incluir Médico");
            Prompt.imprimir("3. Incluir Fabricante");
            Prompt.imprimir("4. Mostrar dados Paciente"); //implemantado por Mikael
            Prompt.imprimir("5. Mostrar dados Médico");
            Prompt.imprimir("6. Mostrar dados Fabricante");
            Prompt.imprimir("7. Mostrar todos as pessoas");
            

            Prompt.imprimir("8. Incluir Medicamento");
            Prompt.imprimir("9. Incluir Agendamento");
            Prompt.imprimir("10. Incluir Historico");
            Prompt.imprimir("11. Mostrar dados Medicamento");
            Prompt.imprimir("12. Mostrar dados Agendamento");
            Prompt.imprimir("13. Mostrar dados Historico");

            Prompt.imprimir("14. Sair");

            op = Prompt.lerInteiro();

            switch (op) {
                case 1:
                    // 1. Incluir PACIENTE
                    mostrarMenuIncluirPessoas();
                    break;

                case 4:
                    // 4. Mostrar dados Pacientes
                    Prompt.separador();
                    Prompt.imprimir("LISTA DE PACIENTES");
                    List<PessoaPaciente> listaPessoas = controle.getPessoasPaciente();
                    for (PessoaPaciente clientePessoa : listaPessoas) {
                        Prompt.imprimir(clientePessoa);
                    }
                    Prompt.pressionarEnter();
                    break;
                case 7:
                    // 7. Mostrar todas as pessoas
                    Prompt.separador();
                    Prompt.imprimir("LISTA DE PESSOAS");
                    List<Pessoa> pessoas = controle.getPessoas();
                    for (Pessoa pessoa : pessoas) {
                        Prompt.imprimir(pessoa);
                    }
                    Prompt.pressionarEnter();
                    break;

            }

        } while (op != 14);

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

        Prompt.imprimir("Digite o telefone;");
        String telefone = Prompt.lerLinha();

        Prompt.imprimir("Digite o email;");
        String email = Prompt.lerLinha();

        Prompt.imprimir("Digite o endereco;");
        String endereco = Prompt.lerLinha();

        Prompt.imprimir("Digite o CPF;");
        String cpf = Prompt.lerLinha();

        Prompt.imprimir("Digite o codigo SUS;");
        String sus = Prompt.lerLinha();

        PessoaPaciente pessoaPaciente = new PessoaPaciente(nome, telefone, email, endereco, cpf ,sus);
        controle.incluir(pessoaPaciente);
    }

}
