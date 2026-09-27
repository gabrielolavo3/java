package soma;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		int numeroA;
		int numeroB;
		Scanner sc = new Scanner(System.in); //Chamada de class de leitura de dados
		
		System.out.print("Informe o número A: ");
		numeroA = sc.nextInt();
		System.out.print("Informe o número B: ");
		numeroB = sc.nextInt();
		
		System.out.println("Soma: "+ (numeroA + numeroB));
	}
}
