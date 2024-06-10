package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Consulta;

import java.util.ArrayList;

import java.util.List;

public class ControleConsulta {

    public static final String CAMINHO_AGENDAMENTOS = "Agendamentos.txt";
    public static final String CAMINHO_CONSULTAS = "Consultas.txt";
    public static final String CAMINHO_MEDICAMENTOS = "Medicamentos.txt";
    public static final String CAMINHO_CONSULTAS_X_MEDICAMENTOS = "ConsultasXMedicamentos.txt";

    private static int ultimoId = 0;
    private static GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();

    public static void inicializarArquivoConsultas() {
        List<String[]> consultas = gerenciadorDeArquivos.lerArquivo(CAMINHO_CONSULTAS);
        if (consultas.isEmpty()) {
            // Adiciona o cabeçalho ao arquivo
            String[] header = {"id",  "nomePaciente",  "nomeMedico",  "dataAgendamento",  "sintomas"};
            gerenciadorDeArquivos.adicionarLinha(CAMINHO_CONSULTAS, header);
        }
    }

    public static void inicializarUltimoId() {
        List<String[]> consultas = gerenciadorDeArquivos.lerArquivo(CAMINHO_CONSULTAS);
        if (consultas.size() > 1) {  // Verifica se há mais de uma linha (cabeçalho + dados)
            String[] ultimaConsulta = consultas.get(consultas.size() - 1);
            try {
                ultimoId = Integer.parseInt(ultimaConsulta[0]);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao parsear o último ID: " + e.getMessage());
            }
        }
    }

    public static String[] buscarAgendamentoPorId(int id) {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        for (int i = 1; i < agendamentos.size(); i++) {  // Pula o cabeçalho
            String[] agendamento = agendamentos.get(i);
            if (Integer.parseInt(agendamento[0]) == id) {
                return agendamento;
            }
        }
        return null;
    }

    public static String[] buscarAgendamentoPorSusCrmEData(String sus, String crm, String data) {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        for (int i = 1; i < agendamentos.size(); i++) {  // Pula o cabeçalho
            String[] agendamento = agendamentos.get(i);
            if (agendamento[2].equals(sus) && agendamento[4].equals(crm) && agendamento[6].equals(data)) {
                return agendamento;
            }
        }
        return null;
    }

    public static Consulta realizarConsulta(String nomePaciente, String nomeMedico, String dataAgendamento, String sintomas) {
        ultimoId++;
        return new Consulta(ultimoId, nomePaciente, nomeMedico, dataAgendamento, sintomas);
    }

    public static void gravarConsulta(Consulta consulta, String idAgendamento) {
        //List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
    
        // Marcar a consulta como realizada no agendamento
        marcarConsultaRealizada(idAgendamento);
    
        // Grava a consulta no arquivo de consultas
        List<String[]> consultas = new ArrayList<>();
        consultas.add(new String[]{
            String.valueOf(consulta.getId()),
            consulta.getNomePaciente(),
            consulta.getNomeMedico(),
            consulta.getDataAgendamento(),
            consulta.getSintomas()
        });
        gerenciadorDeArquivos.adicionarLinha(CAMINHO_CONSULTAS, consultas.get(0));
    }
    
    public static void marcarConsultaRealizada(String idAgendamento) {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
    
        for (int i = 1; i < agendamentos.size(); i++) {  // Pula o cabeçalho
            String[] agendamento = agendamentos.get(i);
            if (agendamento[0].equals(idAgendamento)) {
                agendamento[1] = "X";
                agendamentos.set(i, agendamento); // Atualiza a linha correspondente
                break; // Encontrou e marcou, pode sair do loop
            }
        }
    
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_AGENDAMENTOS, agendamentos);
    }    

    public static List<String[]> buscarMedicamentos() {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        List<String[]> medicamentosSemCabecalho = new ArrayList<>();
        for (int i = 1; i < medicamentos.size(); i++) {
            medicamentosSemCabecalho.add(medicamentos.get(i));
        }
        return medicamentosSemCabecalho;
    }

    public static void gravarConsultaXMedicamentos(int consultaId, List<String> medicamentos) {
        List<String[]> consultasXMedicamentos = new ArrayList<>();
        for (String medicamento : medicamentos) {
            consultasXMedicamentos.add(new String[]{String.valueOf(consultaId), medicamento});
        }
        gerenciadorDeArquivos.escreverArquivo(CAMINHO_CONSULTAS_X_MEDICAMENTOS, consultasXMedicamentos, true);
    }
}
