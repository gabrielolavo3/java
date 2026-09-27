
package entidade;

public class Bebida extends Pedido
{
    private float valorDoRefrigerante;
    private int quantidadeDeRefrigerante;
    
    public Bebida(int quantidadeDeRefrigerante)
    {   
        valorDoRefrigerante = 5.0f;
        this.quantidadeDeRefrigerante = quantidadeDeRefrigerante;
    }

    @Override
    public float calcularValorTotal() 
    {
        return valorDoRefrigerante * quantidadeDeRefrigerante;
    }

    @Override
    public String exibirPedido() 
    {
         return "\nRefrigerante - R$ " + String.format("%.2f", valorDoRefrigerante) + ": " + quantidadeDeRefrigerante               
               + "\nTotal do Pedido: " + String.format("%.2f", calcularValorTotal());
    }
}
