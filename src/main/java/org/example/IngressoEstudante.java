package org.example;

public class IngressoEstudante extends Ingresso {

    private String instituicaoEnsino;

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 0.5;
    }

    @Override
    public String obterBeneficios() {
        return "Direito à meia-entrada.";
    }

    @Override
    public void mostrarIngresso() {
        super.mostrarIngresso();
        System.out.println("Instituição de ensino: " + instituicaoEnsino);
    }
}
