/* 
Descrição  : Ler a idade e altura de 5 pessoas e imprimir a maior e menor idade, e a maior e menor altura! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 23/03/2024 */

import java.util.Scanner;

public class IdadeAltura {
    public static void main(String[] args) throws Exception {
        
        byte contador;
        short idade;
        short maisJovem = Short.MAX_VALUE; // Atribuindo o maior valor Short
        short maisVelha = Short.MIN_VALUE;
        float altura;
        float maiorAltura = Float.MIN_VALUE;
        float menorAltura = Float.MAX_VALUE;

        Scanner leitor = new Scanner(System.in);

        for (contador = 1; contador <= 5; contador++) {
            do {

                System.out.printf("Digite o idade da %d pessoa: ", contador);
                idade = leitor.nextShort();

                if (idade <= 0 || idade > 160)
                    System.out.println("\nEssa idade está incorreta! Insira sua idade real\n");

            } while (idade <= 0 || idade > 160);

            do {

                System.out.print("Digite a altura da pessoa: ");
                altura = leitor.nextFloat();

                if (altura <= 0 || altura > 2.90)
                    System.out.println("\nAltura é inválida! Insira sua altura real\n");

            } while (altura <= 0 || altura > 2.90);

            maisJovem = maisJovem > idade ? idade : maisJovem;
            maisVelha = maisVelha < idade ? idade : maisVelha;
            maiorAltura = maiorAltura < altura ? altura : maiorAltura;
            menorAltura = menorAltura > altura ? altura : menorAltura;
        }

        System.out.print("\033[2J");
        System.out.println("Maior idade: " + maisVelha);
        System.out.println("Menor idade: " + maisJovem);
        System.out.printf("Maior altura: %.2f\n", maiorAltura);
        System.out.printf("Menor altura: %.2f", menorAltura);
    }
}
