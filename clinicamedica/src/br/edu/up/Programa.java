package br.edu.up;

import br.edu.up.controles.ControleAgendamento;
import br.edu.up.controles.ControleConsulta;
import br.edu.up.controles.ControleFornecedor;
import br.edu.up.controles.ControleMedicamentos;
import br.edu.up.controles.ControleMedico;
import br.edu.up.controles.ControlePaciente;
import br.edu.up.telas.TelaPrincipal;

public class Programa {
    public static void main(String[] args) {
        // Inicializa os arquivos de Dados.
        ControlePaciente.inicializarArquivoPacientes();
	    ControleMedico.inicializarArquivoMedicos();
	    ControleAgendamento.inicializarArquivoAgendamentos();
        ControleFornecedor.inicializarArquivoFornecedores();
        ControleMedicamentos.inicializarArquivoMedicamentos();
        ControleConsulta.inicializarArquivoConsultas();

        TelaPrincipal tela = new TelaPrincipal();
        tela.mostrarMenuPrincipal();
    }
}