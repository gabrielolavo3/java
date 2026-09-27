/* 
Descrição  : Ler valor e imprimir se é positivo ou negativo! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 24/02/2024 */

import java.util.Scanner;

public class TipoDeNumero {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        int valor;
        String resultado = null;

        Scanner leitorInt = new Scanner (System.in);

        // Solicitando dados

        System.out.print ("Digite um valor: ");
        valor = leitorInt.nextInt();

        if (valor > 0) {
            resultado = "O número é positivo";

        } else if (valor < 0) {
            resultado = "O número é negativo"; }

        // Tela de resultado
        
        System.out.print ("\033[2J");
        System.out.println ("VERIFICADOR DE NÚMERO\n");
        System.out.println ("Valor inserido: " + valor);
        System.out.println ("Conclusão: " + resultado);

    }
}
