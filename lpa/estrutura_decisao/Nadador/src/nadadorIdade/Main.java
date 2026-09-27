package nadadorIdade;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int idade;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira a idade do nadador: ");
		idade = sc.nextInt();
		
		if (idade >= 8 && idade <= 10) {
			System.out.println("O nadador pertence a Classe Infantil");
		}
		else if (idade >= 11 && idade <= 13) {
			System.out.println("O nadador pertence a Classe A");
		}
		else if (idade >= 14 && idade <= 17) {
			System.out.println("O nadador pertence a Classe B");
		}
		else if (idade >= 18) {
			System.out.println("O nadador pertence a Classe Adulta");
		}
		else {
			System.out.println("O nadador não pertence a Classe alguma");
		}
	}

}
