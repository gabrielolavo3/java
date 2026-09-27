
package com.br.lanchonete;
import entidade.*;
import java.util.*;

public class Lanchonete 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        
        while(true)
        {
            System.out.println("\nLista de Tipos de Pedidos");
            System.out.println("1 - Comida");
            System.out.println("2 - Bebida");
            System.out.println("3 - Compra mista");
            System.out.print("Escolha uma opçao de compra: ");
            byte opcao = sc.nextByte();
            sc.nextLine();
            
            switch(opcao)
            {
                case 1 -> 
                {
                    System.out.println("\nLista de Produtos do Menu Comida");
                    System.out.println("1 - Batata Frita");
                    System.out.println("2 - Hambúrguer");
                    System.out.println("\nDigite a quantidade que deseja para cada item");
                    
                    System.out.print("\nInforme a quantidade hamburgueres: ");
                    int quantidadeDeHamburguer = sc.nextInt();
                    System.out.print("Informe a quantidade batata frita: ");
                    int quantidadeDeBatataFrita = sc.nextInt();
                    
                    pedidos.add(new Comida(quantidadeDeBatataFrita, quantidadeDeHamburguer));
                }
                
                case 2 -> 
                {
                    System.out.println("\nLista de Produtos do Menu Bebida");
                    System.out.println("1 - Refrigerante");                    
                    System.out.println("\nDigite a quantidade que deseja");
                    
                    System.out.print("\nInforme a quantidade refrigerante: ");
                    int quantidadeDeRefrigerante = sc.nextInt();
                    
                    pedidos.add(new Bebida(quantidadeDeRefrigerante));
                }
                
                case 3 -> 
                {
                    System.out.println("\nLista de Produtos do Menu Misto");
                    System.out.println("1 - Batata Frita");
                    System.out.println("2 - Hambúrguer");
                    System.out.println("3 - Refrigerante");
                    System.out.println("\nDigite a quantidade que deseja para cada item");
                    
                    System.out.print("\nInforme a quantidade hamburgueres: ");
                    int quantidadeDeHamburguer = sc.nextInt();
                    System.out.print("Informe a quantidade batata frita: ");
                    int quantidadeDeBatataFrita = sc.nextInt();
                    System.out.print("Informe a quantidade refrigerante: ");
                    int quantidadeDeRefrigerante = sc.nextInt();
                    
                    pedidos.add(new Misto(quantidadeDeBatataFrita, quantidadeDeHamburguer, quantidadeDeRefrigerante));
                }
            }
            
            sc.nextLine();
            System.out.println("\nDeseja realizar outro pedido (Sim/Não): ");
            String novoPedido = sc.nextLine();
            
            if (novoPedido.equalsIgnoreCase("Sim"))
            {
                continue;
            } 
            else 
            {
                break;
            }
        }
        
        for (Pedido pedi : pedidos) 
        {
            System.out.println(pedi.exibirPedido());
        }
    }
}
