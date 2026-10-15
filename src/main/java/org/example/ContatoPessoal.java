package org.example;

public class ContatoPessoal extends Contato {

    private String dataAniversario;

    private String parentesco;

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public void mostrarContato() {
        System.out.println("Nome: " + this.getNome() + "\nEmail: " + this.getEmail() + "\nTelefone: " + this.getTelefone() + "\nData do aniversário: " + this.getDataAniversario() + "\nParentesco: " + this.getParentesco());
    }
}
