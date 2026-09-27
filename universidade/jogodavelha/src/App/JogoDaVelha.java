package App;
import java.util.Scanner;

public class JogoDaVelha {		
	public static void impressao(char[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[0].length; j++) {
				System.out.print("|" + tabuleiro[i][j] + "|"); //Imprimi conteúdo da matriz
			}
			System.out.println();
		}
	}
	
	public static char trocarJogador(char jogador) {
		if (jogador == 'X') {
			jogador = 'O';
		}
		else {
			jogador = 'X';
		}
		
		return jogador;
	}
	
	public static boolean jogadas(char jogador, char[][] tabuleiro, int linha, int coluna) {
		
		/* Se as linhas e colunas estiverem dentro do limite e a posição estiver vázia,
		 * a posição recebe o simbolo do jogador 
		*/
		if ((linha >= 0 && linha < 3) && (coluna >= 0 && coluna < 3) && tabuleiro[linha][coluna] == ' ') {
			tabuleiro[linha][coluna] = jogador;
			
			return true;
		}
		
		return false;
	}
	
	public static boolean vitoria (char[][] tabuleiro, char jogador) {
		// vitória por linha
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
				System.out.println("O jogador " + jogador + " venceu a partida");
				return true;
			}
		}
		
		// vitória por coluna
		for (int i = 0; i < tabuleiro[0].length; i++) {
			if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
				System.out.println("O jogador " + jogador + " venceu a partida");
				return true;
			}
		}
		
		// vitória por diagonal principal
		if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
			System.out.println("O jogador " + jogador + " venceu a partida!");
			return true;
		}
        
		// vitória por diagonal secundária
		if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
			System.out.println("O jogador " + jogador + " venceu a partida!");
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char jogador = 'X';
		boolean jogoAtivo = true;		
		int linha = 0, coluna = 0, qtdRodadas = 0;
		
		char[][] jogo = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};
		//Laço infinito, é o começo do laço			
		while (jogoAtivo) {
			impressao(jogo);
			System.out.println("\nÉ a vez do Jogador " + jogador);
			System.out.print("Escolha uma linha: ");
			linha = scan.nextInt();
			System.out.print("Escolha uma coluna: ");
			coluna = scan.nextInt();

			//Verifica se o número da linha ou coluna digitada estar dentro do limite da matriz do jogo
			if ((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2)) {
				System.out.println("Tente de novo");
				continue; //Ignora a próxima instrução
			}

			//Verifica se o espaço escolhido está preenchido. Se sim, ignora a próxima instrução e volta para o começo do loop
			if (jogo[linha][coluna] != ' ') {
				System.out.println("\nEssa posição está preeenchida");
				continue;
			}
			
			if (jogadas(jogador, jogo, linha, coluna)) {
				qtdRodadas++;//Acumula a quantidade de rodadas
				
				if (vitoria(jogo, jogador)) {
					impressao(jogo);
					jogoAtivo = false; //Em caso de vitória, interrompe o loop, assim, encerrando o jogo
				}
				else if (qtdRodadas == 9) { //Verificar se houve 9 rodadas para aplicar um empate
					impressao(jogo);
					System.out.println("Houve um empate! DEU VELHA");
					jogoAtivo = false;
				}
				else {
					jogador = trocarJogador(jogador); //Caso não haja vitória nem empate, faz a troca do jogador
				}
			}
		}
	}

}
