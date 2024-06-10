package br.edu.up.telas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.up.controles.ControleDeAgendamentos;
import br.edu.up.controles.ControleDePessoas;
import br.edu.up.controles.PacienteController;
import br.edu.up.util.Prompt;
import br.edu.up.modelos.Paciente;
import br.edu.up.modelos.Medico;
import br.edu.up.modelos.Agendamento;
import br.edu.up.modelos.Fornecedor;

public class TelaPrincipal {

    private ControleDePessoas controle = new ControleDePessoas();
    private ControleDeAgendamentos controleAgendamentos = new ControleDeAgendamentos();

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
            Prompt.imprimir("7. Sair");

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
                    controle.gravarDados();
                    Prompt.imprimir("Saindo...");
                    break;
                default:
                    Prompt.imprimir("Opção inválida!");
                    Prompt.pressionarEnter();
                    break;
            }
        } while (op != 8);
    }

    //PACIENTE: 

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
        PacienteController.IncluirPaciente(paciente);

        Prompt.imprimir("Paciente incluído com sucesso!");
        Prompt.pressionarEnter();
    }
    
    private void mostrarDadosPacientes() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE PACIENTES");
        Prompt.separador();

        List<Paciente> listaPacientes = controle.getPacientes();
        for (Paciente paciente : listaPacientes) {
            Prompt.imprimir(paciente);
        }

        Prompt.pressionarEnter();
    }

    //MEDICO:

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
        controle.incluir(medico);

        Prompt.imprimir("Médico incluído com sucesso!");
        Prompt.pressionarEnter();
    }
    
    private void mostrarDadosMedicos() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE MÉDICOS");
        Prompt.separador();

        List<Medico> listaMedicos = controle.getMedicos();
        for (Medico medico : listaMedicos) {
            Prompt.imprimir(medico);
        }

        Prompt.pressionarEnter();
    }


    //FORNECEDOR: 

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
        controle.incluir(fornecedor);

        Prompt.imprimir("Fornecedor incluído com sucesso!");
        Prompt.pressionarEnter();
    }
    
    private void mostrarDadosFornecedores() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE FORNECEDORES");
        Prompt.separador();

        List<Fornecedor> listaFornecedores = controle.getFornecedores();
        for (Fornecedor fornecedor : listaFornecedores) {
            Prompt.imprimir(fornecedor);
        }

        Prompt.pressionarEnter();
    }

    //AGENDAMENTO:

    private void mostrarMenuIncluirAgendamento() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("INCLUIR AGENDAMENTO");
    Prompt.separador();

    String paciente = Prompt.lerLinha("Nome do Paciente: ");
    String medico = Prompt.lerLinha("Nome do Médico: ");
    String dataHoraStr = Prompt.lerLinha("Data e Hora (formato: yyyy-MM-ddTHH:mm): ");
    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    Agendamento agendamento = new Agendamento(paciente, medico, dataHora);
    controleAgendamentos.incluirAgendamento(agendamento); 

    Prompt.imprimir("Agendamento incluído com sucesso!");
    Prompt.pressionarEnter();
    }

    private void mostrarAgendamentos() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("LISTA DE AGENDAMENTOS");
    Prompt.separador();
    }
    
    // List<Agendamento> listaAgendamentos = controleAgendamentos.getAgendamentos(); 
    // for (Agendamento agendamento : listaAgendamentos) {
    //     Prompt.imprimir(agendamento);
    // }

    // Prompt.pressionarEnter();

    

}