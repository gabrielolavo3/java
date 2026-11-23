package br.com.entidades;

public abstract class Quadra {
	protected final String id;
	protected final short capacMax;
	private short jogadoresEmQuadra;
	private int totalJogadores;
	private static short tempoReserva = 90;
	private static int totalQuadras = 0;
	
	public Quadra(String id, short capacMax) throws OperacaoQuadraException {
		if (id == null || id.isEmpty()) {
			throw new OperacaoQuadraException("Identificação é um dado que não pode ser nulo ou composto somente de espaços em branco");
		}
		
		if (capacMax <= 0) {
			throw new OperacaoQuadraException("Capacidade máxima de uma quadra deve ser positiva e maior do que 0");
		}
		
		this.id = id;
		this.capacMax = capacMax;
		jogadoresEmQuadra = 0;
		totalJogadores = 0;		
		totalQuadras++;
	}

	public String getId() {
		return id;
	}

	public short getCapacMax() {
		return capacMax;
	}

	public short getJogadoresEmQuadra() {
		return jogadoresEmQuadra;
	}

	public int getTotalJogadores() {
		return totalJogadores;
	}

	public static short getTempoReserva() {
		return tempoReserva;
	}

	public static int getTotalQuadras() {
		return totalQuadras;
	}
	
	public static void setTempoReserva(short novoTempo) throws OperacaoQuadraException {
		if (novoTempo < 45 || novoTempo > 240) {
			throw new OperacaoQuadraException("O tempo de reserva permite é entre 45 e 240");
		}
		
		tempoReserva = novoTempo;
	}
	
	protected abstract boolean entradaConfirmada(short pessoas) throws OperacaoQuadraException;
	
	public byte calculoTaxa() {				
		return (byte) ((jogadoresEmQuadra / capacMax) * 100);
	}
	
	public String lotacao() {
		String lotacaoAtual;
		
		if (vagasLivres() == capacMax) lotacaoAtual = "Lotada";
		else if (vagasLivres() > 0 && vagasLivres() < capacMax) lotacaoAtual = "Com vagas";
		else lotacaoAtual = "Livre";
		
		return lotacaoAtual;
	}
	
	public short vagasLivres() {
		return (short) (capacMax - jogadoresEmQuadra);
	}
		
	public void liberarQuadra() throws OperacaoQuadraException {
		if (jogadoresEmQuadra == 0) {
			throw new OperacaoQuadraException("Não há jogadores na quadra no momento");
		}
		
		jogadoresEmQuadra = 0;
	}
	
	public void entrada(short qtdPessoas) throws OperacaoQuadraException {		
		entradaConfirmada(qtdPessoas);
		
		if (qtdPessoas <= 0) {
			throw new OperacaoQuadraException("A quantidade de pessoas que entrarão deve ser positiva");
		}		
		
		if (jogadoresEmQuadra + qtdPessoas > capacMax) {
			throw new OperacaoQuadraException("Quadra lotada. No momento, não é possível adicinar pessoas");
		}
		
		jogadoresEmQuadra += qtdPessoas;
		totalJogadores += jogadoresEmQuadra;		
	}
	
	public void saida(short qtdPessoas) throws OperacaoQuadraException {
		if (qtdPessoas <= 0) {
			throw new OperacaoQuadraException("A quantidade de pessoas que sairão deve ser positiva");
		}		
		
		if (qtdPessoas > jogadoresEmQuadra) {
			throw new OperacaoQuadraException("Não é permitido a retirada de uma quantidade de pessoas maior do que há na quadra");
		}
		
		jogadoresEmQuadra -= qtdPessoas;				
	}
}
