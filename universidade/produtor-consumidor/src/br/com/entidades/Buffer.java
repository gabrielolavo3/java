package br.com.entidades;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom; //serve gerar números aleatórios de forma isolada para cada thread

public class Buffer {
    private final ArrayList<Integer> listaItens;
    private int capacidadeMaxItens; //define quantos itens terá dentro do buffer

    public Buffer(int capacidadeMaxItens) {
        this.capacidadeMaxItens = capacidadeMaxItens <= 0 ? 3 : capacidadeMaxItens;
        this.listaItens = new ArrayList<>(); //instancia a lista
    }

    //synchronized permite apenas uma thread por vez acessar o buffer
    public synchronized void addItem(int elemento) throws InterruptedException {        
        //Executa enquanto o buffer esteja cheio
        while (bufferCheio() == -1) {
            wait(); //caso cheio faz o buffer esperar até liberar espaço para colocar outro item
        }

        listaItens.add(elemento); // produção de item na lista
        System.out.println("Produtor criou o elemento " + elemento + " | Tamanho do buffer: " + listaItens.size());
        notifyAll(); //avisa as threads que houve uma mudança no buffer
    }

    public synchronized int removeItem() throws InterruptedException {
        while (bufferVazio() == -1) {
            wait(); //caso cheio faz o buffer esperar até que haja algum item. Isso impede a remoção de um item que não existe na lista
        }
        //thread atual escolhe uma posição aleatória dentro da lista
        int index = ThreadLocalRandom.current().nextInt(listaItens.size());
        int elementoRemovido = listaItens.remove(index); //item é consumido, ou seja, removido da lista

        System.out.println("Consumidor removeu " + elementoRemovido + " | Tamanho do buffer: " + listaItens.size());
        notifyAll();
        return elementoRemovido;
    }

    public int bufferCheio() {
        //caso o tamanho da lista seja igual a quantidade máxima de itens, está cheio e retorna 1
        return listaItens.size() == capacidadeMaxItens ? -1 : 0;
    }

    public int bufferVazio() {
        //caso o tamanho da lista esteja vázia, não há itens criados e retorna 1
        return listaItens.isEmpty() ? -1 : 0;
    }
}
