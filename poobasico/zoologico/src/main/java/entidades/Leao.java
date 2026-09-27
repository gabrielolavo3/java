package entidades;

public class Leao extends Animal
{
    public Leao(String nome, String tipo, String habitat)
    {
        super(nome, tipo, habitat);
    }

    @Override
    public String emitirSom()
    {
        return String.format("Roar Roar Roar");
    }
    
    @Override
    public String exibirDados()
    {        
        return String.format("\nNome: %s\nTipo: %s\nHabitat: %s", nome, tipo, habitat);
    }

}
