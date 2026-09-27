package br.com.olavo.entidade;
import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Livro> livros = new ArrayList<>(); //Cria uma lista de Objeto

    public void addLivro(Livro novoLivro) {
        this.livros.add(novoLivro); //Adicionando um livro a lista
        System.out.println("O livro foi adicionado com sucesso!\n");
    }

    public boolean tamanhoLista() {
        boolean haLivro = livros.size() > 0? true : false;
        return  haLivro;

        // livros.size() retorna o tamanho da lista
    }

    public void listaDeLivros() {
        for (int i = 0; i < livros.size(); i++) {
            Livro item = livros.get(i);
            System.out.println("Livro " + (i+1));
            System.out.println(item.exibirDetalhes());

            /* Item é uma variável temporária de acesso para o Objeto
            *  livros.get(i) retorna o elemento da lista na posição atual
            * */
        }
    }
}
