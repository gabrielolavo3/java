package br.com.mediadealuno;

import entidade.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediaDeAluno 
{
    public static void main(String[] args) 
    {
        String nome,
               matricula;
        float primeiraNota,
              segundaNota;
        
        Scanner sc = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        
        while (true)
        {
            System.out.print("\nInforme o nome do aluno: ");
            nome = sc.nextLine();
            System.out.print("Informe o número de matricula do aluno: ");
            matricula = sc.nextLine();
            System.out.print("Informe a primeira nota: ");
            primeiraNota = sc.nextFloat();
            System.out.print("Informe a segunda nota: : ");
            segundaNota = sc.nextFloat();
            System.out.print("\nO estudante é bolsista ou pagante (B/P): ");
            char tipoDeAluno = sc.next().charAt(0);
            sc.nextLine();
            
            if (tipoDeAluno == 'B' || tipoDeAluno == 'b')
            {
                AlunoBolsista bolsista = new AlunoBolsista(nome, matricula, primeiraNota, segundaNota);
                alunos.add(bolsista);
            }
            else
            {
                alunos.add(new AlunoPagante(nome, matricula, primeiraNota, segundaNota));
            }
            
            System.out.print("Deseja inserir mais um estudante (Sim/Não): ");
            String novoCadastroDeEstudante = sc.nextLine();
            
            if (novoCadastroDeEstudante.equalsIgnoreCase("Não"))
            {
                break;
            } 
            else if (novoCadastroDeEstudante.equalsIgnoreCase("Sim"))
            {
                continue;
            }            
        }
        
        System.out.println("\nResumo dos Cadastro de Estudantes da Unidade III");
        for (int a = 0; a < alunos.size(); a++)
        {
            System.out.println(alunos.get(a).mostrarInformações());
        }
    }
}
