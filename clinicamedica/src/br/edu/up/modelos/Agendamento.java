package br.edu.up.modelos;

import java.time.LocalDateTime;

public class Agendamento {
    private String paciente;
    private String medico;
    private LocalDateTime dataHora;

    public Agendamento(String paciente, String medico, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Agendamento [paciente=" + paciente + ", medico=" + medico + ", dataHora=" + dataHora + "]";
    }
}