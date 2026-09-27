package entidades;

public abstract class Animal 
{
    protected String nome;
    protected String tipo;
    protected String habitat;
    
    public Animal(String nome, String tipo, String habitat)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.habitat= habitat;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public String getTipo()
    {
        return tipo;
    }
    public String getHabitat()
    {
        return habitat;
    }
    
    public abstract String emitirSom();
    
    public String exibirDados()
    {
        return String.format("\nNome: %s\nTipo: %s\nHabitat: %s", nome, tipo, habitat);
    }
}
