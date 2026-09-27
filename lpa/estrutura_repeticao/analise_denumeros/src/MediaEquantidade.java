/* 
Descrição  : Ler vários números inteiros e positivos e imprimir a quantidade de pares e ímpares, média de pares e média de todos os números. A leitura acaba com o 0! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 22/03/2024 */

import java.util.Scanner;

public class MediaEquantidade {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis e leitor

        int valor;
        short contador = 0;
        byte pares = 0;
        byte impar = 0;
        byte somaPar = 0;
        byte somaTotal = 0;
        byte totalNumeros = 0;
        float mediaPar = 0;
        float mediaTotal = 0;

        Scanner leitor = new Scanner(System.in);

        // Solicitando dados

        System.out.println("DR4VE - LEITOR DE NÚMEROS\n");
        do {
            contador++;
            System.out.printf("Digite o %dº número: ", contador);
            valor = leitor.nextInt();

            if (valor % 2 == 0 && valor != 0)
                pares++;
                somaPar += valor;

            if (valor % 2 != 0 && valor != 0)
                impar++;

            if (valor != 0)
                totalNumeros++;
                somaTotal += valor;


        } while (valor != 0);

        mediaPar =  somaPar / (float) pares;
        mediaTotal =  somaTotal / (float) totalNumeros;

        // Tela de resultado

        System.out.print("\033[2J");
        System.out.println("DR4VE - LEITOR DE NÚMEROS\n");
        System.out.println("Quantidade de números pares: " + pares);
        System.out.println("Quantidade de números ímpares: " + impar);
        System.out.printf("Média dos números pares: %.2f\n", mediaPar);
        System.out.printf("Média de todos os números: %.2f", mediaTotal);
    }
}
