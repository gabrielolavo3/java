package br.com.olavo.main;
import br.com.olavo.entidade.Pessoa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dia,
            mes,
            ano;

        Pessoa einstein = new Pessoa("Albert Einstein", 14, 3, 1879);
        Pessoa newton = new Pessoa("Isaac Newton", 4, 1, 1643);

        System.out.print("Informe a data de hoje (d/mm/aaaa): ");
        dia = scan.nextInt();
        mes = scan.nextInt();
        ano = scan.nextInt();

        einstein.calculaIdade(dia, mes, ano);
        newton.calculaIdade(dia, mes, ano);

        System.out.println("Caso estivesse vivo, " + einstein.getNome() + " teria " + einstein.getIdade() + " anos");
        System.out.println(newton.getNome() + " teria " + newton.getIdade() + " anos hoje");
    }
}
