package br.com.olavo.main;
import br.com.olavo.entidade.ContaImpressao;
import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("\nConfiguração de Conta");
        System.out.println("1 - Adicionar créditos");
        System.out.println("2 - Solicitar impressão");
        System.out.println("3 - Consultar uma conta");
        System.out.println("4 - Alterar o preço por página");
        System.out.println("5 - Consultar o preço por página");
        System.out.println("6 - Consultar o total de páginas impressas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma das opções acima: ");
    }

    public static void statusImpressao(byte impressao, ContaImpressao ref) {
        if (impressao == -1) {
            System.out.println("Sua conta não possui saldo o suficiente");
        }
        else if (impressao == -2) {
            System.out.println("Os dados para impressão estão incorretos");
        }
        else {
            System.out.println("Impressão finalizada com sucesso");
            System.out.println("O seu saldo atual é R$ " + String.format("%.2f", ref.getSaldo()));
        }
    }

    public static void main(String[] args) {
        char opcaoMenu, escolhaConta = ' ';
        int paginas, copias;
        float valor;
        String mensagem;
        boolean validado;

        ContaImpressao estudante01 = new ContaImpressao("Ana Silva", "CD001");
        ContaImpressao estudante02 = new ContaImpressao("Bruno Lopes", "CD005");
        ContaImpressao refEstudante = null;
        Scanner scan = new Scanner(System.in);

        while (escolhaConta != '0') {
            System.out.println("Contas de estudantes cadastrados");
            System.out.println("1 - " + estudante01.getNome());
            System.out.println("2 - " + estudante02.getNome());
            System.out.println("0 - Encerrar o programa");
            System.out.print("Selecione qual conta deseja administrar ou encerre a aplicação: ");
            escolhaConta = scan.next().charAt(0);

            switch (escolhaConta) {
                case '1':
                    refEstudante = estudante01;
                    System.out.println("Conta em uso: " + refEstudante.getNome());
                    break;
                case '2':
                    refEstudante = estudante02;
                    System.out.println("Conta em uso: " + refEstudante.getNome());
                    break;
                case '0':
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Escolha incorreta! Volte e selecione um aluno da lista");
                    continue; //ignora o encerramento do switch e a entrada no próximo while
            }

            opcaoMenu = ' '; //precisa reiniciar a variável para entrar no 2º while quando mudar de aluno

            //menu executa somente se há um aluno escolhido
            while (opcaoMenu != '0' && escolhaConta != '0') {
                menu();
                opcaoMenu = scan.next().charAt(0);

                switch (opcaoMenu) {
                    case '1':
                        System.out.print("\nDigite a quantia de créditos para depositar: ");
                        valor = scan.nextFloat();
                        validado = refEstudante.addSaldo(valor);

                        mensagem = validado ? "R$ " + String.format("%.2f", valor) + " adicionado!\nSeu saldo é R$ "
                                            + String.format("%.2f", refEstudante.getSaldo())
                                            : "Deposite um valor maior";
                        System.out.println(mensagem);
                        break;
                    case '2':
                        byte imprimido;
                        System.out.print("\nInforme quantas páginas serão impressas: ");
                        paginas = scan.nextInt();
                        System.out.print("Deseja adicionar cópias (s/n): ");
                        char adicionarCopia = scan.next().charAt(0);

                        switch (Character.toLowerCase(adicionarCopia)) {
                            case 's':
                                System.out.print("Informe a quantidade de cópias que deseja: ");
                                copias = scan.nextInt();
                                imprimido = refEstudante.impressao(paginas, copias);
                                statusImpressao(imprimido, refEstudante);
                                break;
                            case 'n':
                                imprimido = refEstudante.impressao(paginas);
                                statusImpressao(imprimido, refEstudante);
                                break;
                            default:
                                System.out.println("Essa á uma opção inexistente!");
                                break;
                        }
                        break;
                    case '3':
                        System.out.println("\nNome do estudante: " + refEstudante.getNome());
                        System.out.println("Matricula: " + refEstudante.getMatricula());
                        System.out.println("Saldo em conta: R$ " + String.format("%.2f", refEstudante.getSaldo()));
                        break;
                    case '4':
                        System.out.print("\nInsira o preço atual da impressão por página: ");
                        valor = scan.nextFloat();
                        validado = ContaImpressao.setPrecoPagina(valor);

                        mensagem = validado ? "O valor da impressão foi atualizado com sucesso!" : "O novo valor precisar ser positivo e diferente do preço atual";
                        System.out.println(mensagem);
                        break;
                    case '5':
                        System.out.printf("\nPreço por página: R$ %.2f", ContaImpressao.getPrecoPagina());
                        break;
                    case '6':
                        System.out.println("\nContabilizando as contas, foram impressas o total de " + ContaImpressao.getTotalPagImpressa() + " páginas");
                        break;
                    case '0':
                        break; //interrompe o switch e retorna ao 1º menu
                    default:
                        System.out.println("Escolha incorreta!");
                        break;
                }
            }
        }
    }
}