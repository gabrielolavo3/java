package pacote2;
import java.util.Random;

public class Main {

	static final int CAPACIDADE = 3; // Espaços que o Buffer terá para armazenar os itens
	static final int TOTAL_ITENS = 12; // Qunatidade de itens que serão Produzidos e Consumidos
	static final int INTERVALO_MIN = 500;
	static final int INTERVALO_MAX = 1500;

	static final Random random = new Random(); // Gerador de número aleatório

	// esse metood espeara ta aqui pra fzer com que o dev posso ver as mudanças no console
	// Sem ele, todas as ações são feitas de forma rápida: riar os 12 itens, inseri-los no buffer, acordar o consumidor, remover os 12 itens e gerar t@do o texto

	static void esperar() {
		// sorteia um tempo aleatório entre 500ms e 1500ms
		// Cria um atraso computacional (delay) bloqueando a CPU até que o tempo alvo seja atingido.
		// Necessário para que a saída no terminal seja legível para humanos.

		// SORTEIRA número entre 0 e 1000 (1500 - 500 + 1 == 1001)
		// Soma esse número entre 0 e 1000 com 500 - intervalo min
		int ms = INTERVALO_MIN + random.nextInt(INTERVALO_MAX - INTERVALO_MIN + 1);

		// System.nanoTime() pega um tempo me nanomilisegundos
		// Multiplca os Milisegundos com 1 milhão
		// Soma esse valor com o tempo do PC
		long fim = System.nanoTime() + ms * 1_000_000L;

		while (System.nanoTime() < fim) {
			// Esse laço é vazio porque a única função dele é gastar tempo do processador de propósito para criar um atraso (delay)
			// PERMITE VER A EXECUÇÃO LINHA A LINHA
		}
	}

	public static void main(String[] args) {
		Buffer buffer = new Buffer(CAPACIDADE); // Cria o Buffer e passa a capacidade de máx de itens que ele consegue guardar
		Produtor produtor = new Produtor(buffer, TOTAL_ITENS); // Cria o Produtor,  referenciando o Buffer e qtd máx de itens que ele vai fazer
		Consumidor consumidor = new Consumidor(buffer); // Cria o Consumidor e referencia o Buffer

		// É preciso que o Produtor saiba quem é o Consumidor e vice-versa
		// Atualiza o Consumidor para o Produtor
		// Atualiza o Produtor para o Consumidor
		// Serve para o Sleep e Wake-UP
		produtor.setConsumidor(consumidor);
		consumidor.setProdutor(produtor);

		System.out.println("=== PRODUTOR / CONSUMIDOR ===");
		System.out.println("Buffer: " + CAPACIDADE + " posicoes | Itens: " + TOTAL_ITENS);
		System.out.println("Desenho: SAI <- [mais antigo] ... [mais novo] <- ENTRA | [    ] = livre");
		System.out.println("Quem encontra o buffer cheio (produtor) ou vazio (consumidor) DORME");
		System.out.println("e so volta quando o outro lado o ACORDA.\n");

		// Executa o loop enquanto o Consumidor não tiver retirado todos os itens
		while (consumidor.getConsumidos() < TOTAL_ITENS) {

			// Verifica se o Produtor pode funcionar caso ainda não atingiu seu máximo de itens feitos
			// Analisa se o Consumidor ainda pode consumir algo
			// É O WAKE-UP
			boolean produtorPode = produtor.podeAgir();
			boolean consumidorPode = consumidor.podeAgir();

			// O Produtor executa se puder agir E (o Consumidor não puder agir OU cair 'cara' no cara-e-coroa).
			// Isso garante aleatoriedade na execução quando ambos estão aptos.
			if (produtorPode && (!consumidorPode || random.nextBoolean())) {
				produtor.agir(); // chama o metodo agir, que irá criar fazer o trabalho de agir
			} else {
				consumidor.agir();
			}
			esperar(); // Atrasa visualmente a simulação antes da próxima rodada
		}

		System.out.println("=== FIM ===");
		System.out.println("Total produzido: " + produtor.getProduzidos());
		System.out.println("Total consumido: " + consumidor.getConsumidos());
	}
}