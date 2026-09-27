package App;
import java.util.Scanner;

public class Multiplicacao {
	public static void main(String[] args) {
		
		int[] vetor = new int[8]; // array de inteiros
		int multiplicacao = 1,
			contador = 0;
		
		Scanner scan = new Scanner(System.in);
		
		// laço para ler array
		while (contador < vetor.length) {
			System.out.print("Insira o valor do vetor da posição " + contador + ": ");
			vetor[contador] = scan.nextInt();			
			multiplicacao *= vetor[contador];
						
			contador++;
		}
		
		/* laço para resultados (opcional)
	
			contador = 0; // no while, é preciso ZERAR o contador novamente para fazer o acumulo de valores
			
			while (contador < vetor.length) {
				multiplicacao *= vetor[contador];
				contador++;
			}
		*/
		
		System.out.println("Multiplicação do vetor: " + multiplicacao);
		scan.close();
	}
}
