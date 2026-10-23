package br.com.main;
import br.com.entidades.*;

public class Main {
    static void main(String[] args) {
        Buffer buffer = new Buffer(4);
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        //Cria a thread passando o objeto criado, sue método correspondente e atribuindo um nome a thread
        Thread threadProdutora = new Thread(produtor::producao, "Produtor");
        Thread threadConsumidora = new Thread(consumidor::consumir, "Consumidor");

        //Executa a thread
        threadProdutora.start();
        threadConsumidora.start();
    }
}
