package br.edu.up.telas;

import java.util.List;


import br.edu.up.controles.PacienteController;
import br.edu.up.util.Prompt;
import br.edu.up.modelos.Paciente;
import br.edu.up.modelos.Medico;
import br.edu.up.modelos.Fornecedor;

public class TelaPrincipal {

   // private ControleDePessoas controle = new ControleDePessoas();

    public void mostrarMenuPrincipal() {

        int op = 0;

        do {
            Prompt.limparConsole();
            Prompt.separador();
            Prompt.imprimir("MENU PRINCIPAL");
            Prompt.separador();

            Prompt.imprimir("1. Incluir Paciente");
            Prompt.imprimir("2. Incluir Médico");
            Prompt.imprimir("3. Incluir Fornecedor");
            Prompt.imprimir("4. Mostrar dados Paciente");
            Prompt.imprimir("5. Mostrar dados Médico");
            Prompt.imprimir("6. Mostrar dados Fornecedor");
            Prompt.imprimir("7. Mostrar todas as pessoas");

            Prompt.imprimir("8. Sair");

            op = Prompt.lerInteiro();

            switch (op) {
                case 1:
                    mostrarMenuIncluirPaciente();
                    break;
                case 2:
                    mostrarMenuIncluirMedico();
                    break;
                case 3:
                    mostrarMenuIncluirFornecedor();
                    break;
                case 4:
                    mostrarDadosPacientes();
                    break;
                case 5:
                    mostrarDadosMedicos();
                    break;
                case 6:
                    mostrarDadosFornecedores();
                    break;
                case 7:
                    mostrarTodasPessoas();
                    break;
                case 8:
                 //   controle.gravarDados();
                    Prompt.imprimir("Saindo...");
                    break;
                default:
                    Prompt.imprimir("Opção inválida!");
                    Prompt.pressionarEnter();
                    break;
            }
        } while (op != 8);
    }

    private void mostrarMenuIncluirPaciente() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR PACIENTE");
        Prompt.separador();

        String nome = Prompt.lerLinha("Nome: ");
        String telefone = Prompt.lerLinha("Telefone: ");
        String email = Prompt.lerLinha("Email: ");
        String endereco = Prompt.lerLinha("Endereço: ");
        String cpf = Prompt.lerLinha("CPF: ");
        String sus = Prompt.lerLinha("SUS: ");

        Paciente paciente = new Paciente(nome, telefone, email, endereco, cpf, sus);
        PacienteController.incluir(paciente);

        Prompt.imprimir("Paciente incluído com sucesso!");
        Prompt.pressionarEnter();
    }

    private void mostrarMenuIncluirMedico() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR MÉDICO");
        Prompt.separador();

        String nome = Prompt.lerLinha("Nome: ");
        String telefone = Prompt.lerLinha("Telefone: ");
        String email = Prompt.lerLinha("Email: ");
        String endereco = Prompt.lerLinha("Endereço: ");
        String CRM = Prompt.lerLinha("CRM: ");
        String CPF = Prompt.lerLinha("CPF: ");
        String Especialidade = Prompt.lerLinha("Especialidade: ");

        Medico medico = new Medico(nome, telefone, email, endereco, CRM, CPF, Especialidade);
        //controle.incluir(medico);

        

        Prompt.imprimir("Médico incluído com sucesso!");
        Prompt.pressionarEnter();
    }

    private void mostrarMenuIncluirFornecedor() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR FORNECEDOR");
        Prompt.separador();

        String nome = Prompt.lerLinha("Nome: ");
        String telefone = Prompt.lerLinha("Telefone: ");
        String email = Prompt.lerLinha("Email: ");
        String endereco = Prompt.lerLinha("Endereço: ");
        String CNPJ = Prompt.lerLinha("CNPJ: ");
        String Marca = Prompt.lerLinha("Marca: ");

        Fornecedor fornecedor = new Fornecedor(nome, telefone, email, endereco, CNPJ, Marca);
        //controle.incluir(fornecedor);

        Prompt.imprimir("Fornecedor incluído com sucesso!");
        Prompt.pressionarEnter();
    }

    private void mostrarDadosPacientes() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE PACIENTES");
        Prompt.separador();

        // List<Paciente> listaPacientes = controle.getPacientes();
        // for (Paciente paciente : listaPacientes) {
        //     Prompt.imprimir(paciente);
        // }

        Prompt.pressionarEnter();
    }

    private void mostrarDadosMedicos() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE MÉDICOS");
        Prompt.separador();

        // List<Medico> listaMedicos = controle.getMedicos();
        // for (Medico medico : listaMedicos) {
        //     Prompt.imprimir(medico);
        // }

        Prompt.pressionarEnter();
    }

    private void mostrarDadosFornecedores() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE FORNECEDORES");
        Prompt.separador();

        // List<Fornecedor> listaFornecedores = controle.getFornecedores();
        // for (Fornecedor fornecedor : listaFornecedores) {
        //     Prompt.imprimir(fornecedor);
        // }

        Prompt.pressionarEnter();
    }

    private void mostrarTodasPessoas() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE TODAS AS PESSOAS");
        Prompt.separador();

        // List<Object> listaPessoas = controle.getPessoas();
        // for (Object pessoa : listaPessoas) {
        //     Prompt.imprimir(pessoa);
        // }

        Prompt.pressionarEnter();
    }
}