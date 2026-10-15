package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bilheteria {

    private List<Ingresso> ingressos = new ArrayList<>();
    public List<Ingresso> getIngressos() {
        return List.copyOf(ingressos);
    }

    public void setIngressos(List<Ingresso> ingressos) {
        if (ingressos == null) {
            System.out.println("Informe uma lista sem ingressos nulos.");
            return;
        }
        for (Ingresso ingresso : ingressos) {
            if (ingresso == null) {
                System.out.println("Informe uma lista sem ingressos nulos.");
                return;
            }
        }
        List<Ingresso> copia = new ArrayList<>(ingressos);
        Set<Integer> codigos = new HashSet<>();
        for (Ingresso ingresso : copia) {
            if (!codigos.add(ingresso.getCodigo())) {
                System.out.println("Já existe ingresso com esse código.");
                return;
            }
        }
        this.ingressos = copia;
    }

    public void adicionarIngresso(Ingresso ingresso) {
        if (ingresso == null) {
            System.out.println("Informe um ingresso.");
            return;
        }
        if (buscarIngresso(ingresso.getCodigo()) != null) {
            System.out.println("Já existe ingresso com esse código.");
            return;
        }
        ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        return ingressos.remove(buscarIngresso(codigo));
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getCodigo() == codigo) {
                return ingresso;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
        }
        for (Ingresso ingresso : ingressos) {
            ingresso.mostrarIngresso();
            System.out.println();
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso ingresso : ingressos) total += ingresso.calcularValorFinal();
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
        }
        for (Ingresso ingresso : ingressos) {
            System.out.println("Ingresso " + ingresso.getCodigo() + ": " + ingresso.obterBeneficios());
        }
    }
}
