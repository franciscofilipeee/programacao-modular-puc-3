package org.example;

public class ContatoEmergencia extends Contato {

    private int grauPrioridade = 1;

    private String observacao;

    public int getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(int grauPrioridade) {
        if (grauPrioridade < 1 || grauPrioridade > 5) {
            System.out.println("A prioridade deve estar entre 1 e 5.");
            return;
        }
        this.grauPrioridade = grauPrioridade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public void mostrarContato() {
        System.out.println("Nome: " + this.getNome() + "\nEmail: " + this.getEmail() + "\nTelefone: " + this.getTelefone() + "\nGrau de Prioridade: " + this.getGrauPrioridade() + "\nObservação: " + this.getObservacao());
    }
}
