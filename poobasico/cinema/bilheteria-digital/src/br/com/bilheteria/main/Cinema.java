// Estudantes: Nina Moreira Baggio Vieira e Gabriel Santos Olavo

package br.com.bilheteria.main;
import br.com.bilheteria.entidades.*;
import java.time.LocalTime;
import java.util.Scanner;

public class Cinema {
    private static final Scanner entrada = new Scanner(System.in);
    //vetores para armazenar os filmes e sessões
    private static final Filme[] filmes = new Filme[3];
    private static final Sessao[] sessoes = new Sessao[5];

    public static void main(String[] args) {
        cadastrarDadosIniciais();

        int opcao;
        do {
            System.out.println("\n===== CINEMA =====");
            System.out.println("1 - Gerenciar filmes");
            System.out.println("2 - Gerenciar sessões e vender ingressos");
            System.out.println("3 - Consultar e atualizar informações do cinema");
            System.out.println("0 - Sair");
            //ler o número por meio de metodo
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    gerenciarFilmes();
                    break;
                case 2:
                    gerenciarSessoes();
                    break;
                case 3:
                    informacoesCinema();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    //criação de filmes e sessões em cada posição do vetor
    private static void cadastrarDadosIniciais() {
        filmes[0] = new Filme("Batman", (short) 130, "Ação", (byte) 12);
        filmes[1] = new Filme("Divertida Mente 2", (short) 96); //usa a 2ª forma de sobrecarga de construtor
        filmes[2] = new Filme("O Auto da Compadecida", (short) 104, "Comédia", (byte) 10);

        sessoes[0] = new Sessao("A101", filmes[0], LocalTime.of(14, 0), (short) 80);
        sessoes[1] = new Sessao("A102", filmes[0], LocalTime.of(18, 0)); //usa a 2ª forma de sobrecarga de construtor
        sessoes[2] = new Sessao("B201", filmes[1], LocalTime.of(13, 30), (short) 60);
        sessoes[3] = new Sessao("B202", filmes[1], LocalTime.of(16, 0));
        sessoes[4] = new Sessao("C301", filmes[2], LocalTime.of(20, 0), (short) 70);
    }

    private static void gerenciarFilmes() {
        int escolha;
        do {
            //exibe a lista de filmes dentro do laço até a posição final do vetor
            System.out.println("\n===== FILMES =====");
            for (int i = 0; i < filmes.length; i++) {
                System.out.println((i + 1) + " - " + filmes[i].getTitulo()
                        + " | Categoria: " + filmes[i].getCategoria());
            }
            System.out.println("0 - Voltar ao menu principal");
            escolha = lerInteiro("Escolha um filme: ");

            //caso a escolha do filme esteja no limite, chama o menuFilme passado o vetor com posição -1 para representar a instância real
            if (escolha >= 1 && escolha <= filmes.length) {
                menuFilme(filmes[escolha - 1]);
            } else if (escolha != 0) {
                System.out.println("Filme inválido.");
            }
        } while (escolha != 0);
    }

    private static void menuFilme(Filme filme) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAR FILME =====");
            System.out.println("1 - Consultar dados do filme");
            System.out.println("2 - Alterar categoria");
            System.out.println("3 - Alterar sinopse");
            System.out.println("0 - Voltar ao menu principal");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.println("Título: " + filme.getTitulo());
                    System.out.println("Duração: " + filme.getDuracao() + " minutos");
                    System.out.println("Classificação etária: " + filme.getClassEtaria());
                    System.out.println("Categoria: " + filme.getCategoria());
                    System.out.println("Sinopse: " + filme.getSinopse());
                    break;
                case 2:
                    System.out.println("Categorias: Ação, Aventura, Comédia, Drama e Terror");
                    String categoria = lerTexto("Nova categoria: ");

                    //muda o print conforme o retorno da set
                    System.out.println(filme.setCategoria(categoria) ?
                            "Categoria alterada com sucesso."
                            : "Categoria recusada. A categoria anterior foi mantida.");
                    break;
                case 3:
                    String sinopse = lerTexto("Nova sinopse: ");

                    System.out.println(filme.setSinopse(sinopse) ?
                            "Sinopse alterada com sucesso."
                            : "A sinopse não pode ficar vazia.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarSessoes() {
        int escolha;
        do {
            //exibe a lista de sessões e seu respectivo filme dentro do laço até a posição final do vetor
            System.out.println("\n===== SESSÕES =====");
            for (int i = 0; i < sessoes.length; i++) {
                System.out.println((i + 1) + " - Código: " + sessoes[i].getId()
                        + " | Filme: " + sessoes[i].getFilme().getTitulo()
                        + " | Início: " + sessoes[i].getHorarioInicio());
            }
            System.out.println("0 - Voltar ao menu principal");
            escolha = lerInteiro("Escolha uma sessão: ");

            //caso a escolha do filme esteja no limite, chama o menuFilme passado o vetor com posição -1 para representar a instância real
            if (escolha >= 1 && escolha <= sessoes.length) {
                menuSessao(sessoes[escolha - 1]);
            } else if (escolha != 0) {
                System.out.println("Sessão inválida.");
            }
        } while (escolha != 0);
    }

    //menu que gerencia as sessões e ingressos, recebe a sessão atual
    private static void menuSessao(Sessao sessao) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAR SESSÃO =====");
            System.out.println("1 - Consultar detalhes da sessão");
            System.out.println("2 - Vender ingresso");
            System.out.println("3 - Consultar lugares disponíveis");
            System.out.println("4 - Consultar horário de término");
            System.out.println("0 - Voltar ao menu principal");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    Filme filme = sessao.getFilme();
                    System.out.println("Código: " + sessao.getId());
                    System.out.println("Início: " + sessao.getHorarioInicio());
                    System.out.println("Término: " + sessao.horarioTermino());
                    System.out.println("Filme: " + filme.getTitulo());
                    System.out.println("Duração: " + filme.getDuracao() + " minutos");
                    System.out.println("Classificação etária: " + filme.getClassEtaria());
                    System.out.println("Categoria: " + filme.getCategoria());
                    System.out.println("Sinopse: " + filme.getSinopse());
                    System.out.println("Capacidade máxima: " + sessao.getCapacidadeMaxima());
                    System.out.println("Ingressos vendidos: " + sessao.getIngressosVendidos());
                    System.out.println("Lugares disponíveis: " + sessao.assentosDisponiveis());
                    System.out.printf("Arrecadação: R$ %.2f%n", sessao.getvalorArrecadada()); //valor vendido na seesão atual
                    break;
                case 2:
                    //chama o metodo da aplicação que trata do ingresso passando a sessao atual escolhida antes
                    venderIngresso(sessao);
                    break;
                case 3:
                    System.out.println("Lugares disponíveis: " + sessao.assentosDisponiveis());
                    break;
                case 4:
                    System.out.println("Horário de término: " + sessao.horarioTermino());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void venderIngresso(Sessao sessao) {
        System.out.println("1 - Ingresso integral");
        System.out.println("2 - Meia-entrada");
        int tipo = lerInteiro("Tipo de ingresso: "); //leitura de dado por meio de metodo
        int idadeInformada = lerInteiro("Idade do espectador: ");

        // verifica se a idade está no limite de um Byte
        if (idadeInformada < -128 || idadeInformada > 127) {
            System.out.println("Dados inválidos: idade fora do intervalo permitido.");
            return;
        }
        byte idade = (byte) idadeInformada; //conversão explicita de Int para Byte
        float valor;

        if (tipo == 1) {
            valor = sessao.vendaIngresso(idade);
        } else if (tipo == 2) {
            String documento = lerTexto("Número do documento comprobatório: ");  //leitura de dado por meio de metodo
            valor = sessao.vendaIngresso(idade, documento); //atribuir o retorno do metodo e passa os dados para vender o ingresso
        } else {
            System.out.println("Tipo de ingresso inválido.");
            return;
        }

        //exibição de status de compra conforme o retorno de metodo salvo na variável
        if (valor == -1f) {
            System.out.println("Venda recusada: dados inválidos.");
        } else if (valor == -2f) {
            System.out.println("Venda recusada: idade incompatível com a classificação do filme.");
        } else if (valor == -3f) {
            System.out.println("Venda recusada: não há lugares disponíveis.");
        } else {
            System.out.printf("Ingresso vendido! Valor cobrado: R$ %.2f%n", valor);
        }
    }

    private static void informacoesCinema() {
        int opcao;
        do {
            System.out.println("\n===== INFORMAÇÕES DO CINEMA =====");
            System.out.println("1 - Consultar preço integral do ingresso");
            System.out.println("2 - Alterar preço integral do ingresso");
            System.out.println("3 - Consultar totais de ingressos vendidos e arrecadação");
            System.out.println("0 - Voltar ao menu principal");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.printf("Preço integral: R$ %.2f%n", Sessao.getPrecoIntegral());
                    break;
                case 2:
                    float novoPreco = lerFloat("Informe o novo preço integral: R$ ");
                    System.out.println(Sessao.setPrecoIntegral(novoPreco) ?
                            "Preço alterado com sucesso."
                            : "Alteração recusada. Informe um preço positivo e diferente do atual." );
                    break;
                case 3:
                    int totalIngressos = 0;
                    float totalArrecadado = 0;
                    //forEach que percerre todas as posições e instâncias do vetor para buscar e somar a quantidade de ingressos e dinheiro
                    for (Sessao sessao : sessoes) {
                        totalIngressos += sessao.getIngressosVendidos();
                        totalArrecadado += sessao.getvalorArrecadada();
                    }
                    System.out.println("Total de ingressos vendidos: " + totalIngressos);
                    System.out.printf("Arrecadação total: R$ %.2f%n", totalArrecadado);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            //tratamento de exceção
            try {
                System.out.print(mensagem); //exibe a mensagem passada na chamada de metodo
                return Integer.parseInt(entrada.nextLine().trim()); //ler a entrada como String, converte para Int e retirar espaços em branco
            } catch (NumberFormatException e) {
                //caso não seja um número, exibe a mensagem
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static float lerFloat(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                //ler a entrada como String, converte para Int, retirar espaços em branco e troca a separação dos decimais
                String texto = entrada.nextLine().trim().replace(',', '.');
                return Float.parseFloat(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido.");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine();
    }
}