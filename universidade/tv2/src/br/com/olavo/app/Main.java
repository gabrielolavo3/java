package br.com.olavo.app;
import br.com.olavo.entidade.TV;
import java.util.Scanner;

public class Main {
    public static void menuTVs() {
        System.out.println("\nLista de TVs encontradas");
        System.out.println("1 - Quarto");
        System.out.println("2 - Sala");
        System.out.println("3 - Escritório");
        System.out.println("4 - Cozinha");
        System.out.println("5 - Área de lazer");
        System.out.println("0 - Sair e encerrar");
        System.out.print("Escolha uma TV para controlar: ");
    }

    public static void menuComandos() {
        System.out.println("\nMenu de Seleção");
        System.out.println("1 - Power (Ligar/Desligar a TV)");
        System.out.println("2 - Mudar o canal");
        System.out.println("3 - Aumentar o volume");
        System.out.println("4 - Diminuir o volume");
        System.out.println("0 - Voltar à seleção de TVs");
        System.out.print("Selecione a opção desejada: ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TV tvSala = new TV();
        TV tvQuarto = new TV();
        TV tvEscritorio = new TV();
        TV tvCozinha = new TV();
        TV tvLazer = new TV();
        TV controleRemoto = null; //Aponta para o contéudo de uma tv

        short canal;
        char opcao = ' ';
        char selecaoTv = ' ';

        while (selecaoTv != '0') {
            menuTVs();
            selecaoTv = scan.next().charAt(0);

            switch (selecaoTv) {
                case '1':
                    controleRemoto = tvQuarto; //Converte o valor do ponteiro para um endereço de um objeto
                    break;
                case '2':
                    controleRemoto = tvSala;
                    break;
                case '3':
                    controleRemoto = tvEscritorio;
                    break;
                case '4':
                    controleRemoto = tvCozinha;
                    break;
                case '5':
                    controleRemoto = tvLazer;
                    break;
                case '0':
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Selecione uma TV válida!");
                    break;
            }

            while (opcao != '0') {
                menuComandos();
                opcao = scan.next().charAt(0);

                switch (opcao) {
                    case '1':
                        controleRemoto.powerBtn();
                        System.out.println(controleRemoto.exibirStatus());
                        break;
                    case '2':
                        if (controleRemoto.status) {
                            System.out.print("Informe o nº do canal que deseja: ");
                            canal = scan.nextShort();
                            boolean canalMudado = controleRemoto.mudarCanal(canal);

                            if (canalMudado) {
                                System.out.println(controleRemoto.exibirStatus());
                            } else {
                                System.out.println("Canal inválido! Tente os canais 1, 3, 5, 7 ou 11");
                            }

                        } else {
                            System.out.println("ERRO! Ligue a TV");
                        }
                        break;
                    case '3':
                        if (controleRemoto.status) {
                            controleRemoto.aumentaVolume();
                            System.out.println(controleRemoto.exibirStatus());
                        } else {
                            System.out.println("ERRO! Ligue a TV");
                        }
                        break;
                    case '4':
                        if (controleRemoto.status) {
                            controleRemoto.diminuiVolume();
                            System.out.println(controleRemoto.exibirStatus());
                        } else {
                            System.out.println("ERRO! Ligue a TV");
                        }
                        break;
                    case '0':
                        //Serve apenas para sair desse loop e voltar para o menu das tvs
                        break;
                    default:
                        System.out.println("Selecione uma opção válida!");
                        break;
                }
            }
        }
    }
}