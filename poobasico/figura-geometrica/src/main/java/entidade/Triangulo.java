package entidade;

public class Triangulo extends Figura
{
    private float base;
    private float altura;
    
    public Triangulo(String cor, float base, float altura)
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
        return (base * altura) / 2;
    }
    
    @Override
    public String exibirResultado()
    {
       return "\nO triângulo de cor " + cor
               + " tem base de " + String.format("%.2f", base)
               + " e altura de " + String.format ("%.2f", altura)
               + ", com uma área de " + String.format("%.2f", calcularDados());
    }   
}
