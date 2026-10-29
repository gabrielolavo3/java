package pacote2;
import java.util.Random; // Classe que gerar números com valores aleatórios

public class Produtor {

	private final Buffer buffer; // Indica o Buffer que será usado e acessado pelo Produtor
	private final int totalItens; // Informa qual a quantidade máxima
	private final Random random = new Random(); // Gerador de números aleatórios
	private Consumidor consumidor; // Produtor precisa ter acesso ao Consumidor para acordar-lo caso ele esteja dormindo

	private boolean dormindo = false; // Funciona como o Semâforo, liberando o acesso caso True ou não
	private int produzidos = 0; // Indica quanto itens o produtor colocou no buffer com sucesso

	public Produtor(Buffer buffer, int totalItens) {
		this.buffer = buffer; // Atribui qual será o Buffer usado pelo Produtor
		this.totalItens = totalItens; // Atribui a qtd max de itens que o Produtor faz
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
		// setConsumidor: Você pode se perguntar: "Por que o consumidor não é passado no construtor também?".
		// nós criamos os dois primeiro e, em seguida, usamos este metodo
		//  para "apresentar" o consumidor ao produtor. Isso resolve o problema de quem deve ser criado primeiro.
	}

	// Métodos de Verificação de Estado (O Painel de Controle)
	public boolean podeAgir() {
		//
		return !dormindo && produzidos < totalItens;
	}

	// Metodo acionado externamente pelo CONSUMIDOR (Wake-up) quando há espaço liberado
	public void acordar() {
		dormindo = false;
	}

	public boolean estaDormindo() {
		return dormindo;
	}

	public int getProduzidos() {
		return produzidos;
	}

	// Inicia de fato a produção do Produtor
	public void agir() {
		// Antes de tudo, verifica se o buffer esta cheio para não adicionar outro valor que passe do limite
		// ESSE É O SLEEP DO SEMÂFORO
		if (buffer.estaCheio()) {
			dormindo = true; // Caso cheio, o produtor irá ficar em Sleep até o Consumidor tirar um valor
			System.out.println("!! BUFFER CHEIO: o PRODUTOR nao pode inserir e vai DORMIR (sleep).");
			System.out.println("   Ele so volta a agir quando o consumidor retirar um item (wake-up).");

		// CASO O PRODUTOR AINDA TENHA ESPAÇO
			// ESSE É O WAKE UP DO SEMÂFORO
		} else {
			// sorteia um número de 1 a 99
			/*
			* Se você não colocasse o + 1:

			O menor número sorteado seria: 0
			O maior número sorteado seria: 98

			Quando você adiciona o + 1 ao resultado do sorteio,

			O menor número (0) passa a ser: 0 + 1 = 1
			O maior número (98) passa a ser: 98 + 1 = 99
			* */
			int valor = random.nextInt(99) + 1; // +1 garante que não irá ter um número negativo
			buffer.inserir(valor); // chama o metodo INSERIR DO BUFFER e passa aquele valor criado
			produzidos++; // Atualiza a quantidade de itens criados pelo Produtor

			System.out.println("PRODUTOR inseriu o valor " + valor);

			// Esse é o WAKE-UP - AVISA AO CONSUMIDOR
			// Comunicação entre Threads (Simulada):
			// Se a inserção foi bem-sucedida, garante que o Consumidor não fique preso esperando.
			if (consumidor.estaDormindo()) {
				consumidor.acordar(); // Avisa ao Consumidor e serve para que não fique dormindo para sempre enquanto há itens
				System.out.println(">> PRODUTOR ACORDA O CONSUMIDOR (wake-up): ha item no buffer.");
			}
		}
		// Chama o Buffer para imprimir
		System.out.println(buffer.desenho() + "\n");
	}
}