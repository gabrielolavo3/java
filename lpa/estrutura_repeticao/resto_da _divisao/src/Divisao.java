/* 
Descrição  : Imprimir todos os número entre 1000 e 2000 que o resto da divisão por 11 seja 2! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 04/03/2024 */

public class Divisao {
    public static void main(String[] args) throws Exception {
        
        short contador;

        for (contador = 1000; contador <= 2000; contador++) {
            if (contador % 11 == 2) {
                System.out.println (contador);
            }
        }
    }
}
