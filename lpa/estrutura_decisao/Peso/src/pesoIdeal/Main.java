package pesoIdeal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		char sexo;
		double altura,
			   pesoIdeal;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe a altura do entrevistado: ");
		altura = sc.nextFloat();
		System.out.print("Informe o sexo do entrevistado | (f)eminino ou (m)asculino: ");
		sexo = sc.next().charAt(0); // Leitura de caractere, pega o índice 0			
		
		if (sexo == 'f') { // Comparação de caractere com aspas simples
			pesoIdeal = (62.1 * altura) - 44.7;
		}
		else {
			pesoIdeal = (72.7 * altura) - 44.7;
		}
		
		System.out.format("Peso ideal: %.2f", pesoIdeal);

	}

}
