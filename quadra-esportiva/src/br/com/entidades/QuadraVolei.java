package br.com.entidades;

public class QuadraVolei extends Quadra implements ComPlacar {
	private byte pontosEquipeA;
	private byte pontosEquipeB;
	
	public QuadraVolei(String id, short capacMax) throws OperacaoQuadraException {
		super(id, capacMax);	
		pontosEquipeA = 0;
		pontosEquipeB = 0;
	}
	
	public byte getPontosEquipeA() {
		return pontosEquipeA;
	}

	public byte getPontosEquipeB() {
		return pontosEquipeB;
	}
	
	@Override
	protected boolean entradaConfirmada(short pessoas) throws OperacaoQuadraException {
		if (pessoas % 6 != 0) {
			throw new OperacaoQuadraException("Quadra de vôlei aceita a entrada de times completos");
		}
				
		return true;
	}

	@Override
	public void registrarPontucao(char codigo) throws OperacaoQuadraException {
		if (getJogadoresEmQuadra() < 12) {
			throw new OperacaoQuadraException("O placar pode ser usado somente quando houver 12 jogadores ou mais");			
		}
		
		if (codigo != '1' && codigo != '2') {
			throw new OperacaoQuadraException("O código da equipe está incorreto");
		}
		
		switch (codigo) {
			case '1' -> pontosEquipeA++;
			case '2' -> pontosEquipeB++;
		}
	}

	@Override
	public void zerarPlacar() {
		pontosEquipeA = 0;
		pontosEquipeB = 0;
	}

	@Override
	public void liberarQuadra() throws OperacaoQuadraException {
		super.liberarQuadra();
		zerarPlacar();
	}
}
