package App;
import java.util.Scanner;

public class Fibonacci 
{
	public static void main(String[] args)
	{
		int numAtual = 1,
			numAntecessor = 1,
			resultado,
			limite;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe a quantidade limite de algarismos para a sequência de Fibonacci: ");
		limite = scan.nextInt();
		
		System.out.println(numAtual);
		System.out.println(numAntecessor);
		
		while (limite != 0) {
			/*resultado = numAtual + numAntecessor;
			numAntecessor = resultado;*/
			
			resultado = numAtual + numAntecessor;
			numAntecessor = numAtual;
			numAtual = resultado;
			
			System.out.println(resultado);
			
			limite--;
		}
		
		scan.close();
	}

}
