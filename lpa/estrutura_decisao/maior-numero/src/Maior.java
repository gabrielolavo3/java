/* 
Descrição  : Ler 2 números e verificar e imprima qual é o maior deles! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 24/02/2024 */

import java.util.Scanner;

public class Maior {
    public static void main(String[] args) throws Exception { 
        
        short primeiroValor;
        short segundoValor;
        String resultado;

        Scanner leitorDeValor = new Scanner (System.in);

        System.out.print ("Digite o 1º valor: ");
        primeiroValor = leitorDeValor.nextShort();
        System.out.print ("Digite o 2º valor: ");
        segundoValor = leitorDeValor.nextShort();

        if (primeiroValor > segundoValor) {
            resultado = "O primeiro valor é maior";
        
        } else {
            resultado = "O segundo valor é maior"; }

        System.out.println ("Resultado: " + resultado);

    }
}