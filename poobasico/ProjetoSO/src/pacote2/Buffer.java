package pacote2;

public class Buffer {
	private final int capacidade; //quantos max de itens o buffer vai ter
	private final int[] itens; // armazena os dados na memória
	private int in = 0, // Controlado pelo PRODUTOR: indica o índice do item que o produtor deve guarda valor
			out = 0, // Controlado pelo CONSUMIDOR: indica qual índice que o consumidor vai tirar valor
			contador = 0; // Fonte da verdade compartilhada para saber quantos itens há no buffer

	// recebe a quantidade máxima de itens do buffer e cria um vetor do mesmo tamanho
	public Buffer(int capacidade) {
		this.capacidade = capacidade;
		this.itens = new int[capacidade];
	}

	public boolean estaCheio() {
		// Retorna true caso a quantidade de itens que ainda tem no buffer seja igual a capacidade total do Buffer
		return contador == capacidade;
	}

	public boolean estaVazio() {
		return contador == 0;
	}

	// É usado pelo Produtor para colocar um item no Buffer
	public void inserir(int valor) {
		itens[in] = valor; // Recebe o valor, guardar no Vetor(itens) e na posição atual de Entrada(in)

		// Cria uma estrutura circular para evitar erro de limite
		// Pega a Entrada(in) e soma mais 1 para saber a próxima posição do índice e pega o resto da divisão pela Capacidade total do baffer
		// Por exemplo, se a capacidade for 5 e o IN atual for 4 (a última posição do array), a soma será 5. A divisão de 5 por 5 resulta na parte inteira 1, com resto 0
		// Como o operador % armazena esse resto, a nova posição da variável in recebe o valor 0, voltando ao início
		// Isso também acontece pq um array começa na posição 0 e a última posição seria 4, ou seja 5 números, igual a capacidade máxima do buffer
		in = (in + 1) % capacidade;

		// Serve para atualizar o registro de quantos itens existem dentro do vetor
		contador++;
	}

	public int remover() {
		// Uso o vetor(Itens) e procura na posição mais antiga disponível com a Saída(Out)
		// Depois disso, pega o valor achado na posição do itens[out] e coloca em VALOR
		int valor = itens[out];
		out = (out + 1) % capacidade; // Mesma lógica

		// Diminui a quantidade existente de itens existente dentro do vetor, pq o consumidor tirou 1
		contador--;
		return valor;
	}

	// Serve para o Produtor e Consumidor apresentarem o resultado linha por linha
	public String desenho() {
		// Cria um vetor de textos temporário com o mesmo tamanho do buffer
		String[] casas = new String[capacidade];
		for (int i = 0; i < capacidade; i++) {
			/* Verifica se a posição atual do laço é menor que a quantidade de itens (ou seja, se tem item ali)
			 Se tiver, ele usa a lógica circular (out + i) % capacidade para pegar desde o item mais antigo até o mais novo e desenha o número ex: [ 15 ]
			 Se não tiver item, ele desenha apenas colchetes vazios ex: [    ] */
			casas[i] = (i < contador) ? String.format("[ %2d ]", itens[(out + i) % capacidade]) : "[    ]";
		}

		// Junta todos os quadradinhos desenhados lado a lado num texto só, adicionando as setas de quem SAI e quem ENTRA
		String s = " SAI <- " + String.join("", casas) + " <- ENTRA   ocupado: " + contador + " de " + capacidade;

		// Verifica se não há mais espaço. Se sim, adiciona a palavra (CHEIO) no final do texto
		if (estaCheio())
			s += " (CHEIO)";
		// Verifica se o buffer está zerado. Se sim, adiciona a palavra (VAZIO) no final do texto
		if (estaVazio())
			s += " (VAZIO)";
		return s;
	}
}