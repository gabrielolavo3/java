package br.com.olavo.app;
import br.com.olavo.entidade.TV;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        short canal;
        char opcao = ' ';
        String ambiente = "SALA";
        boolean tvLigadaSala = true;

        Scanner scan = new Scanner(System.in);
        TV tvSala = new TV();
        TV tvQuarto = new TV();
        TV controleRemoto = tvSala; //Controla a mudança entre as TVs nos ambientes

        while(opcao != '0') {
            System.out.println("\nMenu de Seleção");
            System.out.println("Você está no ambiente " + ambiente + "!\n");
            System.out.println("1 - Power(Ligar/Desligar a TV)");
            System.out.println("2 - Mudar o canal");
            System.out.println("3 - Aumentar o volume");
            System.out.println("4 - Diminuir o volume");
            System.out.println("5 - Mudar o ambiente da TV");
            System.out.println("0 - Sair e encerrar");
            System.out.print("Selecione a opção desejada: ");
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
                    if (controleRemoto.status){
                        controleRemoto.aumentaVolume();
                        System.out.println(controleRemoto.exibirStatus());
                    } else {
                        System.out.println("ERRO! Ligue a TV");
                    }
                    break;
                case '4':
                    if (controleRemoto.status){
                        controleRemoto.diminuiVolume();
                        System.out.println(controleRemoto.exibirStatus());
                    } else {
                        System.out.println("ERRO! Ligue a TV");
                    }
                    break;
                case '5':
                    if (tvLigadaSala) {
                        tvLigadaSala = false;
                        ambiente = "QUARTO";
                        controleRemoto = tvQuarto;
                    } else {
                        tvLigadaSala = true;
                        ambiente = "SALA";
                        controleRemoto = tvSala;
                    }
                    break;
                case '0':
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Selecione uma opção válida ou encerre a execução!");
                    break;
            }
        }
    }
}
