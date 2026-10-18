// Estudantes: Nina Moreira Baggio Vieira e Gabriel Santos Olavo

package br.com.bilheteria.entidades;

public class Filme {
    private final String titulo; //final transforma em constante e não permite mudanças após atribuição de valor
    private final short duracao; //short é usado pq raramente um filme chegará ao limite de 32mil
    private final byte classEtaria; //como as classificações vão de 0 até 18, o byte ocupa menos espaço na memória por ir até 127
    private String categoria;
    private String sinopse;

    public Filme(String titulo, short duracao, String categoria, byte classEtaria) {
        //condicionais ternárias para os paramêtros
        this.titulo = !titulo.isEmpty() ? titulo : "Desconhecido";
        this.duracao = duracao > 0 ? duracao : 90;
        this.classEtaria = classEtaria <= 0 ? 0 : classEtaria;

        //caso o paramêtro não estja vázio e seja igual - ignorando as letras maiúsculas e minúsculas - às Strings informadas, há a mudança
        if (!categoria.isEmpty()
                && (categoria.equalsIgnoreCase("Aventura")
                || categoria.equalsIgnoreCase("Ação")
                || categoria.equalsIgnoreCase("Comédia")
                || categoria.equalsIgnoreCase("Drama")
                || categoria.equalsIgnoreCase("Terror")))
        {
            this.categoria = categoria;
        }
        else {
            this.categoria = "Ação"; //valor padrão caso não atenda ao if
        }

        sinopse = "Não informada"; //iniciação de atributo
    }

    //sobrecarga de construtor
    public Filme(String titulo, short duracao) {
        this.titulo = !titulo.isEmpty() ? titulo : "Desconhecido";
        this.duracao = duracao > 0 ? duracao : 90;
        classEtaria = 0;
        categoria = "Ação";
        sinopse = "Não informada";
    }

    public String getTitulo() {
        return titulo;
    }

    public short getDuracao() {
        return duracao;
    }

    public byte getClassEtaria() {
        return classEtaria;
    }

    public String getCategoria () {
        return categoria;
    }

    public boolean setCategoria(String categoria) {
        //caso o paramêtro não seja vazio e igual - ignorando minúsculas e maiúsculas - às palavras aceitas, há a troca
        if (!categoria.isEmpty()
                && (categoria.equalsIgnoreCase("Aventura")
                || categoria.equalsIgnoreCase("Ação")
                || categoria.equalsIgnoreCase("Comédia")
                || categoria.equalsIgnoreCase("Drama")
                || categoria.equalsIgnoreCase("Terror")))
        {
            this.categoria = categoria;
            return true;
        }
        return false;
    }

    public String getSinopse() {
        return sinopse;
    }

    public boolean setSinopse(String sinopse) {
        //caso a sinopse não esteja vázia, há a troca
        if (!sinopse.isEmpty()) {
            this.sinopse = sinopse;
            return true;
        }
        return false;
    }

    public byte idadeMinimaIndicada(byte idadePessoa) {
        byte acessoLiberado;
        acessoLiberado = (byte) (idadePessoa >= classEtaria ? -1 : -2); //a conta retorna um Int e precisa fazer conversão explicita para byte
        //caso a idade seja compatível com o filme, retorna -1. Senão retorna -2
        return acessoLiberado;
    }
}
