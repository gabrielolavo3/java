// Estudantes: Nina Moreira Baggio Vieira e Gabriel Santos Olavo
package br.com.bilheteria.entidades;
import java.time.LocalTime;

public class Sessao {
    private final String id;
    private final LocalTime horarioInicio;
    private final short capacidadeMaxima;
    private final Filme filme;
    private short ingressosVendidos;
    private float valorArrecadado;
    private static float precoIntegral = 20f;

    public Sessao(String id, Filme filme, LocalTime horarioInicio, short capacidadeMaxima) {
        this.id = !id.isBlank() ? id : "SEM-ID";
        this.filme = filme;
        this.horarioInicio = horarioInicio != null ? horarioInicio : LocalTime.of(13, 30);
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
        short assentos = (short) (capacidadeMaxima - ingressosVendidos);

        if (assentos < 0) {
            assentos = 0;
        }
        return assentos;
    }

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

        if (filme.idadeMinimaIndicada(idade) == -2) {
            return -2f;
        }

        if (assentosDisponiveis() <= 0) {
            return -3f;
        }

        float precoFinal = calculoValorIngresso(0);
        ingressosVendidos++;
        valorArrecadado += precoFinal;
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
