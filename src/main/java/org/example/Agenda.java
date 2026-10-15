package org.example;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos = new ArrayList<>();
    private int quantidadeContatos;

    public List<Contato> getContatos() {
        return List.copyOf(contatos);
    }

    public void setContatos(List<Contato> contatos) {
        if (contatos == null) {
            System.out.println("Informe uma lista sem contatos nulos.");
            return;
        }
        for (Contato contato : contatos) {
            if (contato == null) {
                System.out.println("Informe uma lista sem contatos nulos.");
                return;
            }
        }
        this.contatos = new ArrayList<>(contatos);
        quantidadeContatos = this.contatos.size();
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }

    // A quantidade precisa corresponder à lista para preservar a consistência.
    public void setQuantidadeContatos(int quantidadeContatos) {
        if (quantidadeContatos != contatos.size()) {
            System.out.println("A quantidade deve corresponder à lista de contatos.");
            return;
        }
        this.quantidadeContatos = quantidadeContatos;
    }

    public void adicionarContato(Contato contato) {
        if (contato == null) {
            System.out.println("Informe um contato.");
            return;
        }
        contatos.add(contato);
        quantidadeContatos = contatos.size();
    }

    public boolean removerContato(Contato contato) {
        boolean removido = contatos.remove(contato);
        quantidadeContatos = contatos.size();
        return removido;
    }

    public boolean removerContato(String nome) {
        return removerContato(buscarContatoPorNome(nome));
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato contato : contatos) {
            if (igual(contato.getNome(), nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorEmail(String email) {
        for (Contato contato : contatos) {
            if (igual(contato.getEmail(), email)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (igual(contato.getTelefone(), telefone)) {
                return contato;
            }
        }
        return null;
    }

    private boolean igual(String cadastrado, String busca) {
        return cadastrado != null && busca != null
                && cadastrado.trim().equalsIgnoreCase(busca.trim());
    }
}
