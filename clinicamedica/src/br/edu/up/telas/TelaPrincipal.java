package br.edu.up.telas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.up.controles.*;
import br.edu.up.util.Prompt;
import br.edu.up.modelos.*;

public class TelaPrincipal {

    public void mostrarMenuPrincipal() {

        int op = 0;

        do {

            Prompt.limparConsole();
            Prompt.separador();
            Prompt.imprimir("MENU PRINCIPAL");
            Prompt.separador();

            Prompt.imprimir("1. Incluir Paciente"); //Joao
            Prompt.imprimir("2. Incluir Médico"); // Samuel
            Prompt.imprimir("3. Incluir Fornecedor"); // Eudes
            Prompt.imprimir("4. Mostrar dados Paciente"); //Joao
            Prompt.imprimir("5. Mostrar dados Médico"); // Samuel
            Prompt.imprimir("6. Mostrar dados Fornecedores"); // Eudes
            Prompt.imprimir("7. Incluir Medicamento"); //Bruno
            Prompt.imprimir("8. Incluir Agendamento"); // Gabriela
            Prompt.imprimir("9. Incluir Consulta Médica"); //Mikael
            Prompt.imprimir("10. Mostrar dados Medicamento"); //Bruno
            Prompt.imprimir("11. Mostrar dados Agendamento"); //Gabriela
            Prompt.imprimir("12. Mostrar dados Prontuario Medico"); //Mikael

            Prompt.imprimir("13. Sair");

            op = Prompt.lerInteiro();

            switch (op) {
                case 1:
                    // 1. Incluir PACIENTE
                    mostrarMenuIncluirPaciente();
                    break;
                case 2:
                mostrarMenuIncluirMedico();
                break;   
                case 3:
                //3. Incluir Fornecedor
                mostrarMenuIncluirFornecedor();
                break;    
                case 4:
                    // 4. Mostrar dados Pacientes
                    mostrarDadosPacientes();
                    break;
                case 5:
                mostrarDadosMedicos();
                break;
                case 6:
                //6. Mostrar dados Fornecedores
                    mostrarDadosFornecedores();
                    break;
                case 7:
                //    7. Incluir Medicamento
                mostrarMenuIncluirMedicamento();
                break;
                case 8:
                mostrarMenuIncluirAgendamento();
                break;
                case 9:
                    // 10. Incluir Consulta Médica
                    mostrarMenuIncluirConsultaMedica();
                    break;
                case 10:
                    // 11. Mostrar dados Medicamento
                    mostrarDadosMedicamentos();
                    break;  
                case 11:
                mostrarDadosAgendamentos();
                break;      
                case 12:
                    //13. Mostrar dados Pronturio Medico
                    mostrarDadosConsultasMedicas();
                    break;

            }

        } while (op != 13);

        Prompt.imprimir("Programa encerrado!");

    }
//Consulta Medica
    private void mostrarMenuIncluirConsultaMedica() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR CONSULTA MÉDICA");
        Prompt.separador();
    
        String escolha = Prompt.lerLinha("Deseja buscar o agendamento por (1) ID ou (2) SUS, CRM e Data Agendada? ");
        String[] agendamento = null;
    
        if (escolha.equals("1")) {
            int id = Integer.parseInt(Prompt.lerLinha("ID do Agendamento: "));
            agendamento = ControleConsulta.buscarAgendamentoPorId(id);
        } else if (escolha.equals("2")) {
            String sus = Prompt.lerLinha("SUS: ");
            String crm = Prompt.lerLinha("CRM: ");
            String dataAgendada = Prompt.lerLinha("Data Agendada (AAAA-MM-DD): ");
            agendamento = ControleConsulta.buscarAgendamentoPorSusCrmEData(sus, crm, dataAgendada);
        } else {
            Prompt.imprimir("Opção inválida!");
            Prompt.pressionarEnter();
            return;
        }
    
