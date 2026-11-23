package br.com.entidades;

public interface ComPlacar {    
	public void registrarPontucao(char codigo) throws OperacaoQuadraException;
    public void zerarPlacar();
}
