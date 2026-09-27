package App;
import java.util.Scanner;

public class SomaVetor {
	public static final int MAXIMO = 8; // constante
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int[] vetorA = new int[MAXIMO];
		int[] vetorB = new int[MAXIMO];
		int[] vetorC = new int[MAXIMO];
		int cont = 0;
		
		while (cont < MAXIMO) {
			System.out.print("Informe o valor do vetorA: ");
			vetorA[cont] = scan.nextInt();
			
			cont++;
		}
		
		cont = 0;
		
		System.out.println("");
		while (cont < MAXIMO) {
			System.out.print("Informe o valor do vetorB: ");
			vetorB[cont] = scan.nextInt();
			
			cont++;
		}
		
		cont = 0;
		
		System.out.println("\nElementos do VetorC");
		while (cont < MAXIMO) {
			int soma = vetorA[cont] + vetorB[cont];
			vetorC[cont] = soma;
			System.out.println(vetorC[cont]);			
			cont++;
		}
		
		scan.close();
	}
}
