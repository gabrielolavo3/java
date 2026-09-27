package pares;
import java.util.Scanner;

public class Main {
	public static void main(String arg[]) {
		int numero;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Insira um número inteiro: ");
		numero = scan.nextInt();
		
		if (numero % 2 == 0) {
			System.out.println("Sim, é par");
		}
		else {
			System.out.println("Não, ele é ímpar");
		}
	}
}
