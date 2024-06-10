package br.edu.up.controles;

import java.util.ArrayList;

import br.edu.up.daos.PacienteDao;
import br.edu.up.modelos.Paciente;

public class PacienteController {
    
    private ArrayList<Paciente> Pacientes = new ArrayList();

    public static void IncluirPaciente(Paciente paciente){

        PacienteDao.IncluirPacienteArquivo(paciente);

    }

}
