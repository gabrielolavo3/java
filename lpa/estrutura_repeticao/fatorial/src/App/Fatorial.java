package App;
import java.util.Scanner;

public class Fatorial 
{
	public static void main(String[] args)
	{
		int fatorial = 1,
			numero,
			cont = 1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe um número para calcular o fatorial: ");
		numero = scan.nextInt();
		
		while (cont <= numero)
		{
			fatorial *= cont;
			cont++;
		}
		
		System.out.format("O fatorial de %d é %d", numero, fatorial);
		
		scan.close();
	}

}
