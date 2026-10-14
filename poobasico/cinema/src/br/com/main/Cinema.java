package br.com.bilheteria.main;
import br.com.bilheteria.entidades.*;
import java.time.LocalTime;
import java.util.Scanner;

public class Cinema {
    public static void menuPrincipal() {
        System.out.println("\nCINEMA");
        System.out.println("1 - Gerenciar filmes");
        System.out.println("2 - Gerenciar sessões e vender ingressos");
        System.out.println("3 - Consultar e atualizar informações do cinema");
        System.out.println("0 - Sair");
        System.out.print("Selecione o código de uma das opções: ");
    }

    public static void menuFilmes() {
        System.out.println("\nFILMES");
        System.out.println("1 - Consultar os dados do filme");
        System.out.println("2 - Alterar a categoria");
        System.out.println("3 - Alterar a sinopse");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Selecione o código de uma das opções: ");
    }

    public static void menuSessaoIngresso() {
        System.out.println("\nSESSÕES E INGRESSOS");
        System.out.println("1 - Consultar os detalhes da sessão");
        System.out.println("2 - Vender ingresso");
        System.out.println("3 - Consultar os lugares disponíveis");
        System.out.println("4 - Consultar o horário de término");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Selecione o código de uma das opções: ");
    }

    public static void menuCinema() {
        System.out.println("\nGERENCIAR CINEMA");
        System.out.println("1 - Consultar o preço integral do ingresso");
        System.out.println("2 - Alterar o preço integral do ingresso");
        System.out.println("3 - Consultar os totais de ingressos vendidos e de arrecadação");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Selecione o código de uma das opções: ");
    }

