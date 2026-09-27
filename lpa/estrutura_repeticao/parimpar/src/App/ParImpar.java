package App;
import java.util.Scanner;

public class ParImpar 
{
	public static void main(String[] arg) 
	{
		int valor = 0,
			contVar = 0,
			somaPar = 0,
			somaImpar = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while (valor != -1) 
		{
			System.out.print("Informe o valor " + (contVar + 1) + " (use -1 para encerrar): ");
			valor = sc.nextInt();
			
			if (valor > 0) {
				if (valor % 2 == 0) {
					somaPar++; // soma os valores
				}
				else {
					somaImpar++;
				}
			}			
			
			contVar++;
		}
		
		System.out.println("Quantidade de pares: " + somaPar);
		System.out.println("Quantidade de ímpares: " + somaImpar);
	}
}
