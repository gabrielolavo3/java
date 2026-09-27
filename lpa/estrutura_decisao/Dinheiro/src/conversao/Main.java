package conversao;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		char tipoMoeda;
		float dinheiro, 
			  conversao = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Moedas para Conversão");
		System.out.println("1 - Dólar");
		System.out.println("2 - Libra");
		System.out.println("3 - Peso");
		System.out.print("Selecione a conversão desejada: ");
		tipoMoeda = scan.next().charAt(0);
		System.out.print("Insira o valor para a conversão: ");
		dinheiro = scan.nextFloat();

		switch (tipoMoeda) {
		case '1':
			conversao = dinheiro / 1.87f; // A letra F força o número a ser um float
			break;
		case '2':
			conversao = dinheiro / 3.05f;
			break;
		case '3':
			conversao = dinheiro / 1.40f;
			break;
		default:
			System.out.println("Entrada incorreta de dados!");
			break;
		}
		
		System.out.format("Valor da conversão: %.2f", conversao);

	}

}
