package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Medico;

import java.util.ArrayList;
import java.util.List;

public class ControleMedico {

    public static final String CAMINHO_MEDICOS = "Medicos.txt";

    private static GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();


    public static void inicializarArquivoMedicos() {
        List<String[]> medicos= gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICOS);
        if (medicos.isEmpty()) {
            // Adiciona o cabeçalho ao arquivo
            String[] header = { "cpf",  "crm",  "nome",  "especialidade"};
            gerenciadorDeArquivos.adicionarLinha(CAMINHO_MEDICOS, header);
        }
    }

    public static void cadastrarMedico(String cpf, String crm, String nome, String especialidade) {
        Medico medico = new Medico(cpf, crm, nome, especialidade);
        gravarMedico(medico);
    }

    public static void gravarMedico(Medico medico) {
        List<String[]> medicos = new ArrayList<>();
        medicos.add(new String[]{
            medico.getCpf(),
            medico.getCrm(),
            medico.getNome(),
            medico.getEspecialidade()
        });
        gerenciadorDeArquivos.adicionarLinha(CAMINHO_MEDICOS, medicos.get(0));
    }

    public static List<String[]> buscarMedicos() {
        List<String[]> medicos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICOS);
        List<String[]> medicosSemCabecalho = new ArrayList<>();
        for (int i = 1; i < medicos.size(); i++) {
            medicosSemCabecalho.add(medicos.get(i));
        }
        return medicosSemCabecalho;
    }

    public static Medico buscarMedicoPorCpf(String cpf) {
        List<String[]> medicos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICOS);
        for (int i = 1; i < medicos.size(); i++) {  // Pula o cabeçalho
            String[] medico = medicos.get(i);
            if (medico[0].equals(cpf)) {
                return new Medico(
                    medico[0],
                    medico[1],
                    medico[2],
                    medico[3]
                );
            }
        }
        return null;
    }

    public static void atualizarMedico(Medico medico) {
        List<String[]> medicos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICOS);
        for (int i = 1; i < medicos.size(); i++) {  // Pula o cabeçalho
            String[] dadosMedico = medicos.get(i);
            if (dadosMedico[0].equals(medico.getCpf())) {
                medicos.set(i, new String[]{
                    medico.getCpf(),
                    medico.getCrm(),
                    medico.getNome(),
                    medico.getEspecialidade()
                });
                break;
            }
        }
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_MEDICOS, medicos);
    }

    public static void removerMedico(String cpf) {
        List<String[]> medicos = gerenciadorDeArquivos.lerArquivo(CAMINHO_MEDICOS);
        for (int i = 1; i < medicos.size(); i++) {  // Pula o cabeçalho
            String[] dadosMedico = medicos.get(i);
            if (dadosMedico[0].equals(cpf)) {
                medicos.remove(i);
                break;
            }
        }
        gerenciadorDeArquivos.atualizarArquivo(CAMINHO_MEDICOS, medicos);
    }
}
