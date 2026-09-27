package entidade;

public class Quadrado extends Figura
{
    private float lado;
    
    public Quadrado(String cor, float lado)
    {
        super(cor);
        this.lado = lado;
    }
    
    public float getLado()
    {
        return lado;
    }

    @Override
    public float calcularDados() 
    {
        return (float) Math.pow(lado, 2);
    }

    @Override
    public String exibirResultado() 
    {
        return "\nO quadrado de cor " + cor
               + " tem 4 lados com tamanho de " + String.format("%.2f", lado)               
               + ", com uma área de " + String.format("%.2f", calcularDados());
    }
}
