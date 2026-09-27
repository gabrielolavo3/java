/* 
Descrição  : Imprimir todos as tabuadas de 1 a 10 de qualquer uma das 4 operações matemáticas! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 16/03/2024 */

public class Operacoes {
    public static void main(String[] args) throws Exception {
        
        // Declração de variáveis

        byte valor;
        byte operador;

        // Tela de resultado

        for (valor = 1; valor <= 10; valor++) {
            System.out.println("Tabuada de " + valor);
            System.out.println("");

            for (operador = 1; operador <= 10; operador++) {
                System.out.printf ("%d - %d = %d\n", valor, operador, valor-operador);
            }
            System.out.println("");
        }
    }
}
