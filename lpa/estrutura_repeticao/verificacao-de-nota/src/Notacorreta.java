/* 
Descrição  : Ler 3 notas aluno e imprimir a média e a situação escolar. Caso a nota seja menor que 0 e maior do que 10, repita a pergunta e a aprovação é de
7 ou acima, recuperação é entre 5 e abaixo de 7, a reprovação é abaixo de 7! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 21/03/2024 */

import java.util.Scanner;

public class Notacorreta {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        int contador;
        float nota = 0;
        float somaNotas = 0;
        float media = 0;
        String situacao;

        Scanner leitor = new Scanner(System.in);

        // Solicitando dados

        System.out.println("COLÉGIO ZHAO - Consulta de média de semestre\n");
        
        for (contador = 0; contador < 3; contador++) {
            System.out.printf("Digite a %dª nota: ", contador + 1);
            nota = leitor.nextFloat();

            while (nota < 0 || nota > 10) {
                System.out.println("\nNota incorreta! A nota deve ser entre 0 e 10\n");
                System.out.printf("Digite a %dª nota: ", contador + 1);
                nota = leitor.nextFloat();
            }
            somaNotas += nota;
        }

        media = somaNotas / (float)contador;

        if (media >= 7) {
            situacao = "Aprovado";
        
        } else if (media >= 5 && media <= 6.9) {
            situacao = "Recuperação";
        
        } else {
            situacao = "Reprovado";
        }

        // Tela de resultado

        System.out.print("\033[2J");
        System.out.println("COLÉGIO ZHAO - Conclusão da consulta\n");
        System.out.printf("Média: %.2f\n", media);
        System.err.println(situacao);
        
    }
}
