package org.example;

import java.util.Locale;

public abstract class Ingresso {

    private int codigo;

    private String nomeEvento;

    private String setor;

    private double valorBase;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        if (!Double.isFinite(valorBase) || valorBase < 0) {
            System.out.println("O valor base deve ser finito e não negativo.");
            return;
        }
        this.valorBase = valorBase;
    }

    public void mostrarIngresso() {
        System.out.println("Tipo: " + getClass().getSimpleName());
        System.out.println("Código: " + codigo + "\nEvento: " + nomeEvento + "\nSetor: " + setor);
        System.out.printf(Locale.forLanguageTag("pt-BR"),
                "Valor base: R$ %.2f%nValor final: R$ %.2f%n", valorBase, calcularValorFinal());
        System.out.println("Benefícios: " + obterBeneficios());
    }

    public abstract double calcularValorFinal();

    public abstract String obterBeneficios();
}
