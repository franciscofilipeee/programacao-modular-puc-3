package org.example;

public class IngressoComum extends Ingresso {

    @Override
    public double calcularValorFinal() {
        return getValorBase();
    }

    @Override
    public String obterBeneficios() {
        return "Nenhum benefício adicional.";
    }
}
