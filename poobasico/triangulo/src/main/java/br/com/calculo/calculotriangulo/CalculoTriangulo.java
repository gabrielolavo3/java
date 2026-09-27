// Descrição: Criar uma classe chamada “Triângulo” com atributos para armazenar os três lados do triângulo. Implemente métodos para verificar se é um triângulo válido e calcular sua área.
// Autor: Gabriel S.Olavo
// IDE NetBeans

package br.com.calculo.calculotriangulo;

import elementos.Triangulo;
import java.util.Scanner;

public class CalculoTriangulo {

    public static void main(String[] args) 
    {        
        // Declaração de variáveis Main, Objetos e Instância
        
        float ladoA,
              ladoB,
              ladoC,
              base,
              altura;
        
        Triangulo triangulo = new Triangulo();
        Scanner scan = new Scanner(System.in);
        
        // leitura de dados
        
        System.out.print("Digite o valor do lado A do triângulo: ");
        ladoA = scan.nextFloat();
        System.out.print("Digite o valor do lado B do triângulo: ");
        ladoB = scan.nextFloat();
        System.out.print("Digite o valor do lado C do triângulo: ");
        ladoC = scan.nextFloat();
        
        System.out.print("\nAgora, insira o valor da base: ");
        base = scan.nextFloat();
        System.out.print("Insira o valor da altura: ");
        altura = scan.nextFloat();
        
        scan.close();
        
        // Chamada de métodos da Class
        
        triangulo.receberDados(ladoA, ladoB, ladoC, altura, base);
        System.out.println(triangulo.toString());                
    }
}