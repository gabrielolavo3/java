package br.com.entidades;
import java.util.concurrent.ThreadLocalRandom;

public class Produtor {
    private final Buffer buffer; //associação entre a produção e o buffer

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void producao() {
        //executa caso nenhuma outra thread
        while (!Thread.currentThread().isInterrupted()) {
            try {
                //pausa a thread por um tempo em milisegundos
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 950)); //representa o tempo que levar a thread criar um item
                int elemento = ThreadLocalRandom.current().nextInt(1, 100); //a thread gera um número aleatório entre 1 e 99
                buffer.addItem(elemento); //item gerado é adicionado dentro do buffer

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
