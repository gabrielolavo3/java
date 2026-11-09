package br.com.olavo.main;
import br.com.olavo.entidades.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        TV[] comodosCasa = new TV[5];
        byte opcaoTV;                
        
        for (int i = 0; i < comodosCasa.length; i++) {
            System.out.println("Modelos de TV para o cômodo " + (i+1));
            System.out.println("\n1 - TV tradicional");
            System.out.println("2 - SmartTV");
            System.out.println("3 - SmartTV Controlada");
            System.out.print("Esolha qual TV o cômodo terá: ");
            byte modelo = scan.nextByte();
            System.out.println("\n");
                    
            switch (modelo) {
                case 1 -> comodosCasa[i] = new TV();
                case 2 -> comodosCasa[i] = new SmartTV();
                case 3 -> comodosCasa[i] = new SmartTVControladora();
                default -> {
                    System.out.println("O modelo é inválido! Uma TV tradicional foi colocado no cômodo\n");
                    comodosCasa[i] = new TV();
                }
            }
        }        

        do {
            // Percorre todos os cômodos com TV
            System.out.println("===CONTROLE DE TELEVISÔES===\n");
            for (int i = 0; i < comodosCasa.length; i++) {
                System.out.println((i+1) + " - TV do cômodo " + (i+1));
            }

            System.out.println("0 - Sair e encerrar");
            System.out.print("Escolha qual cômodo deseja acessar: ");
            opcaoTV = scan.nextByte();

            // Verifica se o cômodo escolhido está no limite permitido
            if (opcaoTV >= 1 && opcaoTV <= 5) {                
                TV tvEscolhida = comodosCasa[opcaoTV -1]; // Subtrai uma poição para não ultrapassar o limite do vetor

                // Caso a instância de memória seja SmartTV ou SmarTVControlada, chama o método correspondente
                if (tvEscolhida instanceof SmartTV) {
                    // Casting para chamar o método certo para SmartTV ou SmarTVControlada
                    controleRemoto((SmartTV)tvEscolhida, scan);
                }
                else {
                    controleRemoto(tvEscolhida, scan);
                }
            }
            else if (opcaoTV != 0) {
                System.out.println("O cômodo é inexistente nessa casa!");
            }
        } while (opcaoTV != 0);

        System.out.println("A execução foi encerrada");
    }

    public static void menuTV() {
        System.out.println("\n===TELEVISÃO===");
        System.out.println("1 - Power (Ligar ou Desligar)");
        System.out.println("2 - Alterar o canal");
        System.out.println("3 - Aumentar ou diminuir o volume");
        System.out.println("0 - Voltar à seleção de TVs");
        System.out.print("Selecione uma funcionalidade: ");
    }

    public static void menuSmartTV() {
        System.out.println("\n===SMART TV===");
        System.out.println("1 - Power (Ligar ou Desligar)");
        System.out.println("2 - Alterar o canal");
        System.out.println("3 - Aumentar ou diminuir o volume");
        System.out.println("4 - Conectar ou desconectar");
        System.out.println("5 - Alterar modo de funcionamento");
        System.out.println("6 - Alterar login e senha");
        System.out.println("0 - Voltar à seleção de TVs");
        System.out.print("Selecione uma funcionalidade: ");
    }

    public static void controleRemoto(TV tv, Scanner scan) {
        char escolhaFuncao;
        do {
            menuTV();
            escolhaFuncao = scan.next().charAt(0);

            switch (escolhaFuncao) {
                case '1' -> {
                    tv.powerBtn();
                    System.out.println(tv.toString());
                }
                case '2' -> {
                    if (tv.getStatus()) {
                        System.out.print("Informe o número do canal: ");
                        byte canal = scan.nextByte();
                        byte canalMudado = tv.alterarCanal(canal);

                        System.out.println(canalMudado == -1 ? tv.toString() :
                                "Canal inválido! Os canais 1, 3, 5, 7 e 11 estão disponíveis");
                    } else {
                        System.out.println("TV desligada. Ligue-a\n");
                    }
                }
                case '3' -> {
                    if (tv.getStatus()) {
                        System.out.println("1 - Aumentar volume");
                        System.out.println("2 - Diminuir volume");
                        System.out.print("Escolha o que deseja: ");
                        char tipoVolume = scan.next().charAt(0);

                        if (tipoVolume == '1') {
                            tv.addVolume();
                        }
                        else {
                            tv.diminuiVolume();
                        }

                        System.out.println(tv.toString());
                    } else {
                        System.out.println("TV desligada. Ligue-a\n");
                    }
                }
                case '0' -> System.out.println();
                default -> System.out.println("Funcionalidade de TV inexistente");
            }
        } while (escolhaFuncao != '0');
    }

    public static void controleRemoto(SmartTV smart, Scanner scan) {
        char escolhaFuncao;

        do {
            menuSmartTV();
            escolhaFuncao = scan.next().charAt(0);

            switch (escolhaFuncao) {
                case '1' -> {
                    smart.powerBtn();
                    System.out.println(smart.toString());
                }
                case '2' -> {
                    if (smart.getStatus() && smart.getModo() == 1) {
                        System.out.print("Informe o número do canal: ");
                        byte canal = scan.nextByte();
                        byte canalMudado = smart.alterarCanal(canal);

                        System.out.println(canalMudado == -1 ? smart.toString() :
                                "Canal inválido! Os canais 1, 3, 5, 7 e 11 estão disponíveis");
                    }
                    else {
                        System.out.println("Smart TV desligada ou em modo Smart. Ligue-a ou mude o funcionamento\n");
                    }
                }
                case '3' -> {
                    if (smart.getStatus()) {
                        System.out.println("\n1 - Aumentar volume");
                        System.out.println("2 - Diminuir volume");
                        System.out.print("Escolha o que deseja: ");
                        char tipoVolume = scan.next().charAt(0);

                        if (tipoVolume == '1') {
                            smart.addVolume();
                        } else {
                            smart.diminuiVolume();
                        }
                        System.out.println(smart.toString());
                    } else {
                        System.out.println("TV desligada. Ligue-a\n");
                    }
                }
                case '4' -> {
                    if (smart.getStatus()) {
                        System.out.println("\n1 - Conectar a Smart");
                        System.out.println("2 - Desconectar a Smart");
                        System.out.print("Escolha o que deseja: ");
                        char tipoConexao = scan.next().charAt(0);

                        switch (tipoConexao) {
                            case '1' -> {
                                if (smart.getModo() == 2) {
                                    if (!smart.getConexao()) {
                                        scan.nextLine(); // Limpa o buffer do teclado
                                        System.out.print("Informe o login da conta: ");
                                        String login = scan.nextLine();
                                        System.out.print("Informe a senha da conta: ");
                                        String senha = scan.nextLine();
                                        boolean smartConectada = smart.conectarNet(login, senha);

                                        System.out.println(smartConectada ? smart.toString()
                                                : "Smart TV não conectada. Login ou Senha incorreto");
                                    } else {
                                        System.out.println("A conta da Smart TV já está conectada.");
                                    }
                                } else {
                                    System.out.println("Mude a TV para o modo Smart antes de conectar");
                                }
                            }
                            case '2' -> {
                                if (smart.getModo() == 2) {
                                    if (smart.getConexao()) {
                                        smart.desconectarNet();
                                        System.out.println("A Smart TV foi desconectada");
                                    } else {
                                        System.out.println("A Smart TV já está desconectada");
                                    }
                                } else {
                                    System.out.println("Você não está no modo Smart TV");
                                }
                            }
                        }
                    } else {
                        System.out.println("TV desligada. Ligue-a\n");
                    }
                }
                case '5' -> {
                    if (smart.getStatus()) {
                        System.out.print("Informe o modo de funcionamento (1(TV) ou 2(SmartTV)): ");
                        byte modo = scan.nextByte();

                        if (smart.setModo(modo) == 0) {
                            System.out.println(modo == 1 ? "Modo alterado para TV\n" : "Modo alterado para Smart TV\n");
                        } else {
                            System.out.println("Não foi possível mudar o modo (opção inválida)");
                        }
                    }
                    else {
                        System.out.println("Ligue o dispositivo antes de alterar o modo");
                    }
                }
                case '6' -> {
                    if (smart.getModo() == 2) {
                        if (smart.getConexao()) {
                            scan.nextLine();
                            System.out.print("Informe um novo código de login da conta: ");
                            String login = scan.nextLine();
                            System.out.print("Informe uma nova senha da conta: ");
                            String senha = scan.nextLine();
                            boolean atualizou = smart.novasCredenciais(login, senha);

                            System.out.println(atualizou ? "Credenciais atualizadas com sucesso!"
                                    : "Login/senha não podem ser vazios ou iguais aos atuais");
                        } else {
                            System.out.println("A Smart TV precisa estar CONECTADA à internet para alterar credenciais");
                        }
                    }
                    else {
                        System.out.println("Somente o modo Smart TV pode usar a configuração");
                    }
                }
                case '0' -> System.out.println();
                default -> System.out.println("Funcionalidade de Smart TV inexistente");
            }
        } while (escolhaFuncao != '0');
    }    
}