    public static void main(String[] args) {
        char opcaoMenu,
                opcaoFilme,
                opcaoSessaoIngre = ' ',
                opcaoCinema = ' ',
                filmeOperacao = ' ',
                sessaoConfig;
        float ingressoVendido = 0;

        Scanner scan = new Scanner(System.in);
        Filme refFilme = null;
        Filme mulan = new Filme("Mulan", (short) 78, "Aventura", (byte) 0);
        Filme narnia = new Filme("As Crônicas de Nárnia: O Leão, A Feiticeira e o Guarda-Roupa", (short) 149);
        Filme iluminado = new Filme("O Iluminado", (short) 94, "Terror", (byte) 18);

        Sessao refSessao = null;
        Sessao cineSala01 = new Sessao("xef001", mulan, LocalTime.of(14,0), (short) 120);
        Sessao cineSala02 = new Sessao("iot56", mulan, LocalTime.of(15,30), (short) 150);
        Sessao cineSala03 = new Sessao("879wiop", mulan, LocalTime.of(17,25), (short) 0);
        Sessao cineSala04 = new Sessao("klo15", narnia, LocalTime.of(13,30));
        Sessao cineSala05 = new Sessao("1567fe", narnia, LocalTime.of(15,40), (short) 0);
        Sessao cineSala06 = new Sessao("aei687", iluminado, LocalTime.of(16,0));

        do {
            menuPrincipal();
            opcaoMenu = scan.next().charAt(0);

            switch (opcaoMenu) {
                case '1':
                    System.out.println("\nCatálogo de Filmes");
                    System.out.println("1 - " + mulan.getTitulo() + " - " + mulan.getCategoria());
                    System.out.println("2 - " + narnia.getTitulo() + " - " + narnia.getCategoria());
                    System.out.println("3 - " + iluminado.getTitulo() + " - " + iluminado.getCategoria());
                    System.out.print("Escolha um filme: ");
                    opcaoFilme = scan.next().charAt(0);

                    // switch com arrow
                    switch (opcaoFilme) {
                        case '1' -> refFilme = mulan;
                        case '2' -> refFilme = narnia;
                        case '3' -> refFilme = iluminado;
                        default -> System.out.println("Você selecionou um filme inexistente");
                    }
                    // O print roda uma vez só, independente de qual caso entrou
                    if (opcaoFilme >= '1' && opcaoFilme <= '3') {
                        //comparando valores Unicode da memmória
                        System.out.println("O filme " + refFilme.getTitulo() + " foi selecionado");
                    }

                    filmeOperacao = ' ';
                    while (filmeOperacao != '0' && (opcaoFilme >= '1' && opcaoFilme <= '3')) {
                        menuFilmes();
                        filmeOperacao = scan.next().charAt(0);
                        scan.nextLine(); //consome o buffer de teclado

                        switch (filmeOperacao) {
                            case '1':
                                System.out.println("\nInformações do Filme");
                                System.out.println("Título: " + refFilme.getTitulo());
                                System.out.println("Classificação etária: " + refFilme.getClassEtaria());
                                System.out.println("Categoria: " + refFilme.getCategoria());
                                System.out.println("Sinopse: " + refFilme.getSinopse());
                                break;
                            case '2':
                                System.out.println("Categorias para Filmes");
                                System.out.println("1 - Ação\n2 - Aventura\n3 - Drama\n4 - Terror\n5 - Comédia\n");
                                System.out.print("Digite por extenso qual será a nova categoria: ");
                                String novaCategoria = scan.nextLine();
                                boolean trocaCategoria = refFilme.setCategoria(novaCategoria);

                                System.out.println(trocaCategoria ?
                                        refFilme.getTitulo() + " mudou para a categoria " + refFilme.getCategoria() :
                                        "Não é possível mudar para essa categoria!\n");
                                break;
                            case '3':
                                System.out.print("Informe a nova sinopse: ");
                                String sinopseAtualizada = scan.nextLine();
                                boolean sinopseConfirmada = refFilme.setSinopse(sinopseAtualizada);

                                System.out.println(sinopseConfirmada ?
                                        refFilme.getTitulo() + " recebeu a nova sinopse" :
                                        "Não foi possível mudar a sinopse!");
                                break;
                            case '0':
                                break;
                        }
                    }
                    break;

                case '2':
                    System.out.println("\nSessões do Cinema");
                    System.out.printf("1 - Sessão %s, %s às %s\n", cineSala01.getId(), cineSala01.getFilme().getTitulo(), cineSala01.getHorarioInicio());
                    System.out.printf("2 - Sessão %s, %s às %s\n", cineSala02.getId(), cineSala02.getFilme().getTitulo(), cineSala02.getHorarioInicio());
                    System.out.printf("3 - Sessão %s, %s às %s\n", cineSala03.getId(), cineSala03.getFilme().getTitulo(), cineSala03.getHorarioInicio());
                    System.out.printf("4 - Sessão %s, %s às %s\n", cineSala04.getId(), cineSala04.getFilme().getTitulo(), cineSala04.getHorarioInicio());
                    System.out.printf("5 - Sessão %s, %s às %s\n", cineSala05.getId(), cineSala05.getFilme().getTitulo(), cineSala05.getHorarioInicio());
                    System.out.printf("6 - Sessão %s, %s às %s\n", cineSala06.getId(), cineSala06.getFilme().getTitulo(), cineSala06.getHorarioInicio());
                    System.out.print("Escolha uma sessão para gerenciar: ");
                    sessaoConfig = scan.next().charAt(0);

                    switch (sessaoConfig) {
                        case '1' -> refSessao = cineSala01;
                        case '2' -> refSessao = cineSala02;
                        case '3' -> refSessao = cineSala03;
                        case '4' -> refSessao = cineSala04;
                        case '5' -> refSessao = cineSala05;
                        case '6' -> refSessao = cineSala06;
                        default -> System.out.println("Essa sessão não existe na lista");
                    }

                    if (sessaoConfig >= '1' && sessaoConfig <= '6') {
                        System.out.println("Sesssão " + refSessao.getId() + " foi selecionado");
                    }

                    opcaoSessaoIngre = ' '; //caso o usuário passe pelo loop mais de uma vex, o valor reinicia
                    while (opcaoSessaoIngre != '0' && (sessaoConfig >= '1' && sessaoConfig <= '6')) {
                        menuSessaoIngresso();
                        opcaoSessaoIngre = scan.next().charAt(0);

                        switch (opcaoSessaoIngre) {
                            case '1':
                                System.out.println("\nDados da Sessão");
                                System.out.println("Identificação: " + refSessao.getId());
                                System.out.println("Filme: " + refSessao.getFilme().getTitulo());
                                System.out.println("Classificação etária: " + refSessao.getFilme().getClassEtaria());
                                System.out.println("Horário de início: " + refSessao.getHorarioInicio());
                                System.out.println("Horário de término: " + refSessao.horarioTermino());
                                System.out.println("Quantidade de ingressos vendidos: " + refSessao.getIngressosVendidos());
                                System.out.println("Capacidade máxima: " + refSessao.getCapacidadeMaxima());
                                System.out.println("Assentos livres: " + refSessao.assentosDisponiveis());
                                System.out.println("Arrecadação: R$ " + String.format("%.2f", refSessao.getvalorArrecadada()));
                                break;
                            case '2':
                                System.out.println("\nTipos de ingresos");
                                System.out.println("1 - Entrada inteira");
                                System.out.println("2 - Meia-entrada");
                                System.out.print("Escolha como deseja comprar o ingresso: ");
                                char tipoIngresso = scan.next().charAt(0);

                                switch (tipoIngresso) {
                                    case '1' -> {
                                        System.out.print("\nInforme a idade do comprador: ");
                                        byte idade = scan.nextByte();
                                        ingressoVendido = refSessao.vendaIngresso(idade);
                                    }
                                    case '2' -> {
                                        System.out.print("\nInforme a idade do comprador: ");
                                        byte idade = scan.nextByte();
                                        scan.nextLine();
                                        System.out.print("Informe o documento do comprador, sem espaços em branco: ");
                                        String documento = scan.nextLine();
                                        ingressoVendido = refSessao.vendaIngresso(idade, documento);
                                    }
                                    default -> System.out.println("Essa é opção de ingresso não está disponível");
                                }

                                if (ingressoVendido > 0) {
                                    System.out.println("O ingresso foi vendido a R$ " + String.format("%.2f", ingressoVendido));
                                }
                                else if (ingressoVendido == -1f) {
                                    System.out.println(tipoIngresso == '1' ?
                                            "A idade informada é negativa" :
                                            "A idade informada é negativa ou o documento está incorreto");
                                }
                                else if (ingressoVendido == -2f) {
                                    System.out.println("O cliente não possui idade mínima indicada para ver o filme");
                                }
                                else if (ingressoVendido == -3f) {
                                    System.out.println("A sessão está lotada");
                                }
                                break;
                            case '3':
                                System.out.println("A sessão possui " + refSessao.assentosDisponiveis() + " lugares livres");
                                break;
                            case '4':
                                System.out.println("Essa sessão tem previsão de termino às " + refSessao.horarioTermino());
                                break;
                            case '0':
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;

                case '3':
                    opcaoCinema = ' ';
                    while (opcaoCinema != '0') {
                        menuCinema();
                        opcaoCinema = scan.next().charAt(0);

                        switch (opcaoCinema) {
                            case '1':
                                System.out.println("\nO valor de ingresso é R$ " + String.format("%.2f", refSessao.getPrecoIntegral()));
                                break;
                            case '2':
                                System.out.print("Informe qual será o novo preço do ingresso: ");
                                float novoPreco = scan.nextFloat();
                                boolean precoAtualizado = refSessao.setPrecoIntegral(novoPreco);

                                System.out.println(precoAtualizado ?
                                        "O ingresso foi atualizado para R$ " + String.format("%.2f", refSessao.getPrecoIntegral())
                                        : "Não é possivel mudar para esse valor");
                                break;
                            case '3':
                                System.out.printf("\nO cinema vendeu %d ingressos\n", refSessao.getIngressosVendidos());
                                System.out.printf("O total arrecadado é R$ %.2f\n", refSessao.getvalorArrecadada());
                                break;
                            case '0':
                                break;
                        }
                    }
                    break;
                case '0':
                    System.out.println("A aplicação foi encerrada!");
                    break;
                default:
                    System.out.println("Essa é uma opção incorreta\nEscolha outra opção ou encerre");
                    break;
            }
        } while (opcaoMenu != '0');
    }
}
