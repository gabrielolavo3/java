/* 
Descrição  : Ler 10 números e imprimir a quantidade de números entre 30 e 90! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 16/03/2024 */

import java.util.Scanner;

public class Intervalo_numerico {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        byte contador;
        float valor;
        byte entre30_90 = 0;

        Scanner leitorNumerico = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("ONE - Contador Numerico\n");

        for (contador = 1; contador <= 10; contador++) {
            System.out.printf ("Digite o %dº valor: ", contador);
            valor = leitorNumerico.nextFloat();

            if (valor >= 30 && valor <= 90) {
                entre30_90++;
            }
        }

        // Tela de resultado

        System.out.print ("\033[2J");
        System.out.println ("ONE - Contador Numerico\n");
        System.out.println ("Quantidade de números entre 30 e 90: " + entre30_90);

    }
}