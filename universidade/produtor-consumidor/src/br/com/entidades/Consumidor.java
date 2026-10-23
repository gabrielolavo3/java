package br.com.entidades;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor {
    private final Buffer buffer; //Associação entre o consumidor e o buffer que ele pegará os itens

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void consumir () {
        //executa enquanto não há interrupção da thread por outra
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(750, 1000)); //representa o tempo que levar retirar um item do buffer
                buffer.removeItem(); //passado o tempo, chama o método e retira o ite,
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
