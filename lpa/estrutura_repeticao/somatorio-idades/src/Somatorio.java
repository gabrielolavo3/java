/* 
Descrição  : Ler uma quantidade N de idades e imprimir a média e a soma das idades a partir de 18 anos! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 23/03/2024 */

import java.util.Scanner;

public class Somatorio {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis e leitor
        
        byte contador = 0;
        short idade;
        short maioridade = 0;
        short somaIdades = 0;
        float media;

        Scanner leitor = new Scanner(System.in);

        // Solicitando dados

        do {
            contador++;
            do {
                
                System.out.printf ("Digite a %dª idade (Zero encerra o software): ", contador);
                idade = leitor.nextShort();

                if (idade < 0)
                    System.out.println("\nIdade incorreta! Insira uma idade positiva\n");

            } while(idade < 0);

            if (idade >= 18) {
                somaIdades+=idade;
                maioridade++;
            }

        } while(idade != 0);

        media = (maioridade > 0 ) ? (float)somaIdades / maioridade : 0;

        // Tela de resultado

        System.out.println("\nSomatório das idades a partir de 18 anos: " + somaIdades);
        System.out.printf("Média das idades a partir de 18: %.2f", media);
    }
}
