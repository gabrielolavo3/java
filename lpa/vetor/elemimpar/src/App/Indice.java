package App;
import java.util.Scanner;

public class Indice 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		
		for (int a = 0; a < numeros.length; a++) 
		{
			System.out.printf("Insira o valor da posição %d do vetor: ", a);
			numeros[a] = scan.nextInt();
		}
		
		//laço para imprimir a posição dos elementos ímpares
		for (int a = 0; a < numeros.length; a++) 
		{
			if (numeros[a] % 2 != 0) {
				System.out.printf("Valor %d no índice %d\n", numeros[a], a);
			}
		}
		
		scan.close();
	}
}
