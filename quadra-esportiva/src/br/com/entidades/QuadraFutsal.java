package br.com.entidades;

public class QuadraFutsal extends Quadra implements ComIluminacao {
	private boolean powerIluminacao;
	
	public QuadraFutsal(String id, short capacMax) throws OperacaoQuadraException {
		super(id, capacMax);
		powerIluminacao = false;
	}
	
	@Override
	protected boolean entradaConfirmada(short pessoas) throws OperacaoQuadraException {
		return true;
	}
	
	@Override
	public void ligarIluminacao() throws OperacaoQuadraException {
		if (getJogadoresEmQuadra() <= 0) {
			throw new OperacaoQuadraException("É necessário haver jogadores na quadra para ligar a iluminação");
		}
		
		if (powerIluminacao) {
			throw new OperacaoQuadraException("A iluminação já está acesa");
		}
		
		powerIluminacao = true;	
	}
	
	@Override
	public void desligarIluminacao() throws OperacaoQuadraException {
		if (!powerIluminacao) {
			throw new OperacaoQuadraException("A iluminação já está acesa");
		}
		
		powerIluminacao = false;
		
	}
	
	public boolean getPowerIluminacao() {
		return powerIluminacao;
	}
}
