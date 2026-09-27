package entidade;

public class Retangulo extends Figura
{
    private float base;
    private float altura;
    
    public Retangulo(String cor, float base, float altura)
    {
        super(cor);
        this.base = base;
        this.altura = altura;
    }
    
    public float getBase()
    {
        return base;
    }
    
    public void setBase(float base)
    {
        this.base = base;
    }
    
    public float getAltura()
    {
        return altura;
    }
    
    public void setAltura(float altura)
    {
        this.altura = altura;
    }
    
    @Override
    public float calcularDados()
    {
        return base * altura;
    }
    
    @Override
    public String exibirResultado()
    {
       return "\nO retângulo de cor " + cor
               + " tem base de " + String.format("%.2f", base)
               + " e altura de " + String.format ("%.2f", altura)
               + ", com uma área de " + String.format("%.2f", calcularDados());
    }   
}