        if (agendamento != null) {
            String idAgendamento = agendamento[0];
            String nomePaciente = agendamento[3];
            String nomeMedico = agendamento[5];
            String dataAgendamento = agendamento[6];
    
            Prompt.imprimir("Nome do Paciente: " + nomePaciente);
            Prompt.imprimir("Nome do Médico: " + nomeMedico);
            Prompt.imprimir("Data de Agendamento: " + dataAgendamento);
    
            // Verifica se a segunda coluna está vazia
            if (agendamento[1].isEmpty()) {
                String confirmar = Prompt.lerLinha("Deseja incluir a consulta? (s/n): ");
                if (confirmar.equalsIgnoreCase("s")) {
                    // Inicializa o último ID
                    ControleConsulta.inicializarUltimoId();
    
                    // Solicita os sintomas do usuário
                    String sintomas = Prompt.lerLinha("Informe os sintomas do paciente: ");
    
                    // Realiza a consulta com base nos dados fornecidos
                    Consulta consulta = ControleConsulta.realizarConsulta(nomePaciente, nomeMedico, dataAgendamento, sintomas);
    
                    // Grava a consulta em um arquivo de texto
                    ControleConsulta.gravarConsulta(consulta, idAgendamento);
    
                    // Adicionar medicamentos à consulta
                    List<String[]> medicamentosDisponiveis = ControleConsulta.buscarMedicamentos();
                    List<String> medicamentosReceitados = new ArrayList<>();
    
                    String adicionarMedicamentos = Prompt.lerLinha("Deseja adicionar medicamentos? (s/n): ");
                    if (adicionarMedicamentos.equalsIgnoreCase("s")) {
                        boolean exibirListaMedicamentos = true;
                        while (true) {
                            if (exibirListaMedicamentos) {
                                Prompt.imprimir("Medicamentos disponíveis:");
                                for (String[] medicamento : medicamentosDisponiveis) {
                                    Prompt.imprimir(medicamento[0] + " - " + medicamento[1]);
                                }
                                exibirListaMedicamentos = false;
                            }
                            String medicamentoEscolhido = Prompt.lerLinha("Digite o ID ou o nome do medicamento (ou 'S' para finalizar): ");
                            if (medicamentoEscolhido.equalsIgnoreCase("S")) {
                                break;
                            } else {
                                boolean encontrado = false;
                                for (String[] medicamento : medicamentosDisponiveis) {
                                    if (medicamento[0].equals(medicamentoEscolhido) || medicamento[1].equalsIgnoreCase(medicamentoEscolhido)) {
                                        medicamentosReceitados.add(medicamento[1]);
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    Prompt.imprimir("Medicamento não encontrado. Tente novamente.");
                                }
                            }
                        }
                    }
    
                    // Grava a relação entre consultas e medicamentos
                    ControleConsulta.gravarConsultaXMedicamentos(consulta.getId(), medicamentosReceitados);
    
                    Prompt.imprimir("Consulta médica incluída com sucesso!");
                }
            } else {
                Prompt.imprimir("A consulta já foi realizada para este agendamento.");
            }
        } else {
            Prompt.imprimir("Agendamento não encontrado!");
        }
    
        Prompt.pressionarEnter();
    }
    
    

