// Devs: Camile Oliveira e Gabriel Olavo
// Data de implemantação: 29.10.24

package com.br.zooaplication;

import entidades.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ZooAplication 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Animal> animais = new ArrayList<>();
        
        while (true)
        {
            System.out.println("\nAnimais Disponíveis para Cadastro");
            System.out.println("1 - Leão");
            System.out.println("2 - Elefante");
            System.out.println("3 - Papagaio");
            System.out.println("4 - Sair e exibir dados");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt(); 
            sc.nextLine();

            if (opcao < 1 || opcao > 4)
            {
                System.out.println("\nOpçao inválida! Selecione uma das opções do menu");
                continue;
            }
            else if (animais.isEmpty() == true && opcao == 4)
            {
                // Condição para retornar pro ínicio do laço, caso tente acessar os dados e o ArrayList esteja vazio
                System.out.println("\nPor favor, selecione um animal antes de visualizar a lista atualizada");
                continue;
            } 
            else if (opcao == 4)
            {
               break;
            }
            else 
            {            
                System.out.println("\nCadastre um novo animal!");
                System.out.print("Digite o nome: ");
                String nome = sc.nextLine();

                System.out.print("Digite o tipo do animal: ");
                String tipo = sc.nextLine();

                System.out.print("Digite qual é o habitat do animal: ");
                String habitat = sc.nextLine();

                // Passando as informações para o ArrayList

                switch (opcao)
                {
                    case 1 -> animais.add (new Leao(nome, tipo, habitat));               
                    case 2 -> animais.add (new Elefante(nome, tipo, habitat));                
                    case 3 -> animais.add (new Papagaio(nome, tipo, habitat)); 
                    case 4 -> System.out.println("Carregando lista atualizada");                                                           
                }
            }
            
            // Lógica para interromper ou reiniciar o laço, conforme cadastro
            
            System.out.print("\nDeseja cadastrar outro animal (Sim/ Não): ");
            String cadastro = sc.nextLine();

            if (cadastro.equalsIgnoreCase("Sim"))
            {
                continue;

            } 
            else if (cadastro.equalsIgnoreCase("Não"))
            {
                break;
            }            
        } 

         System.out.println("\nLista de Animais Cadastrados");
         for (Animal anim : animais)
         {
             System.out.println(anim.exibirDados());
             System.out.println(anim.emitirSom());
         }
    }
}
