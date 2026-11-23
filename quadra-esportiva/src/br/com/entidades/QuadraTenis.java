package br.com.entidades;

public class QuadraTenis extends Quadra {
	public QuadraTenis(String id, short capacMax) throws OperacaoQuadraException {
		super(id, capacMax);
	}
	
	@Override
	protected boolean entradaConfirmada(short pessoas) throws OperacaoQuadraException {		
		if (pessoas % 2 != 0 || pessoas > 4) {
			throw new OperacaoQuadraException("Somente é aceito a entrada em pares, com o máximo de 2 pares (4 pessoas) por vez");
		}		
		return true;
	}
}
