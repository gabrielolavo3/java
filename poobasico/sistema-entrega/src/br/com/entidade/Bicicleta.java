package br.com.entidade;

public class Bicicleta extends Entrega {
    private final float taxa;
    private float precoEntrega;

    public Bicicleta(String nome, double distanciaKm) {
        super(nome, distanciaKm);
        taxa = 5f;
        precoEntrega = 0;
    }

    @Override
    protected float calcularValor() {
        try {
            if (distanciaKm < 4) {
                precoEntrega = (float) (taxa + (distanciaKm * 1));
            }
            else {
                precoEntrega = (float) (taxa + (distanciaKm * 9));
            }
        } catch (Exception e) {
            System.out.println("Os dados para o cálculo não estão corretos: " + e.getMessage());
        }
        return precoEntrega;
    }

    @Override
    public float getValorEntrega() {
        if (precoEntrega == 0) {
            calcularValor();
        }
        return precoEntrega;
    }
}
