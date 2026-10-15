package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Scanner ENTRADA = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Bilheteria bilheteria = new Bilheteria();
        while (true) {
            System.out.println("\nPRÁTICA 3\n1 - Agenda telefônica\n2 - Bilheteria\n0 - Finalizar");
            switch (lerInteiro("Opção: ", 0, 2)) {
                case 1 -> menuAgenda(agenda);
                case 2 -> menuBilheteria(bilheteria);
                case 0 -> {
                    System.out.println("Programa finalizado.");
                    return;
                }
            }
        }
    }

    private static void menuAgenda(Agenda agenda) {
        while (true) {
            System.out.println("\nAGENDA\n1 - Adicionar contato\n2 - Remover contato"
                    + "\n3 - Buscar por nome\n4 - Buscar por email\n5 - Buscar por telefone"
                    + "\n6 - Consultar tamanho da agenda\n7 - Finalizar agenda (voltar)");
            switch (lerInteiro("Opção: ")) {
                case 1 -> cadastrarContato(agenda);
                case 2 -> System.out.println(agenda.removerContato(lerTexto("Nome: "))
                        ? "Contato removido com sucesso." : "Contato não encontrado.");
                case 3 -> mostrarContato(agenda.buscarContatoPorNome(lerTexto("Nome: ")));
                case 4 -> mostrarContato(agenda.buscarContatoPorEmail(lerTexto("Email: ")));
                case 5 -> mostrarContato(agenda.buscarContatoPorTelefone(lerTexto("Telefone: ")));
                case 6 -> System.out.println("Contatos cadastrados: " + agenda.getQuantidadeContatos());
                case 7 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarContato(Agenda agenda) {
        int tipo = lerInteiro("Tipo (1 - Pessoal, 2 - Profissional, 3 - Emergência): ", 1, 3);
        Contato contato = switch (tipo) {
            case 1 -> new ContatoPessoal();
            case 2 -> new ContatoProfissional();
            default -> new ContatoEmergencia();
        };
        contato.setNome(lerTexto("Nome: "));
        contato.setEmail(lerTexto("Email: "));
        contato.setTelefone(lerTexto("Telefone: "));
        if (contato instanceof ContatoPessoal pessoal) {
            pessoal.setDataAniversario(lerTexto("Data de aniversário: "));
            pessoal.setParentesco(lerTexto("Parentesco: "));
        } else if (contato instanceof ContatoProfissional profissional) {
            profissional.setEmpresa(lerTexto("Empresa: "));
            profissional.setCargo(lerTexto("Cargo: "));
        } else if (contato instanceof ContatoEmergencia emergencia) {
            emergencia.setGrauPrioridade(lerInteiro("Prioridade (1 a 5): ", 1, 5));
            emergencia.setObservacao(lerTexto("Observação: "));
        }
        agenda.adicionarContato(contato);
        System.out.println("Contato adicionado com sucesso.");
    }

    private static void mostrarContato(Contato contato) {
        if (contato == null) {
            System.out.println("Contato não encontrado.");
        } else {
            contato.mostrarContato();
        }
    }

    private static void menuBilheteria(Bilheteria bilheteria) {
        while (true) {
            System.out.println("\nBILHETERIA\n1 - Cadastrar ingresso\n2 - Remover ingresso"
                    + "\n3 - Buscar por código\n4 - Listar todos os ingressos"
                    + "\n5 - Calcular arrecadação total\n6 - Listar benefícios"
                    + "\n7 - Finalizar bilheteria (voltar)");
            switch (lerInteiro("Opção: ")) {
                case 1 -> cadastrarIngresso(bilheteria);
                case 2 -> System.out.println(bilheteria.removerIngresso(lerInteiro("Código: "))
                        ? "Ingresso removido com sucesso." : "Ingresso não encontrado.");
                case 3 -> {
                    Ingresso ingresso = bilheteria.buscarIngresso(lerInteiro("Código: "));
                    if (ingresso == null) {
                        System.out.println("Ingresso não encontrado.");
                    } else {
                        ingresso.mostrarIngresso();
                    }
                }
                case 4 -> bilheteria.listarIngressos();
                case 5 -> System.out.printf(Locale.forLanguageTag("pt-BR"),
                        "Arrecadação total: R$ %.2f%n", bilheteria.calcularArrecadacaoTotal());
                case 6 -> bilheteria.listarBeneficios();
                case 7 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarIngresso(Bilheteria bilheteria) {
        int tipo = lerInteiro("Tipo (1 - Comum, 2 - Estudante, 3 - VIP): ", 1, 3);
        int codigo = lerInteiro("Código: ");
        if (bilheteria.buscarIngresso(codigo) != null) {
            System.out.println("Já existe ingresso com esse código.");
            return;
        }
        Ingresso ingresso = switch (tipo) {
            case 1 -> new IngressoComum();
            case 2 -> new IngressoEstudante();
            default -> new IngressoVIP();
        };
        ingresso.setCodigo(codigo);
        ingresso.setNomeEvento(lerTexto("Nome do evento: "));
        ingresso.setSetor(lerTexto("Setor: "));
        ingresso.setValorBase(lerValor());
        if (ingresso instanceof IngressoEstudante estudante) {
            estudante.setInstituicaoEnsino(lerTexto("Instituição de ensino: "));
        } else if (ingresso instanceof IngressoVIP vip) {
            vip.setAcessoBackstage(lerSimNao("Acesso ao backstage (s/n): "));
            vip.setNumeroLounge(lerInteiro("Número do lounge: ", 1, Integer.MAX_VALUE));
        }
        bilheteria.adicionarIngresso(ingresso);
        System.out.println("Ingresso cadastrado com sucesso.");
    }

    private static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = ENTRADA.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Preencha o campo.");
        }
    }

    private static int lerInteiro(String mensagem) {
        return lerInteiro(mensagem, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int lerInteiro(String mensagem, int minimo, int maximo) {
        while (true) {
            Scanner numero = new Scanner(lerTexto(mensagem));
            if (numero.hasNextInt()) {
                int valor = numero.nextInt();
                if (!numero.hasNext() && valor >= minimo && valor <= maximo) {
                    return valor;
                }
            }
            System.out.println("Informe um número inteiro entre " + minimo + " e " + maximo + ".");
        }
    }

    private static double lerValor() {
        while (true) {
            Scanner numero = new Scanner(lerTexto("Valor base: ").replace(',', '.'));
            numero.useLocale(Locale.ROOT);
            if (numero.hasNextDouble()) {
                double valor = numero.nextDouble();
                if (!numero.hasNext() && Double.isFinite(valor) && valor >= 0) {
                    return valor;
                }
            }
            System.out.println("Informe um valor numérico não negativo.");
        }
    }

    private static boolean lerSimNao(String mensagem) {
        while (true) {
            String resposta = lerTexto(mensagem);
            if (resposta.equalsIgnoreCase("s")) {
                return true;
            }
            if (resposta.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Responda s ou n.");
        }
    }
}
