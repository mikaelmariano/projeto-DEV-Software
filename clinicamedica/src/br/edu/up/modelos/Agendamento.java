package br.edu.up.modelos;

public class Agendamento {
    private int id;
    private String realizada;
    private String sus;
    private String nomePaciente;
    private String crm;
    private String nomeMedico;
    private String data;

    // Construtor
    public Agendamento(int id, String sus, String nomePaciente, String crm, String nomeMedico, String data) {
        this.id = id;
        this.realizada = ""; // Campo vazio no momento do cadastro do agendamento
        this.sus = sus;
        this.nomePaciente = nomePaciente;
        this.crm = crm;
        this.nomeMedico = nomeMedico;
        this.data = data;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealizada() {
        return realizada;
    }

    public void setRealizada(String realizada) {
        this.realizada = realizada;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