    private void mostrarDadosConsultasMedicas() {
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("CONSULTAS MÉDICAS");
        Prompt.separador();
    
        String escolha = Prompt.lerLinha("Deseja filtrar por um paciente específico? (s/n): ");
        String nomePacienteFiltro = null;
        if (escolha.equalsIgnoreCase("s")) {
            nomePacienteFiltro = Prompt.lerLinha("Digite o nome do paciente: ");
        }
    
        try (BufferedReader brConsultas = new BufferedReader(new FileReader("Consultas.txt"));
             BufferedReader brConsultasXMedicamentos = new BufferedReader(new FileReader("ConsultasXMedicamentos.txt"))) {
    
            // Carregar os medicamentos associados a cada consulta em um mapa
            Map<Integer, List<String>> consultasXMedicamentos = new HashMap<>();
            String linha;
            
            // Pula o cabeçalho do arquivo ConsultasXMedicamentos.txt
            brConsultasXMedicamentos.readLine();
            
            while ((linha = brConsultasXMedicamentos.readLine()) != null) {
                String[] dados = linha.split(";");
                int idConsulta = Integer.parseInt(dados[0]);
                String medicamento = dados[1];
    
                consultasXMedicamentos
                    .computeIfAbsent(idConsulta, k -> new ArrayList<>())
                    .add(medicamento);
            }
    
            // Pula o cabeçalho do arquivo Consultas.txt
            brConsultas.readLine();
    
            // Ler e exibir os detalhes das consultas
            while ((linha = brConsultas.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String nomePaciente = dados[1];
                String nomeMedico = dados[2];
                String dataAgendamento = dados[3];
                String sintomas = dados[4];
    
                if (nomePacienteFiltro == null || nomePaciente.equalsIgnoreCase(nomePacienteFiltro)) {
                    Prompt.imprimir("ID: " + id);
                    Prompt.imprimir("Nome do Paciente: " + nomePaciente);
                    Prompt.imprimir("Nome do Médico: " + nomeMedico);
                    Prompt.imprimir("Data de Agendamento: " + dataAgendamento);
                    Prompt.imprimir("Histórico: Paciente com os seguintes sintomas: " + sintomas);
                    Prompt.imprimir("Medicamentos Receitados:");
    
                    List<String> medicamentos = consultasXMedicamentos.get(id);
                    if (medicamentos != null) {
                        for (String medicamento : medicamentos) {
                            Prompt.imprimir("  - " + medicamento);
                        }
                    }
    
                    Prompt.separador();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        Prompt.pressionarEnter();
    }
    
//MEDICAMENTOS

private void mostrarMenuIncluirMedicamento() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("INCLUIR MEDICAMENTO");
    Prompt.separador();

    String nomeMedicamento = Prompt.lerLinha("Nome do Medicamento: ");
    String nomeMarca = Prompt.lerLinha("Nome da Marca: ");

    // Inicializa o último ID
    ControleMedicamentos.inicializarUltimoId();

    // Cadastra o novo medicamento
    Medicamentos medicamento = ControleMedicamentos.cadastrarMedicamento(nomeMedicamento, nomeMarca);

    // Confirmação de inclusão
    Prompt.imprimir("Medicamento incluído com sucesso!");
    Prompt.imprimir("ID: " + medicamento.getId());
    Prompt.imprimir("Nome: " + medicamento.getNomeMedicamento());
    Prompt.imprimir("Marca: " + medicamento.getNomeMarca());

    Prompt.pressionarEnter();
}

private void mostrarDadosMedicamentos() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("DADOS DOS MEDICAMENTOS");
    Prompt.separador();

    List<String[]> medicamentos = ControleMedicamentos.buscarMedicamentos();

    if (medicamentos.isEmpty()) {
        Prompt.imprimir("Nenhum medicamento encontrado.");
    } else {
        for (String[] medicamento : medicamentos) {
            int id = Integer.parseInt(medicamento[0]);
            String nomeMedicamento = medicamento[1];
            String nomeMarca = medicamento[2];

            Prompt.imprimir("ID: " + id);
            Prompt.imprimir("Nome do Medicamento: " + nomeMedicamento);
            Prompt.imprimir("Nome da Marca: " + nomeMarca);
            Prompt.separador();
        }
    }

    Prompt.pressionarEnter();
}

//FORNECEDOR
private void mostrarMenuIncluirFornecedor() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("INCLUIR FORNECEDOR");
    Prompt.separador();

    String cnpj = Prompt.lerLinha("CNPJ: ");
    String nome = Prompt.lerLinha("Nome: ");
    String telefone = Prompt.lerLinha("Telefone: ");
    String endereco = Prompt.lerLinha("Endereço: ");
    String marca = Prompt.lerLinha("Marca: ");

    // Cadastra o novo fornecedor
    ControleFornecedor.cadastrarFornecedor(cnpj, nome, telefone, endereco, marca);

    // Confirmação de inclusão
    Prompt.imprimir("Fornecedor incluído com sucesso!");
    Prompt.imprimir("CNPJ: " + cnpj);
    Prompt.imprimir("Nome: " + nome);
    Prompt.imprimir("Telefone: " + telefone);
    Prompt.imprimir("Endereço: " + endereco);
    Prompt.imprimir("Marca: " + marca);

    Prompt.pressionarEnter();
}

private void mostrarDadosFornecedores() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("DADOS DOS FORNECEDORES");
    Prompt.separador();

    List<String[]> fornecedores = ControleFornecedor.buscarFornecedores();

    if (fornecedores.isEmpty()) {
        Prompt.imprimir("Nenhum fornecedor encontrado.");
    } else {
        for (String[] fornecedor : fornecedores) {
            String cnpj = fornecedor[0];
            String nome = fornecedor[1];
            String telefone = fornecedor[2];
            String endereco = fornecedor[3];
            String marca = fornecedor[4];

            Prompt.imprimir("CNPJ: " + cnpj);
            Prompt.imprimir("Nome: " + nome);
            Prompt.imprimir("Telefone: " + telefone);
            Prompt.imprimir("Endereço: " + endereco);
            Prompt.imprimir("Marca: " + marca);
            Prompt.separador();
        }
    }

    Prompt.pressionarEnter();
}
//PACIENTE
private void mostrarMenuIncluirPaciente() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("INCLUIR PACIENTE");
    Prompt.separador();

