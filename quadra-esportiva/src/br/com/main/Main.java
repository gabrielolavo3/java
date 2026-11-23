package br.com.main;
import br.com.entidades.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
	static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws OperacaoQuadraException {		
		Quadra tenis = new QuadraTenis("FX07", (short) 4);
		Quadra futsal = new QuadraFutsal("12aD", (short) 10);
		Quadra tenis2 = new QuadraTenis("g67tr", (short) 2);
		Quadra volei = new QuadraVolei("poo15", (short) 12);
		Quadra refQuadra = null;
		ArrayList<Quadra> quadrasEsportiva = new ArrayList<Quadra>();
		quadrasEsportiva.add(tenis);
		quadrasEsportiva.add(futsal);
		quadrasEsportiva.add(tenis2);
		quadrasEsportiva.add(volei);
		
		gerenciamentoQuadras(quadrasEsportiva);			
	}
	
	public static void gerenciamentoQuadras(ArrayList<Quadra> listaQuadra) throws OperacaoQuadraException {			
		byte loopControle;	
		Quadra quadraSelecionada = null;
		
		do {
			menu();
			loopControle = scan.nextByte();
			quadraSelecionada = triagemQuadra(listaQuadra);
			
			switch(loopControle) {
				case 1 -> {
					try {
						System.out.print("Informe quantos jogadores usarão a quadra: ");
						short pessoas = scan.nextShort();
						quadraSelecionada.entrada(pessoas);
					} 
					catch (InputMismatchException e) {
						System.out.println("Não é possível usar letras neste campo. Use apenas números.");
					}
					catch (OperacaoQuadraException e) {
						System.out.println(e.getMessage());
					}
				}
				case 2 -> {
					try {
						System.out.print("Informe quantos jogadores deixarão a quadra: ");
						short pessoas = scan.nextShort();
						quadraSelecionada.saida(pessoas);
					} 
					catch (InputMismatchException e) {
						System.out.println("Não é possível usar letras neste campo. Use apenas números.");
					}
					catch (OperacaoQuadraException e) {
						System.out.println(e.getMessage());
					}
				}
				case 3 -> {
					quadraSelecionada.liberarQuadra();
					System.out.printf("A quadra %s foi esvaziada com sucesso\n", quadraSelecionada.getId());
				}
				case 4 -> {
					System.out.println("ID: " + quadraSelecionada.getId());
					System.out.println("Capacidae máxima: " + quadraSelecionada.getCapacMax());
					System.out.println("Jogadores em campo: " + quadraSelecionada.getJogadoresEmQuadra());					
					System.out.println("Vagas disponíveis: " + quadraSelecionada.vagasLivres());
					System.out.println("Taxa de ocupação: " + quadraSelecionada.calculoTaxa());					
					System.out.println("Total de jogadores que usaram a quadra: " + quadraSelecionada.getTotalJogadores());
				}
				case 5 -> {
					try {
						if (quadraSelecionada instanceof QuadraFutsal) {
							((QuadraFutsal) quadraSelecionada).ligarIluminacao();
							System.out.println("A iluminação foi acesa");
						}
					} 
					catch (OperacaoQuadraException e) {
						System.out.println(e.getMessage());
					}
				}
				case 6 -> {
					try {
						if (quadraSelecionada instanceof QuadraFutsal) {
							((QuadraFutsal) quadraSelecionada).desligarIluminacao();
							System.out.println("A iluminação foi desligada");
						}
					} 
					catch (OperacaoQuadraException e) {
						System.out.println(e.getMessage());
					}
				}
				case 7 -> {
					
				}
				case 8 -> {
					try {
						if (quadraSelecionada instanceof QuadraVolei) {
							((QuadraVolei) quadraSelecionada).zerarPlacar();
							System.out.println("O placar foi alterado e zerado com sucesso");
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				case 9 -> {
					try {
						System.out.print("Informe o novo tempo máximo de reserva: ");
						short tempo = scan.nextShort();
						Quadra.setTempoReserva(tempo);
					} 
					catch (InputMismatchException e) {
						System.out.println("Não é possível usar letras neste campo. Use apenas números.");
					}
					catch (OperacaoQuadraException e) {
						System.out.println(e.getMessage());
					}
				}
				case 10 -> {
					System.out.println("Tempo máximo de reserva: " + Quadra.getTempoReserva());
					System.out.println("Total de quadras: " + Quadra.getTotalQuadras());
				}
				case 11 -> {
					for (Quadra quadras : listaQuadra) {
						System.out.println("ID: " + quadras.getId());
						System.out.println("Capacidae máxima: " + quadras.getCapacMax());
						System.out.println("Jogadores em campo: " + quadras.getJogadoresEmQuadra());					
						System.out.println("Vagas disponíveis: " + quadras.vagasLivres());
						System.out.println("Taxa de ocupação: " + quadras.calculoTaxa());
						System.out.println("Status de ocupação: " + quadras.lotacao());
						System.out.println("Total de jogadores que usaram a quadra: " + quadras.getTotalJogadores());
					}
				}
				case 0 -> {
					System.out.println("O programa foi encerrado");
				}
				default -> System.out.println("Opção de menu escolhida incorretamente");
			}
						
		} while (loopControle != 0);				
	}
	
	public static Quadra triagemQuadra(ArrayList<Quadra> listaQuadra) {
		Quadra refQuadra = null;
		
		for (Quadra quadras : listaQuadra) {
			int index = 1;
			System.out.printf("%d - Quadra %s", index, quadras.getId());
			index++;
		}
		
		try {
			System.out.print("Escolha o código de uma quadra: ");
			int codQuadra = scan.nextInt();
			
			if (codQuadra < 1 || codQuadra > listaQuadra.size()) {
				System.out.println("O código selecionado é inválido");
			}
			else {
				refQuadra = listaQuadra.get(codQuadra - 1);
			}
		} 
		catch (InputMismatchException e) {
			System.out.println("O código é aceito somente como caractere númerico");
			scan.nextLine();
		}
		
		return refQuadra;
	}
	
	public static void menu() {
		System.out.println("1 - Registrar entrada");
		System.out.println("2 - Registrar saída");
		System.out.println("3 - Liberar a quadra");
		System.out.println("4 - Consultar uma quadra");
		System.out.println("5 - Acender a iluminação");
		System.out.println("6 - Apagar a iluminação");
		System.out.println("7 - Registrar ponto no placar");
		System.out.println("8 - Zerar o placar");
		System.out.println("9 - Alterar o tempo máximo");
		System.out.println("10 - Consultar informações gerais");
		System.out.println("11 - Listar as quadras");
		System.out.println("0 - Sair");
		System.out.print("Selecione o código que deseja: ");
	}
}
