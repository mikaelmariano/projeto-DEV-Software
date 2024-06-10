package br.edu.up.modelos;

public class Medicamentos {
    private int id;
    private String nomeMedicamento;
    private String nomeMarca;

    // Construtor
    public Medicamentos(int id, String nomeMedicamento, String nomeMarca) {
        this.id = id;
        this.nomeMedicamento = nomeMedicamento;
        this.nomeMarca = nomeMarca;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}
