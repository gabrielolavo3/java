package br.com.celular.marcacelular;

import Entidade.Celular;
import java.util.Scanner;

public class MarcaCelular {

    public static void main(String[] args) {
        
        // Declaração de um objetos e instaância
        
        Celular celularSamsung = new Celular();
        Scanner scan = new Scanner(System.in);
        
        // Leitura de dados no Main e envio para os atributos da Class
        
        System.out.print("Digite o nome do modelo do celular: ");
        celularSamsung.nome = scan.nextLine(); // Acessando atributo de Class e lendo pelo teclado
        System.out.print("Digite o SO do celular: ");
        celularSamsung.sistemaOperacional = scan.nextLine();
        System.out.print("Digite o tamanho da tela do celular: ");
        celularSamsung.tamanhoTela = scan.nextFloat();
        System.out.print("Digite o tamanho de armazenamento do celular: ");
        celularSamsung.armazenamento = scan.nextInt();
        
        celularSamsung.fabricante = "Samsung";
        
        System.out.printf("Celular %s, da fabricante %s, com SO %s, tela de %.1f polegadas e armazenamento de %dGB", celularSamsung.nome, celularSamsung.fabricante, celularSamsung.sistemaOperacional, celularSamsung.tamanhoTela, celularSamsung.armazenamento);
    }
}
