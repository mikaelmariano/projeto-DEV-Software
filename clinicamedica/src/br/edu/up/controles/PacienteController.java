package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;


import br.edu.up.modelos.Paciente;

public class PacienteController {

    private static List<Paciente> pacientes = new ArrayList<>();

    public static Boolean incluir(Paciente paciente){

        pacientes.add(paciente);

        return true;

    } 

    private static Boolean IncluirPacienteArquivo(Paciente paciente){

        String DirectoryBase = System.getProperty("user.dir");

        return false;

    }

}
