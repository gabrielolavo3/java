/* 
Descrição  : Ler a idade de 10 pessoas e imprimir a quantidade de pessoas com idade igual ou acima de 18 anos! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 03/03/2024 */

import java.util.Scanner;

public class Maioridade {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis e configuração de leitor
        
        byte idade;
        byte contador = 0;
        int maiorIdade = 0;

        Scanner leitorAnos = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("INSTITUTO HOLMES - Analisador de Idade Populacional\n");

        for (contador = 1; contador <= 10; contador++) {
            System.out.printf ("Digite a idade da %dª pessoa: ", contador);
            idade = leitorAnos.nextByte();

            if (idade >= 18) {
                maiorIdade++;
            }
        }

        // Tela de resultado

        System.out.print("\033[2J");
        System.out.println ("INSTITUTO HOLMES - Analisador de Idade Populacional\n");
        System.out.println ("Quantidade de pessoas com idade igual ou acima de 18 anos: " + maiorIdade);
    }
}
