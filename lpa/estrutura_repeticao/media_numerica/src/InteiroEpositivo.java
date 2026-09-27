/* 
Descrição  : Ler vários números positivos e inteiros, e imprimir a média dos valores digitados. O final da leitura ocorre quando for lido um valor negativo! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 21/03/2024 */

import java.util.Scanner;

public class InteiroEpositivo {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis e leitor
        
        int valor;
        int somaValores = 0;
        short contador = 0;
        float media = 0;
        Scanner leitor = new Scanner(System.in);

        // Solicitando dados

        do {
            contador++; // Acumula a quantidade de itereções
            System.out.printf("Digite o %dº número (valor negativo encerra a sessão): ",contador);
            valor = leitor.nextInt();

            while (valor == 0) {
                System.out.println("\nValor não aceito! Insira números positivos ou encerre a sessão com um negativo\n");
                System.out.printf("Digite o %dº número: ",contador);
                valor = leitor.nextInt();
            }

            if (valor > 0)
                somaValores += valor;

        } while (valor >= 0 );

        media = (float) somaValores / contador;

        // Tela de resultado

        System.out.printf ("\nMédia dos números informados: %.2f", media);
    }
}
