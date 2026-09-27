package App;
import java.util.Scanner;

public class LocalizarElem 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int[] array = new int[10];
		int cont = 0,
			valorBuscado,
			indice = 0;
		
		while (cont < array.length) {
			System.out.printf("Informe o valor %d: ", cont);
			array[cont] = scan.nextInt();
			
			cont++;
		}
		
		cont = 0;
		
		System.out.print("Informe um valor para realizar a procura dentro do vetor: ");
		valorBuscado = scan.nextInt();
		
		while(cont < array.length) {
			if (array[cont] == valorBuscado) {
				indice = cont;				
			}
			else {
				indice = -1; //necessário para analisar se o número está fora do vetor
			}
			cont++;
		}
		
		if (indice >= 0) {
			System.out.println("Elemento localizado na posição " + indice);
		}
		else {
			System.out.println("Elemento inexistente no vetor");
		}
	}
}
