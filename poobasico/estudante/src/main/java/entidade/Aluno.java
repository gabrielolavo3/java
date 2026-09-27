package entidade;

public abstract class Aluno 
{
    protected String nome;
    protected String matricula;
    protected float primeiraNota;
    protected float segundaNota;    
    
    public Aluno(String nome, String matricula, float primeiraNota, float segundaNota)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;        
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getMatricula()
    {
        return matricula;
    }
    
    public float getPrimeiraNota()
    {
        return primeiraNota;
    }
    
    public float getSegundaNota()
    {
        return segundaNota;
    }
    
    public abstract float calcularMedia();   
    public abstract String mostrarInformações();
}