    String cpf = Prompt.lerLinha("CPF: ");
    String sus = Prompt.lerLinha("SUS: ");
    String nome = Prompt.lerLinha("Nome: ");
    String dtNascimento = Prompt.lerLinha("Data de Nascimento (AAAA-MM-DD): ");
    String telefone = Prompt.lerLinha("Telefone: ");

    // Cadastra o novo paciente
    ControlePaciente.cadastrarPaciente(cpf, sus, nome, dtNascimento, telefone);

    // Confirmação de inclusão
    Prompt.imprimir("Paciente incluído com sucesso!");
    Prompt.imprimir("CPF: " + cpf);
    Prompt.imprimir("SUS: " + sus);
    Prompt.imprimir("Nome: " + nome);
    Prompt.imprimir("Data de Nascimento: " + dtNascimento);
    Prompt.imprimir("Telefone: " + telefone);

    Prompt.pressionarEnter();
}
private void mostrarDadosPacientes() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("DADOS DOS PACIENTES");
    Prompt.separador();

    List<String[]> pacientes = ControlePaciente.buscarPacientes();

    if (pacientes.isEmpty()) {
        Prompt.imprimir("Nenhum paciente encontrado.");
    } else {
        for (String[] paciente : pacientes) {
            String cpf = paciente[0];
            String sus = paciente[1];
            String nome = paciente[2];
            String dtNascimento = paciente[3];
            String telefone = paciente[4];

            Prompt.imprimir("CPF: " + cpf);
            Prompt.imprimir("SUS: " + sus);
            Prompt.imprimir("Nome: " + nome);
            Prompt.imprimir("Data de Nascimento: " + dtNascimento);
            Prompt.imprimir("Telefone: " + telefone);
            Prompt.separador();
        }
    }

    Prompt.pressionarEnter();
}

