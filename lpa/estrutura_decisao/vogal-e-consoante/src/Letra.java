/* 
Descrição  : Ler e verificar se uma letra digitada é vogal ou consoante e imprimir na tela! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 25/02/2024 */

import java.util.Scanner;

public class Letra {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis e configuração de leitor

        char letra;
        String conclusao;
        Scanner leitorChar = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("VERIFICADOR DE LETRA\n");
        System.out.print ("Digite uma letra: ");
        letra = leitorChar.next().charAt(0);

        switch (Character.toUpperCase(letra)) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            conclusao = "É vogal";
                break;
        
            default:
            conclusao = "É consoante";
                break;
        }

        // Tela de resultado

        System.out.println ("\033[2J");
        System.out.println ("VERIFICADOR DE LETRA\n");
        System.out.println ("Letra inserida: " + letra);
        System.out.println ("Conclusão: " + conclusao);

    }
}