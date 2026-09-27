/* 
Descrição  : Ler e verificar se a letra digitada do sexo é 'F' – Feminino ou 'M' - Masculino. Caso digite a letra errada, o sexo não foi identificado! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 24/02/2024 */

import java.util.Scanner;

public class SexoCerto {
    public static void main(String[] args) throws Exception {
        
        // Declaração de variáveis e configuração de leitor

        char sexo;
        String resultado;
        Scanner leitorChar = new Scanner(System.in);

        // Solicitando dados

        System.out.println ("CARTÓRIO SAN FRANCISCO!\n");
        System.out.print ("Digite o seu sexo (M - masculino ou F - feminino): ");
        sexo = leitorChar.next().charAt(0);

        /* Character.toUpperCase(nomeDaVariavel); --> Transforma um char minúsculo em maiúsculo
            NomeDaVariavel.toUpperCase(); --> Transforma uma única String ou paragráfo/frase de minúsculo para maiúsculo */
        
        if (Character.toUpperCase(sexo) == 'F') {
            resultado = "Feminino";
        
        } else if (Character.toUpperCase(sexo) == 'M') {
            resultado = "Masculino";
        
        } else {
            resultado = "Sexo não identificado!"; }

        // Tela de resultado
        
        System.out.print ("\033[2J");
        System.out.println ("CARTÓRIO SAN FRANCISCO!\n");
        System.out.println ("Conclusão do sexo: " + resultado);
    }
}