//MEDICO
private void mostrarMenuIncluirMedico() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("INCLUIR MÉDICO");
    Prompt.separador();

    String cpf = Prompt.lerLinha("CPF: ");
    String crm = Prompt.lerLinha("CRM: ");
    String nome = Prompt.lerLinha("Nome: ");
    String especialidade = Prompt.lerLinha("Especialidade: ");

    // Cadastra o novo médico
    ControleMedico.cadastrarMedico(cpf, crm, nome, especialidade);

    // Confirmação de inclusão
    Prompt.imprimir("Médico incluído com sucesso!");
    Prompt.imprimir("CPF: " + cpf);
    Prompt.imprimir("CRM: " + crm);
    Prompt.imprimir("Nome: " + nome);
    Prompt.imprimir("Especialidade: " + especialidade);

    Prompt.pressionarEnter();
}

private void mostrarDadosMedicos() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("DADOS DOS MÉDICOS");
    Prompt.separador();

    List<String[]> medicos = ControleMedico.buscarMedicos();

    if (medicos.isEmpty()) {
        Prompt.imprimir("Nenhum médico encontrado.");
    } else {
        for (String[] medico : medicos) {
            String cpf = medico[0];
            String crm = medico[1];
            String nome = medico[2];
            String especialidade = medico[3];

            Prompt.imprimir("CPF: " + cpf);
            Prompt.imprimir("CRM: " + crm);
            Prompt.imprimir("Nome: " + nome);
            Prompt.imprimir("Especialidade: " + especialidade);
            Prompt.separador();
        }
    }

    Prompt.pressionarEnter();
}

//AGENDAMENTO
private void mostrarMenuIncluirAgendamento() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("INCLUIR AGENDAMENTO");
    Prompt.separador();

    String sus = Prompt.lerLinha("SUS: ");
    String nomePaciente = Prompt.lerLinha("Nome do Paciente: ");
    String crm = Prompt.lerLinha("CRM do Médico: ");
    String nomeMedico = Prompt.lerLinha("Nome do Médico: ");
    String data = Prompt.lerLinha("Data do Agendamento (AAAA-MM-DD): ");

    // Inicializa o último ID
    ControleAgendamento.inicializarUltimoId();

    // Cadastra o novo agendamento
    Agendamento agendamento = ControleAgendamento.cadastrarAgendamento(sus, nomePaciente, crm, nomeMedico, data);

    // Confirmação de inclusão
    Prompt.imprimir("Agendamento incluído com sucesso!");
    Prompt.imprimir("ID: " + agendamento.getId());
    Prompt.imprimir("SUS: " + sus);
    Prompt.imprimir("Nome do Paciente: " + nomePaciente);
    Prompt.imprimir("CRM do Médico: " + crm);
    Prompt.imprimir("Nome do Médico: " + nomeMedico);
    Prompt.imprimir("Data do Agendamento: " + data);

    Prompt.pressionarEnter();
}

private void mostrarDadosAgendamentos() {
    Prompt.limparConsole();
    Prompt.separador();
    Prompt.imprimir("DADOS DOS AGENDAMENTOS");
    Prompt.separador();

    List<String[]> agendamentos = ControleAgendamento.buscarAgendamentos();

    if (agendamentos.isEmpty()) {
        Prompt.imprimir("Nenhum agendamento encontrado.");
    } else {
        for (String[] agendamento : agendamentos) {
            int id = Integer.parseInt(agendamento[0]);
            String realizada = agendamento[1].isEmpty() ? "Não" : "Sim";
            String sus = agendamento[2];
            String nomePaciente = agendamento[3];
            String crm = agendamento[4];
            String nomeMedico = agendamento[5];
            String data = agendamento[6];

            Prompt.imprimir("ID: " + id);
            Prompt.imprimir("Realizada: " + realizada);
            Prompt.imprimir("SUS: " + sus);
            Prompt.imprimir("Nome do Paciente: " + nomePaciente);
            Prompt.imprimir("CRM do Médico: " + crm);
            Prompt.imprimir("Nome do Médico: " + nomeMedico);
            Prompt.imprimir("Data do Agendamento: " + data);
            Prompt.separador();
        }
    }

    Prompt.pressionarEnter();
}

}
