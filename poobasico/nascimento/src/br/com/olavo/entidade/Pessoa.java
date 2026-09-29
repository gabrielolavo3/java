package br.com.olavo.entidade;

public class Pessoa {
    private String nome;
    public int diaNascimento;
    public int mesNascimento;
    public int anoNascimento;
    private int idade;

    public Pessoa(String nome, int dia, int mes, int ano) {
        if (nome != null) {
            this.nome = nome;
        }

        if (dia > 0 && dia <= 31) {
            diaNascimento = dia;
        }

        if (mes > 0 && mes <= 12) {
            mesNascimento = mes;
        }

        if (ano > 0) {
            anoNascimento = ano;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void calculaIdade(int diaAtual, int mesAtual, int anoAtual) {
        int idadeAtual;
        idadeAtual = (anoAtual - anoNascimento); //casting de dado

        if (mesAtual < mesNascimento) {
            idadeAtual--; //Caso o mês atual seja menor do que o nascimento, a pessoa não fez aniversário e diminui um ano
        }

        if (diaAtual < diaNascimento) {
            idadeAtual--; //Mesma lógica, diminui um ano da idade caso o dia seja menor
        }

        idade  = idadeAtual;
    }
}
