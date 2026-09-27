/* 
Descrição  : Ler o valor de 3 produtos e imprimir o valor do melhor produto para comprar, sende este o de menor valor entre os 3! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 25/02/2024 */

import java.util.Scanner;

public class Compra {
    public static void main(String[] args) throws Exception {

        // Declaração de variáveis

        float primeiroProduto;
        float segundoProduto;
        float terceiroProduto;
        float escolhaFinal;

        Scanner compra = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("ONE - REDUTOR DE DESPESAS\n");
        System.out.print ("Digite o valor do 1º produto: ");
        primeiroProduto = compra.nextFloat();
        System.out.print ("Digite o valor do 2º produto: ");
        terceiroProduto = compra.nextFloat();
        System.out.print ("Digite o valor do 3º produto: ");
        segundoProduto = compra.nextFloat();

        escolhaFinal = (primeiroProduto < segundoProduto) ? primeiroProduto : segundoProduto;
        escolhaFinal = (escolhaFinal < terceiroProduto) ? escolhaFinal : terceiroProduto;

        // Tela de resultado

        System.out.print ("\033[2J");
        System.out.println ("ONE - REDUTOR DE DESPESAS\n");
        System.out.println ("Conclusão: A compra a ser realizada é pelo produto com o valor de R$ " + escolhaFinal);
    }
}
