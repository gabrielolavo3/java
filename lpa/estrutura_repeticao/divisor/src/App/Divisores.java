package App;
import java.util.Scanner;

public class Divisores 
{
	public static void main(String[] args) 
	{
		int numero, 
			cont = 1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe um número para determinar os seus divisores: ");
		numero = scan.nextInt();
		
		while(cont <= numero) {
			if (numero % cont == 0) {
				System.out.println(cont);
			}
			cont++;
		}
		
		scan.close();
	}
}
