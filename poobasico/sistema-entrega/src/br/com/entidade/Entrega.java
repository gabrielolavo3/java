package br.com.entidade;

public abstract class Entrega {
    protected static int contador = 0;
    protected final int codigo;
    protected final String nomeDestinatario;
    protected final double distanciaKm;

    public Entrega(String nome, double distanciaKm) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome do destinatário não pode ser vazio");

        if (distanciaKm <=0)
            throw new IllegalArgumentException("A distância deve ser maior do que 0");

        nomeDestinatario = nome;
        this.distanciaKm = distanciaKm;
        codigo = contador++;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }
    public double getDistanciaKm() {
        return distanciaKm;
    }
    protected abstract float calcularValor();
    public abstract float getValorEntrega();
}
