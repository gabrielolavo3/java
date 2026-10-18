// Estudantes: Nina Moreira Baggio Vieira e Gabriel Santos Olavo

package br.com.bilheteria.entidades;
import java.time.LocalTime; //trabalha com horário de forma simples, recebendo horas, minutos e/ou segundos e formatando, além de pegar e acrescentar horas

public class Sessao {
    private final String id;
    private final LocalTime horarioInicio;
    private final short capacidadeMaxima;
    private final Filme filme; //associação entre a sessão e o filme
    private short ingressosVendidos;
    private float valorArrecadado;
    private static float precoIntegral = 20f; //atributo estático que vale para todas as instâncias

    public Sessao(String id, Filme filme, LocalTime horarioInicio, short capacidadeMaxima) {
        this.id = !id.isBlank() ? id : "SEM-ID";
        this.filme = filme;
        //Troca o horário caso o paramêtro não seja nulo ou troca para um valor padrão
        this.horarioInicio = horarioInicio != null ? horarioInicio : LocalTime.of(13, 30);//LocalTime.of cria uma horário
        this.capacidadeMaxima = capacidadeMaxima > 0 ? capacidadeMaxima : 50;
        ingressosVendidos = 0;
        valorArrecadado = 0;
    }

    public Sessao(String id, Filme filme, LocalTime horarioInicio) {
        this.id = !id.isBlank() ? id : "SEM-ID";
        this.filme = filme;
        this.horarioInicio = horarioInicio != null ? horarioInicio : LocalTime.of(13, 30);
        capacidadeMaxima = 50;
        ingressosVendidos = 0;
        valorArrecadado = 0;
    }

    public String getId() {
        return id;
    }

    //retorna o objeto Filme associado
    public Filme getFilme() {
        return filme;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public short getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public short getIngressosVendidos() {
        return ingressosVendidos;
    }

    public float getvalorArrecadada() {
        return valorArrecadado;
    }

    public static float getPrecoIntegral() {
        return precoIntegral;
    }

    public static boolean setPrecoIntegral(float novoValor) {
        if (novoValor > 0 && novoValor != precoIntegral) {
            precoIntegral = novoValor;
            return true;
        }
        return false;
    }

    public short assentosDisponiveis() {
        //a conta retorna um Int e precisa fazer conversão explicita para short
        short assentos = (short) (capacidadeMaxima - ingressosVendidos);

        if (assentos < 0) {
            assentos = 0;
        }
        return assentos;
    }

    //plusMinutes adiciona mais minutos a um horário e aumenta o tempo inicial
    public LocalTime horarioTermino() {
        return horarioInicio.plusMinutes(filme.getDuracao());
    }

    private float calculoValorIngresso(float percentual) {
        float desconto = precoIntegral * (percentual / 100);
        return precoIntegral - desconto;
    }

    public float vendaIngresso(byte idade) {
        if (idade < 0) {
            return -1f;
        }

        //usa a referêmcia de filme para acessar o metodo de idade que permite para verificar se o cliente pode ver o filme
        if (filme.idadeMinimaIndicada(idade) == -2) {
            return -2f;
        }

        if (assentosDisponiveis() <= 0) {
            return -3f;
        }

        //faz o cálculo de desconto passando o percentual que deve ser descontato
        float precoFinal = calculoValorIngresso(0);
        ingressosVendidos++;
        valorArrecadado += precoFinal; //acumula o total vendido na sessão
        return precoFinal;
    }

    public float vendaIngresso(byte idade, String documento) {
        if (idade < 0 || (documento == null || documento.isBlank())) {
            return -1f;
        }

        if (filme.idadeMinimaIndicada(idade) == -2) {
            return -2f;
        }

        if (assentosDisponiveis() < 0) {
            return -3f;
        }

        float precoFinal = calculoValorIngresso(50);
        ingressosVendidos++;
        valorArrecadado += precoFinal;
        return precoFinal;
    }
}