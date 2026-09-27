package App;
import java.util.Scanner;

public class Pesquisa 
{
	public static void main(String[] args)
	{
		byte idade;
		int qtdMulheres = 0,
			qtdHomens = 0,
			qtdServico = 0,
			totalPessoas = 0,
			perceServicos;
		char sexo,
			 codigo = '1';
		
		Scanner scan = new Scanner(System.in);
		
		while (codigo != '5')
		{
			System.out.println("Objetivos de Ida");
			System.out.println("1 - Compras");
			System.out.println("2 - Serviços(banco, correio, etc)");
			System.out.println("3 - Lazer(cinema, jogos, etc)");
			System.out.println("4 - Alimentação(restaurantes e lanchonetes)");
			System.out.println("5 - Sair e encerrar programa");
			
			System.out.print("\nSelecione uma das opções acima: ");
			codigo = scan.next().charAt(0);
			
			if (codigo != '5') {
				System.out.print("Informe a idade do entrevistado: ");
				idade = scan.nextByte();
				System.out.print("Informe o sexo do entrevistado | (f)eminino ou (m)asculino: ");
				sexo = scan.next().charAt(0);
				
				if (codigo == '2') {
					qtdServico++;
				}
				
				if (sexo == 'f') {
					qtdMulheres++;
				}
				else {
					qtdHomens++;
				}
				
				totalPessoas++;
			}
		}
		
		perceServicos = (qtdServico * 100) / totalPessoas;
		
		System.out.print("Percentual de pessoas que buscam serviços: " + perceServicos);
		
		if (qtdMulheres > qtdHomens) {
			System.out.println("Gênero que mais frequenta o shopping: Mulher");
		}
		else {
			System.out.println("Gênero que mais frequenta o shopping: Homem");
		}
	}

}
