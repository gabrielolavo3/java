package App;
import java.util.Scanner;

public class Menor 
{
	public static void main(String[] args)
	{
		int menor = Integer.MAX_VALUE,
			valor = 1;
		
		Scanner scan = new Scanner(System.in);
		
		while (valor != 0)
		{
			System.out.print("Insira o número do conjunto: (use 0 para encerrar): ");
			valor = scan.nextInt();
			
			if (valor > 0) {
				menor = valor < menor ? valor : menor;
			}
		}
		
		System.out.println("O menor número do conjunto é " + menor);
		
		scan.close();
	}

}
