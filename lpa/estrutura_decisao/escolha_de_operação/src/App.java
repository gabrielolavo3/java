/* 
Descrição  : Ler 2 números e imprimir o resultado da operação escolhida pelo usuário. A operação dever ser: 1. Par e ímpar OU 2. Positivo e negativo! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 03/03/2024 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis e configuração de leitor

        char menu;
        int primeiroNumero;
        int segundoNumero;
        String resultadoNumero1 = null;
        String resultadoNumero2 = null;

        Scanner leitorInt = new Scanner(System.in);
        Scanner leitorOpcao = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("MINI CALCULADORA OLK\n");
        System.out.print ("Digite o primeiro número: ");
        primeiroNumero = leitorInt.nextInt();
        System.out.print ("Digite o segundo número: ");
        segundoNumero = leitorInt.nextInt();

        System.out.print ("\033[2J");
        System.out.println ("MINI CALCULADORA OLK\n");
        System.out.println ("Código | Operação");
        System.out.println ("   1   | Descobrir par e ímpar");
        System.out.println ("   2   | Descobrir positivo e negativo\n");
        System.err.print("Digite o código da operação que deseja: ");
        menu = leitorOpcao.next().charAt(0);

        switch (menu) {
            case '1':
            resultadoNumero1 = (primeiroNumero % 2 == 0) ? "Par" : "Ímpar";
            resultadoNumero2 = (segundoNumero % 2 == 0) ? "Par" : "Ímpar";
                break;
            
            case '2':
            resultadoNumero1 = (primeiroNumero > 0) ? "Positivo" : "";
            resultadoNumero1 = (primeiroNumero < 0) ? "Negativo" : resultadoNumero1;
            
            resultadoNumero2 = (segundoNumero > 0) ? "Positivo" : "";
            resultadoNumero2 = (segundoNumero < 0) ? "Negativo" : resultadoNumero2;

            resultadoNumero1 = (primeiroNumero == 0) ? "É neutro" : "";
            resultadoNumero2 = (segundoNumero == 0) ? "É neutro" : "";
                break;
            
            default:
            System.out.print ("\033[2J");
            System.out.println ("Operação não realizada! A opção digitada foi incorreta");
                break;
        }

        if (menu == '1' || menu == '2') {
            //System.out.print ("\033[2J");
            System.out.println("\n1º valor: " + primeiroNumero);
            System.out.println("2º valor: " + segundoNumero);
            System.out.println("\nResultado do 1º número: " + resultadoNumero1);
            System.out.println("Resultado do 2º número: " + resultadoNumero2);
        }
        
    }
}
