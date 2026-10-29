package pacote2;

public class Consumidor {
	private final Buffer buffer; // Indica o Buffer que será usado e acessado pelo Consumidor
	private Produtor produtor; // Indica quem irá Produzir os itens e acordar-lo caso esteja dormindo

	private boolean dormindo = false; // serve para o sleep ou wake-up
	private int consumidos = 0; // Saber quantos itens já tirou do Buffer

	// Inicia o uso do buffer produtor
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	// Atualiza produtor
	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}

	// Condição de guarda lida pela classe MAIN no loop principal
	public boolean podeAgir() {
		return !dormindo;
	}

	// Metodo acionado externamente pelo PRODUTOR (Wake-up) quando há novos itens
	public void acordar() {
		dormindo = false;
	}

	// Metodo acionado externamente pelo PRODUTOR (Sleep)
	public boolean estaDormindo() {
		return dormindo;
	}

	public int getConsumidos() {
		return consumidos;
	}

	// Verificar de fato se há produção para o Consumidor tirar
	public void agir() {
		// Antes de tudo, verifica se o buffer esta vázio para não remover um valor que não existe
		// ESSE É O SLEEP DO SEMÂFORO
		if (buffer.estaVazio()) {
			dormindo = true; // Manda o Consumidor esperar até que haja item feito pelo Produtor
			System.out.println("!! BUFFER VAZIO: o CONSUMIDOR nao pode retirar e vai DORMIR (sleep).");
			System.out.println("   Ele so volta a agir quando o produtor inserir um item (wake-up).");

		// ESSE É O WAKE UP DO SEMÂFORO
		// Caso ainda tenha item no Buffer
		} else {
			// Chama o metodo buffer.remover() e que pega o item mais antigo
			System.out.println("CONSUMIDOR retirou o valor " + buffer.remover());
			consumidos++; // Atualiza a quantidade de itens que o produtor tirou do Buffer

			// Verifica se o produtor está parado
			if (produtor.estaDormindo()) {
				// Se sim, o produtor é notificado e é acordado para criar mais itens
				produtor.acordar();
				System.out.println(">> CONSUMIDOR ACORDA O PRODUTOR (wake-up): ha espaco no buffer.");
			}
		}
		System.out.println(buffer.desenho() + "\n");
	}
}