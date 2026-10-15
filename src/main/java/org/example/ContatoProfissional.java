package org.example;

public class ContatoProfissional extends Contato {

    private String empresa;

    private String cargo;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void mostrarContato() {
        System.out.println("Nome: " + this.getNome() + "\nEmail: " + this.getEmail() + "\nTelefone: " + this.getTelefone() + "\nEmpresa: " + this.getEmpresa() + "\nCargo: " + this.getCargo());
    }
}
