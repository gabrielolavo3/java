package formaGeometrica;

public class Circulo {
    
    // Declaração de atributos
    
    private float raioCirculo;
    
    // Declaração de métodos/ações
    
    public float inserirRaio(float raio) 
    {
        return raioCirculo = raio;
    }
    
    private float calcularArea() 
    {        
        return (raioCirculo * raioCirculo) * 3.14F;
    }
    
    private float calcularPerimetro() 
    {
        return 2 * 3.14F * raioCirculo;
    }
    
    public String toString() 
    {
        return "Com o raio de " 
               + String.format("%.2f", raioCirculo)
               + " , o círculo possui área de " 
               + calcularArea() + " metros quadrados"
               + " e perímetro de " 
               + calcularPerimetro();
    }
}
