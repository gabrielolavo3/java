/* 
Descrição  : Ler 10 números inteiros e imprimir qual é o maior e o menor valor entre todos! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 22/03/2024 */

import java.util.Scanner;

public class menorMaior {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e leitor

        byte contador;
        int valor;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        Scanner leitor = new Scanner(System.in);

        // Solicitando dados

        for (contador = 1; contador <= 10; contador++) {
            System.out.printf("Digite o %dº número: ", contador);
            valor = leitor.nextInt();

            maior = maior < valor ? valor : maior;
            menor = menor > valor ? valor : menor;
        }

        System.out.print("\033[2J");
        System.out.println("CONCLUSÃO\n");
        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
    }
}
