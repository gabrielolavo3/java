package br.com.olavo.main;
import br.com.olavo.entidade.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Livro livros = new Livro();
        Biblioteca bibli = new Biblioteca();
        char opcao = ' ';
        short anoDoLivro;
        String tituloLivro,
               autorLivro;

        while (opcao != '0') {
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Exibir lista de livros");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma das opções acima: ");
            opcao = scan.next().charAt(0);
            scan.nextLine();
            System.out.println();

            switch (opcao) {
                case '1':
                    System.out.print("Informe o título do livro: ");
                    tituloLivro = scan.nextLine();
                    System.out.print("Informe o nome do autor do livro: ");
                    autorLivro = scan.nextLine();
                    System.out.print("Informe o ano de publicação: ");
                    anoDoLivro = scan.nextShort();

                    livros.titulo = tituloLivro;
                    livros.autor = autorLivro;
                    livros.anoPublicacao = anoDoLivro;

                    bibli.addLivro(livros);
                    break;
                case '2':
                    if (!bibli.tamanhoLista()) {
                        System.out.println("Não há nenhum livro! Cadastre pelo menos 1");
                    }
                    else {
                        bibli.listaDeLivros();
                    }
                    break;
                case '0':
                    System.out.println("Programa encerrado!");
                    break;
            }
        }
    }
}