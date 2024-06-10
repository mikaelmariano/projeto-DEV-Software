package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ControlePaciente {

    public static final String CAMINHO_PACIENTES = "Pacientes.txt";

    private static GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();

    public static void inicializarArquivoPacientes() {
        List<String[]> pacientes = gerenciadorDeArquivos.lerArquivo(CAMINHO_PACIENTES);
        if (pacientes.isEmpty()) {
            // Adiciona o cabeçalho ao arquivo
            String[] header = {"cpf", "sus", "nome", "dtNascimento", "telefone"};
            gerenciadorDeArquivos.adicionarLinha(CAMINHO_PACIENTES, header);
        }
    }

    public static void cadastrarPaciente(String cpf, String sus, String nome, String dtNascimento, String telefone) {
        Paciente paciente = new Paciente(cpf, sus, nome, dtNascimento, telefone);
        gravarPaciente(paciente);
    }

    public static void gravarPaciente(Paciente paciente) {
        List<String[]> novoPaciente = new ArrayList<>();
        novoPaciente.add(new String[]{
            paciente.getCpf(),
            paciente.getSus(),
            paciente.getNome(),
            paciente.getDtNascimento(),
            paciente.getTelefone()
        });
        gerenciadorDeArquivos.adicionarLinha(CAMINHO_PACIENTES, novoPaciente.get(0));
    }

    public static List<String[]> buscarPacientes() {
        List<String[]> pacientes = gerenciadorDeArquivos.lerArquivo(CAMINHO_PACIENTES);
        List<String[]> pacientesSemCabecalho = new ArrayList<>();
        for (int i = 1; i < pacientes.size(); i++) {
            pacientesSemCabecalho.add(pacientes.get(i));
        }
        return pacientesSemCabecalho;
    }

    
}
