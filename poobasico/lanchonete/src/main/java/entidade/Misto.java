
package entidade;

public class Misto extends Pedido
{
    private float valorHambuguer;
    private float valorBatataFrita;
    private int quantidadeDeBatataFrita;
    private int quantidadeDeHamburguer;
    private float valorDoRefrigerante;
    private int quantidadeDeRefrigerante;
    
    public Misto(int quantidadeDeBatataFrita, int quantidadeDeHamburguer, int quantidadeDeRefrigerante)
    {
        valorHambuguer = 20.0f;
        valorBatataFrita = 10.0f;
        valorDoRefrigerante = 5.0f;
        this.quantidadeDeHamburguer = quantidadeDeHamburguer;
        this.quantidadeDeBatataFrita = quantidadeDeBatataFrita;
        this.quantidadeDeRefrigerante = quantidadeDeRefrigerante;
    }

    @Override
    public float calcularValorTotal() 
    {
        float totalHumburguer = valorHambuguer * quantidadeDeHamburguer,
              totalBatataFrita = valorBatataFrita * quantidadeDeBatataFrita,
              totalRefrigerante = valorDoRefrigerante * quantidadeDeRefrigerante;
        
        return totalBatataFrita + totalHumburguer + totalRefrigerante;        
    }

    @Override
    public String exibirPedido() 
    {
        return "\nHambúrguer - R$ " + String.format("%.2f", valorHambuguer) + ": " + quantidadeDeHamburguer
               + "\nBatata Frita - R$ " + String.format("%.2f", valorBatataFrita) + ": " + quantidadeDeBatataFrita
               + "\nRefrigerante - R$ " + String.format("%.2f", valorDoRefrigerante) + ": " + quantidadeDeRefrigerante               
               + "\nTotal do Pedido: " + String.format("%.2f", calcularValorTotal());
    }
}
