/* 
Descrição  : Ler a idade, peso e altura de 25 pessoas. Imprimir a quantidade de pessoas 50+; a média de altura de pessoas entre 10 e 20 anos; porcentagem de pessoas abaixo de 40 Kg! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 18/03/2024 */

import java.util.Scanner;

public class Media_porcentagem {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis
        
        byte contador = 0;
        byte idadeAcima50 = 0;
        short idade;
        float peso;
        float altura;
        float somaAltura = 0;
        byte somaPeso = 0;
        float faixaEtaria = 0;
        float mediaDeAltura = 0;
        float porcentagemPeso = 0;

        Scanner atribuidor = new Scanner(System.in);

        // Solicitando dados 

        for (contador = 1; contador <= 10; contador++) {
            System.out.printf ("Digite a idade da %dª pessoa: ", contador);
            idade = atribuidor.nextByte();
            System.out.printf ("Digite a altura: ");
            altura = atribuidor.nextFloat();
            System.out.printf ("Digite o peso: ");
            peso = atribuidor.nextFloat();
            System.out.println ("");

            if (idade > 50) {
                idadeAcima50++;
            }

            if (idade >= 10 && idade <= 20) {
                somaAltura+=altura;
                faixaEtaria++;
            }

            if (peso < 40) {
                somaPeso++;
            }
        }

        mediaDeAltura = somaAltura / faixaEtaria;
        porcentagemPeso = ((float)somaPeso / (float) contador) * 100;

        // Tela de resultado

        System.out.print ("\033[2J");
        System.out.println ("Quantidade de pessoas com idade superior a 50 anos: " + idadeAcima50);
        System.out.printf ("Média das Alturas das pessoas com idade entre 10 e 20 anos: %.2f\n", mediaDeAltura);
        System.out.printf ("Porcentagem das pessoas com peso inferior a 40 quilos: %.2f%%", porcentagemPeso);
    }
}
