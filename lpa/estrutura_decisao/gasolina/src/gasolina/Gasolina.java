package gasolina;
import java.util.Scanner;

public class Gasolina {
	public static void main(String[] args) {
		float postoA,
			  postoB,
			  postoC,
			  mediaPreco = 0; //Inicialização de variável
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o preço da gasolina do 1º posto de combustivel: ");
		postoA = sc.nextFloat();
		System.out.print("Informe o preço da gasolina do 2º posto de combustivel: ");
		postoB = sc.nextFloat();
		System.out.print("Informe o preço da gasolina do 3º posto de combustivel: ");
		postoC = sc.nextFloat();
		
		mediaPreco = (postoA + postoB + postoC) / 3;
		
		System.out.format("Valor médio: R$ %.2f", mediaPreco);

	}

}
