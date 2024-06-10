package br.edu.up;

import br.edu.up.controles.ControlePaciente;
import br.edu.up.telas.TelaPrincipal;

public class Programa {
    public static void main(String[] args) {
        // Inicializa os arquivos de Dados.
        ControlePaciente.inicializarArquivoPacientes();
    
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.mostrarMenuPrincipal();
    }
}