package App;
import java.util.Scanner;

public class Intervalo 
{
	public static void main(String[] arg)
	{
		int intervaloA, 
			intervaloB,
			soma = 0,
			contador;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe um valor para o início do intervalo: ");
		intervaloA = scan.nextInt();
		System.out.print("Informe um valor para o fim do intervalo: ");
		intervaloB = scan.nextInt();
		
		contador = intervaloA;
		while (contador <= intervaloB) {						
			
			if (contador % 2 != 0) {
				soma+=contador; // soma o contador quando ele for ímpar
			}
			
			contador++;
		}
		
		System.out.println("Soma dos ímpares: " + soma);
	}
}
