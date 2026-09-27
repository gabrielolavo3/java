package entidade;

public class AlunoPagante extends Aluno
{
    public AlunoPagante(String nome, String matricula, float primeiraNota, float segundaNota)
    {
        super(nome, matricula, primeiraNota, segundaNota);
    }
    
    @Override
    public float calcularMedia()
    {
        float media = (primeiraNota + segundaNota) / 2;
        return media;
    }
    
    @Override
    public String mostrarInformações()
    {
        return "\nNome do aluno: " + nome
                + "\nNúmero de matricula: " + matricula
                + "\nPrimeira nota: " + String.format("%.2f", primeiraNota)
                + "\nSegunda nota: " + String.format("%.2f", segundaNota)
                + "\nMédia: " + String.format("%.2f", calcularMedia());
    }    
}
