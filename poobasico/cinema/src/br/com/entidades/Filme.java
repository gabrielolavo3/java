// Estudantes: Nina Moreira Baggio Vieira e Gabriel Santos Olavo
package br.com.bilheteria.entidades;

public class Filme {
    private final String titulo;
    private final short duracao;
    private final byte classEtaria;
    private String categoria;
    private String sinopse;

    public Filme(String titulo, short duracao, String categoria, byte classEtaria) {
        this.titulo = !titulo.isEmpty() ? titulo : "Desconhecido";
        this.duracao = duracao > 0 ? duracao : 90;
        this.classEtaria = classEtaria <= 0 ? 0 : classEtaria;

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
            this.categoria = "Ação";
        }

        sinopse = "Não informada";
    }

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
        if (!sinopse.isEmpty()) {
            this.sinopse = sinopse;
            return true;
        }
        return false;
    }

    public byte idadeMinimaIndicada(byte idadePessoa) {
        byte acessoLiberado;
        acessoLiberado = (byte) (idadePessoa >= classEtaria ? -1 : -2);
        return acessoLiberado;
    }
}

