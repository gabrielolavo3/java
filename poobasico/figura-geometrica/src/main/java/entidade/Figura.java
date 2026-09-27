package entidade;

public abstract class Figura 
{
    protected String cor;
    
    public Figura(String cor)
    {
        this.cor = cor;
    }
    
    public String getCor()
    {
        return cor;
    }
    
    public void setCor(String cor)
    {
        this.cor = cor;
    }
    
    public abstract float calcularDados();
    public abstract String exibirResultado();
}
