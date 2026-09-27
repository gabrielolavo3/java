package br.com.olavo.entidade;

public class Livro {
    public String titulo;
    public String autor;
    public short anoPublicacao;

    public String exibirDetalhes() {
        return "Título do livro: " + titulo +
                "\nAutor: " + autor +
                "\nAno de publicação: " + anoPublicacao + "\n";
    }
}
