package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Medicamentos;

import java.util.ArrayList;
import java.util.List;

public class ControleMedicamentos {

    public static final String CAMINHO_MEDICAMENTOS = "Medicamentos.txt";

    private static int ultimoId = 0;
    private static GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();

    public static void inicializarArquivoMedicamentos() {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        if (medicamentos.isEmpty()) {
            // Adiciona o cabeçalho ao arquivo
            String[] header = { "ID", "Nome_Medicamento", "Marca" };
            gerenciadorDeArquivos.adicionarLinha(CAMINHO_MEDICAMENTOS, header);
        }
    }

    public static void inicializarUltimoId() {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        if (medicamentos.size() > 1) { // Verifica se há mais de uma linha (cabeçalho + dados)
            String[] ultimoMedicamento = medicamentos.get(medicamentos.size() - 1);
            try {
                ultimoId = Integer.parseInt(ultimoMedicamento[0]);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao parsear o último ID: " + e.getMessage());
            }
        }
    }

    public static Medicamentos cadastrarMedicamento(String nomeMedicamento, String nomeMarca) {
        ultimoId++;
        Medicamentos medicamento = new Medicamentos(ultimoId, nomeMedicamento, nomeMarca);
        gravarMedicamento(medicamento);
        return medicamento;
    }

    public static void gravarMedicamento(Medicamentos medicamento) {
        List<String[]> medicamentos = new ArrayList<>();
        medicamentos.add(new String[] {
                String.valueOf(medicamento.getId()),
                medicamento.getNomeMedicamento(),
                medicamento.getNomeMarca()
        });
        gerenciadorDeArquivos.adicionarLinha(CAMINHO_MEDICAMENTOS, medicamentos.get(0));
    }

    public static List<String[]> buscarMedicamentos() {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        List<String[]> medicamentosSemCabecalho = new ArrayList<>();
        for (int i = 1; i < medicamentos.size(); i++) {
            medicamentosSemCabecalho.add(medicamentos.get(i));
        }
        return medicamentosSemCabecalho;
    }

    public static Medicamentos buscarMedicamentoPorId(int id) {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        for (int i = 1; i < medicamentos.size(); i++) { // Pula o cabeçalho
            String[] medicamento = medicamentos.get(i);
            if (Integer.parseInt(medicamento[0]) == id) {
                return new Medicamentos(
                        Integer.parseInt(medicamento[0]),
                        medicamento[1],
                        medicamento[2]);
            }
        }
        return null;
    }

    public static Medicamentos buscarMedicamentoPorNome(String nomeMedicamento) {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        for (int i = 1; i < medicamentos.size(); i++) { // Pula o cabeçalho
            String[] medicamento = medicamentos.get(i);
            if (medicamento[1].equalsIgnoreCase(nomeMedicamento)) {
                return new Medicamentos(
                        Integer.parseInt(medicamento[0]),
                        medicamento[1],
                        medicamento[2]);
            }
        }
        return null;
    }

    public static void atualizarMedicamento(Medicamentos medicamento) {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        for (int i = 1; i < medicamentos.size(); i++) { // Pula o cabeçalho
            String[] dadosMedicamento = medicamentos.get(i);
            if (Integer.parseInt(dadosMedicamento[0]) == medicamento.getId()) {
                medicamentos.set(i, new String[] {
                        String.valueOf(medicamento.getId()),
                        medicamento.getNomeMedicamento(),
                        medicamento.getNomeMarca()
                });
                break;
            }
        }
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_MEDICAMENTOS, medicamentos);
    }

    public static void removerMedicamento(int id) {
        List<String[]> medicamentos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICAMENTOS);
        for (int i = 1; i < medicamentos.size(); i++) { // Pula o cabeçalho
            String[] dadosMedicamento = medicamentos.get(i);
            if (Integer.parseInt(dadosMedicamento[0]) == id) {
                medicamentos.remove(i);
                break;
            }
        }
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_MEDICAMENTOS, medicamentos);
    }
}
