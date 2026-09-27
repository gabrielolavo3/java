/* 
Descrição  : Ler o turno de estudo de um aluno. Use M-matutino, V-vespertino ou N-noturno. No final, imprima a mensagem “Bom dia!”, “Bom vespertino!”, “Boa Noite” ou “Valor inválido”! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 03/03/2024 */

import java.util.Scanner;

public class MensagemTurno {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        char turno;
        String mensagem;
        Scanner leitorChar = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("ONE PLUS - Identificador de turno\n");
        System.out.print ("Digite o seu turno de estudo (M - maturtino, V - vespertino ou N - noturno): ");
        turno = leitorChar.next().charAt(0);

        switch (Character.toUpperCase(turno)) {
            case 'M':
            mensagem = "Prazer em revê-lo. Bom dia!";
                break;
            
            case 'V':
            mensagem = "Seja bem-vindo. Boa tarde!";
                break;

            case 'N':
            mensagem = "Boa noite, estudante";
                break;

            default:
            mensagem = "Seu turno não foi identificado";
                break;
        }

        // Tela de resultado

        System.out.print ("\033[2J");
        System.out.println ("ONE PLUS - Identificador de turno\n");
        System.out.printf (mensagem);

    }
}
