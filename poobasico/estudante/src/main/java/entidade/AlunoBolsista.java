package entidade;

public class AlunoBolsista extends Aluno
{
    private int bonusBolsista;
    
    public AlunoBolsista(String nome, String matricula, float primeiraNota, float segundaNota)
    {
        super(nome, matricula, primeiraNota, segundaNota);
        bonusBolsista = 10;
    }
    
    @Override
    public float calcularMedia()
    {
        float media = (primeiraNota + segundaNota) / 2;
              media = media + ((media * bonusBolsista) / 100);
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
