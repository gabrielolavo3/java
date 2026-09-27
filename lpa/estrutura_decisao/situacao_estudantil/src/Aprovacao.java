/* 
Descrição  : Ler duas notas de um aluno e imprimir a situação estudantil: Aprovado - de 7 a 9,99; Aprovado com louvor - 10,00; Reprovado - menos de 7 (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 03/03/2024 */

import java.util.Scanner;

public class Aprovacao {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        float primeiraNota;
        float segundaNota;
        float media;
        String resultado;

        Scanner leitorNota = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("CÓLEGIO SAN PIERRE - Boletim Online\n");
        System.out.print ("Digite a 1ª nota: ");
        primeiraNota = leitorNota.nextFloat();
        System.out.print ("Digite a 2ª nota: ");
        segundaNota = leitorNota.nextFloat();

        media = (primeiraNota + segundaNota) / 2;

        if (media >= 7 && media <= 9.99) {
            resultado = "Aprovado!";
        
        } else if (media == 10) {
            resultado = "Aprovado com louvor!";
        
        } else {
            resultado = "Reprovado!"; 
        }

        // Tela de resultado

        System.out.print ("\033[2J");
        System.out.println ("CÓLEGIO SAN PIERRE - Boletim Online\n");
        System.out.printf ("1ª nota: %.2f\n", primeiraNota);
        System.out.printf ("2ª nota: %.2f\n", segundaNota);
        System.out.printf ("Média: %.2f\n\n", media);
        System.out.print ("Situação estudantil: " + resultado);

    }
}
