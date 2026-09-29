package br.com.olavo.entidade;

public class ContaImpressao {
    private final String nome; //transforma em constante e impedi que qualquer alteração posterior não aconteça
    private final String matricula;
    private float saldo;
    private static int totalPagImpressa = 0;
    private static float precoPagina = 0.50f;

    public ContaImpressao(String nome, String matricula) {
        this.nome = !nome.isEmpty() ? nome : "Desconhecido"; //o atributo constante recebe um valor padrão no construtor
        this.matricula = !matricula.isEmpty() ? matricula : "000X";
        saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public float getSaldo() {
        return saldo;
    }

    public static int getTotalPagImpressa() {
        return totalPagImpressa;
    }

    public static float getPrecoPagina() {
        return precoPagina;
    }

    public static boolean setPrecoPagina(float novoPreco) {
        if (novoPreco <= 0 || novoPreco == precoPagina) {
            return false;
        }

        precoPagina = novoPreco;
        return true;
    }

    public boolean addSaldo(float quantia) {
        if (quantia > 0) {
            saldo += quantia;
            return true;
        }
        return false;
    }

    public byte impressao(int qtdPagina) {
        if (qtdPagina <= 0) {
            return -2;
        }

        float precoTotal = qtdPagina * precoPagina;
        if (saldo >= precoTotal) { //não precisa verificar saldo negativo, pois essa condição impedi
            saldo -= precoTotal;
            totalPagImpressa += qtdPagina; //soma a quantidade impressa com o valor existente
        } else {
            return -1;
        }

        return 0;
    }

    //sobrecarga de metodo
    public byte impressao(int qtdPagina, int qtdCopia) {
        if (qtdPagina <= 0 || qtdCopia <= 0) {
            return -2;
        }
        int impressaoFinal = qtdPagina * qtdCopia; //multiplica a quantidade de páginas e cópias para saber o preco final
        float precoTotal = impressaoFinal * precoPagina;

        if (saldo >= precoTotal) {
            saldo -= precoTotal;
            totalPagImpressa += impressaoFinal;
        } else {
            return -1;
        }

        return 0;
    }
}