package entidade;

public class Circulo extends Figura
{
    private float raio;
    
    public Circulo(String cor, float raio)
    {
       super(cor);
       this.raio = raio;
    }
    
    public float getRaio()
    {
        return raio;
    }
    
    public void setRaio(float raio)
    {
        this.raio = raio;
    }

    @Override
    public float calcularDados()
    {
        float area = (float) (3.14 * Math.pow(raio, 2));
        return area;
    }

    @Override
    public String exibirResultado()
    {
        return "\nO Cirulo de cor " + cor               
               + " e raio de " + String.format ("%.2f", raio)
               + ", tem uma área de " + String.format("%.2f", calcularDados());
    }
}
