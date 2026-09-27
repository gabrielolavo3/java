
package entidade;

public class Comida extends Pedido
{
    private float valorHambuguer;
    private float valorBatataFrita;
    private int quantidadeDeBatataFrita;
    private int quantidadeDeHamburguer;
    
    public Comida(int quantidadeDeBatataFrita, int quantidadeDeHamburguer)
    {        
        valorHambuguer = 20.0f;
        valorBatataFrita = 10.0f;
        this.quantidadeDeBatataFrita = quantidadeDeBatataFrita;
        this.quantidadeDeHamburguer = quantidadeDeHamburguer;
    }        

    @Override
    public float calcularValorTotal() 
    {
        float totalHumburguer = valorHambuguer * quantidadeDeHamburguer,
              totalBatataFrita = valorBatataFrita * quantidadeDeBatataFrita;
        
        return totalHumburguer + totalBatataFrita;        
    }

    @Override
    public String exibirPedido() 
    {              
        return "\nHambúrguer - R$ " + String.format("%.2f", valorHambuguer) + ": " + quantidadeDeHamburguer
               + "\nBatata Frita - R$ " + String.format("%.2f", valorBatataFrita) + ": " + quantidadeDeBatataFrita 
               + "\nTotal do Pedido: " + String.format("%.2f", calcularValorTotal());
    }
}
