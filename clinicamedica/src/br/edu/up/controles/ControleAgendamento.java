package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Agendamento;

import java.util.ArrayList;
import java.util.List;

public class ControleAgendamento {

    public static final String CAMINHO_AGENDAMENTOS = "Agendamentos.txt";

    private static int ultimoId = 0;
    private static GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();

    public static void inicializarArquivoAgendamentos() {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        if (agendamentos.isEmpty()) {
            // Adiciona o cabeçalho ao arquivo
            String[] header = { "id", "realizada", "sus", "paciente", "crm", "medico", "data" };
            gerenciadorDeArquivos.adicionarLinha(CAMINHO_AGENDAMENTOS, header);
        }
    }

    public static void inicializarUltimoId() {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        if (agendamentos.size() > 1) { // Verifica se há mais de uma linha (cabeçalho + dados)
            String[] ultimoAgendamento = agendamentos.get(agendamentos.size() - 1);
            try {
                ultimoId = Integer.parseInt(ultimoAgendamento[0]);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao parsear o último ID: " + e.getMessage());
            }
        }
    }

    public static Agendamento cadastrarAgendamento(String sus, String nomePaciente, String crm, String nomeMedico,
            String data) {
        ultimoId++;
        Agendamento agendamento = new Agendamento(ultimoId, sus, nomePaciente, crm, nomeMedico, data);
        gravarAgendamento(agendamento);
        return agendamento;
    }

    public static void gravarAgendamento(Agendamento agendamento) {
        List<String[]> agendamentos = new ArrayList<>();
        agendamentos.add(new String[] {
                String.valueOf(agendamento.getId()),
                agendamento.getRealizada(),
                agendamento.getSus(),
                agendamento.getNomePaciente(),
                agendamento.getCrm(),
                agendamento.getNomeMedico(),
                agendamento.getData()
        });
        gerenciadorDeArquivos.adicionarLinha(CAMINHO_AGENDAMENTOS, agendamentos.get(0));
    }

    public static List<String[]> buscarAgendamentos() {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        List<String[]> agendamentosSemCabecalho = new ArrayList<>();
        for (int i = 1; i < agendamentos.size(); i++) {
            agendamentosSemCabecalho.add(agendamentos.get(i));
        }
        return agendamentosSemCabecalho;
    }

    public static Agendamento buscarAgendamentoPorId(int id) {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        for (int i = 1; i < agendamentos.size(); i++) { // Pula o cabeçalho
            String[] agendamento = agendamentos.get(i);
            if (Integer.parseInt(agendamento[0]) == id) {
                return new Agendamento(
                        Integer.parseInt(agendamento[0]),
                        agendamento[2],
                        agendamento[3],
                        agendamento[4],
                        agendamento[5],
                        agendamento[6]);
            }
        }
        return null;
    }

    public static void atualizarAgendamento(Agendamento agendamento) {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        for (int i = 1; i < agendamentos.size(); i++) { // Pula o cabeçalho
            String[] dadosAgendamento = agendamentos.get(i);
            if (Integer.parseInt(dadosAgendamento[0]) == agendamento.getId()) {
                agendamentos.set(i, new String[] {
                        String.valueOf(agendamento.getId()),
                        agendamento.getRealizada(),
                        agendamento.getSus(),
                        agendamento.getNomePaciente(),
                        agendamento.getCrm(),
                        agendamento.getNomeMedico(),
                        agendamento.getData()
                });
                break;
            }
        }
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_AGENDAMENTOS, agendamentos);
    }

    public static void removerAgendamento(int id) {
        List<String[]> agendamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_AGENDAMENTOS);
        for (int i = 1; i < agendamentos.size(); i++) { // Pula o cabeçalho
            String[] dadosAgendamento = agendamentos.get(i);
            if (Integer.parseInt(dadosAgendamento[0]) == id) {
                agendamentos.remove(i);
                break;
            }
        }
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_AGENDAMENTOS, agendamentos);
    }
}
