package br.edu.up;

import br.edu.up.controles.PacienteController;
import br.edu.up.modelos.Paciente;
import br.edu.up.telas.TelaPrincipal;

public class Programa {

    public static void main(String[] args) {

        TelaPrincipal tela = new TelaPrincipal();
        //tela.mostrarMenuPrincipal();
        PacienteController.IncluirPaciente(new Paciente("joao", "14411", "abcde","sdjasp", "56456", "sus"));
    }
}
