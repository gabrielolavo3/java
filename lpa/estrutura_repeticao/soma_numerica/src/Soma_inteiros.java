/* 
Descrição  : Imprimir o valor da soma de 1 a 15! (função)
Autor(a)   : Gabriel S. Olavo
Data atual : 23/03/2024 */

public class Soma_inteiros {
    public static void main(String[] args) throws Exception {
        
        byte i;
        byte somador = 0;

        for (i = 1; i <= 15; i++) {
            somador += i; 
        }

        System.out.println(somador);
    }
}
