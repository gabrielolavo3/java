package elementos;

public class Triangulo 
{
    private float primerioLado;
    private float segundoLado;
    private float terceiroLado;
    private float baseTriangulo;
    private float alturaTriaangulo;
    
    public void receberDados(float lado1, float lado2, float lado3, float altura, float base) 
    {
        primerioLado = lado1;
        segundoLado = lado2;
        terceiroLado = lado3;
        baseTriangulo = base;
        alturaTriaangulo = altura;
    }
    
    private String validarTriangulo() 
    {
        String tipoTriangulo;
        
        if ((primerioLado == segundoLado && primerioLado == terceiroLado) && (segundoLado == terceiroLado && segundoLado == primerioLado) && (terceiroLado == primerioLado && terceiroLado == segundoLado)) {
            tipoTriangulo = "Triângulo Equilátero";
            
        } else if ((primerioLado != segundoLado && primerioLado != terceiroLado) && (segundoLado != terceiroLado && segundoLado != primerioLado) && (terceiroLado != primerioLado && terceiroLado != segundoLado)) {
            tipoTriangulo = "Triângulo Escaleno";
            
        } else {
            tipoTriangulo = "Triângulo Isósceles";
        }
        
        return tipoTriangulo;
    }
    
    private float calcularAreaDoTriangulo() 
    {
        return (baseTriangulo * alturaTriaangulo) / 2;
    }
    
    public String toString()
    {
        return "O " + validarTriangulo() 
                + " possui área de " 
                + calcularAreaDoTriangulo() 
                + " centímetros quadrados";
    }
}