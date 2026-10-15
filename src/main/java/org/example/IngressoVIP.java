package org.example;

public class IngressoVIP extends Ingresso {

    private boolean acessoBackstage;

    private int numeroLounge;

    public boolean isAcessoBackstage() {
        return acessoBackstage;
    }

    public void setAcessoBackstage(boolean acessoBackstage) {
        this.acessoBackstage = acessoBackstage;
    }

    public int getNumeroLounge() {
        return numeroLounge;
    }

    public void setNumeroLounge(int numeroLounge) {
        this.numeroLounge = numeroLounge;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.8;
    }

    @Override
    public String obterBeneficios() {
        return "Acesso ao lounge " + numeroLounge
                + (acessoBackstage ? " e acesso ao backstage." : ".");
    }

    @Override
    public void mostrarIngresso() {
        super.mostrarIngresso();
        System.out.println("Número do lounge: " + numeroLounge);
        System.out.println("Acesso ao backstage: " + (acessoBackstage ? "Sim" : "Não"));
    }
}
