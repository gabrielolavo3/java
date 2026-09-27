// Descrição: Crir a SuperClass Figura com o atributo de cor e extender para Circulo, Quadrado, Triângulo e Retângulo. Cada Class tem atributos para calcular a área da figura e métodos para calcular e exibição
// Data de implementação: 11.11.24

package com.br.figurasgeometricas;

import entidade.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FigurasGeometricas 
{
    public static void main(String[] args) 
    {
        String cor;
        byte opcao;
        
        Scanner sc = new Scanner(System.in);
        List<Figura> figura = new ArrayList<>();
        
        while(true)
        {
            System.out.println("\nLista de Figuras para Calcular");
            System.out.println("1 - Circulo");
            System.out.println("2 - Quadrado");
            System.out.println("3 - Triângulo");
            System.out.println("4 - Retãngulo");
            System.out.println("5 - Sair e exibir cálculos");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextByte();
            sc.nextLine();
            
            // Lógica para mudar o fluxo do While
            if(opcao == 5 && figura.isEmpty())
            {      
               System.out.println("\nLista vázia! Adicione alguma figura");
               continue;
            }
            
            if(opcao == 5)
            {                
                break;
            }

            System.out.print("\nInforme a cor da figura: ");
            cor = sc.nextLine();

            switch(opcao)
            {
                case 1 ->
                {
                    System.out.print("\nInforme o valor do raio: ");
                    float raio = sc.nextFloat();
                    figura.add(new Circulo(cor, raio));
                }

                case 2 ->
                {
                    System.out.print("\nInforme o valor de um dos lados: ");
                    float lado = sc.nextFloat();
                    figura.add(new Quadrado(cor, lado));
                }

                case 3,4 -> 
                {
                    System.out.print("\nInforme o valor da base: ");
                    float base = sc.nextFloat();
                    System.out.print("Informe o valor da altura: ");
                    float altura = sc.nextFloat();
                    
                    // Operador Ternário | Inicializado Objeto e adicionando ao List
                    figura.add(opcao == 3 ? new Retangulo(cor, base, altura) : new Triangulo(cor, base, altura));
                }
            }
        }
        
        for(Figura figure : figura)
        {
            System.out.println(figure.exibirResultado());
        }
    }
}
