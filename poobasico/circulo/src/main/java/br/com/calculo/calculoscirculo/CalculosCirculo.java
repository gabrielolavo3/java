// Descrição: Criar uma classe chamada “Círculo” que possua um atributo para armazenar o raio e métodos para calcular a área e o perímetro do círculo.
// Autor: Gabriel S. Olavo
// IDE NetBeans

package br.com.calculo.calculoscirculo;

import java.util.Scanner;
import formaGeometrica.Circulo;

public class CalculosCirculo {

    public static void main(String[] args) {
        
        // Declaração de objetos, instância e variáveis
        
        float valorArea;
        Circulo circulo = new Circulo();
        Scanner scan = new Scanner(System.in);               
 
        // Leitura de dados
        
        System.out.print("Digite o tamanho da área do círculo, em metros: ");
        valorArea = scan.nextFloat();
        circulo.inserirRaio(valorArea);
        
        System.out.println(circulo.toString());
    }
}
