/* 
Descrição  : Ler o valor de 5 compras e imprimir se a Loja A superou o faturamento de R% 54.000,00 da Loja B. Case sim, imprima mensagem e o valor do faturamento! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 16/03/2024 */

import java.util.Scanner;

public class Lucro {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        byte contador;
        float valorDeCompra;
        float valorTotalizado = 0;
        String faturamento = null;
        String conclusao;

        Scanner leitor = new Scanner(System.in);

        // Solicitando dados e verificando

        System.out.println ("LOJAS SAINT ROWS! Sua Loja de Eletrônicos Preferida!");
        System.out.println("Digite os dados necessários...\n");

        for (contador = 1; contador <= 5; contador++) {
            System.out.print ("Informe o valor da compra do " + contador + " º cliente: ");
            valorDeCompra = leitor.nextFloat();

            valorTotalizado+=valorDeCompra;
        }

        if (valorTotalizado > 54000) {
            conclusao = "A Loja A superou o faturamento da Loja B";
            valorTotalizado = valorTotalizado - 54000;
        
        } else if (valorTotalizado < 54000) {
            conclusao = "A Loja A não superou o faturamento da Loja B";
        
        } else {
            conclusao = "A Loja A obteve o mesmo faturamento da Loja B";
        }

        // Tela de resultado

        System.out.print ("\033[2J");
        System.out.println ("LOJAS SAINT ROWS! Analise Semanal de Faturamento!\n");
        System.out.println (conclusao);
        System.out.printf ("O valor obtido foi de R$ %.2f", valorTotalizado);

    }
}
