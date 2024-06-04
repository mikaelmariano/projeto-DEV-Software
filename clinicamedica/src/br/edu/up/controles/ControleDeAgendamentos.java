package br.edu.up.controles;

import br.edu.up.modelos.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class ControleDeAgendamentos {
    private List<Agendamento> agendamentos;

    public ControleDeAgendamentos() {
        this.agendamentos = new ArrayList<>();
    }

    public void incluirAgendamento(Agendamento agendamento) {
        this.agendamentos.add(agendamento);
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void gravarDados() {
        // gravar no arquivo
    }
}