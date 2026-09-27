package App;
import java.util.Scanner;

public class Primo 
{
	public static void main(String[] args) 
	{
		int numero,
			qtdDivisores = 0,
			cont = 1; 
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		numero = scan.nextInt();
		
		while (cont <= numero) {
			if (numero % cont == 0) { // verifica se o número divido pelo valor atual do contador é um primo
				qtdDivisores++;
			}
			
			cont++; //atualiza o valor do contador
		}
		
		if (qtdDivisores == 2) { // um primo só pode ter 2 divisores
			System.out.printf("O número %d é primo", numero);
		}
		else {
			System.out.printf("O número %d NÃO é primo", numero);
		}
		
	}
}
