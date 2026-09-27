package App;
import java.util.Scanner;

public class Tabuada 
{
	public static void main(String[] arg) 
	{
		int numero;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Insira um número para visualizar a sua tabuada: ");
		numero = scan.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			//System.out.println(numero + "x" + i + "=" + (numero * i));
			System.out.format("%d x %d = %d\n", numero, i, (numero * i));
		}
		
	}
}