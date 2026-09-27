package br.com.olavo.entidade;

public class ContaImpressao {
    private String nome;
    private String matricula;
    private float saldo;
    public static int totalPagImpressa = 0;
    public static float precoPagina = 0.50f;

    public ContaImpressao(String nome, String matricula) {
        if (this.nome == null && !nome.isEmpty()) {
            this.nome = nome;
        }

        if (this.matricula == null && !matricula.isEmpty()) {
            this.matricula = matricula;
        }
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

    public boolean addSaldo(float quantia) {
        if (quantia > 0) {
            saldo += quantia;
            return true;
        }
        return false;
    }

    private boolean manterSaldo() {
        if (saldo <= 0) {
            saldo = 0;
            return true;
        }
        return false;
    }

    public byte impressao(int qtdPagina) {
        if (qtdPagina > 0) {
            float precoTotal = qtdPagina * precoPagina;

            if (saldo >= precoTotal) {
                saldo -= precoTotal;
                totalPagImpressa += qtdPagina; //soma a quantidade impressa com o valor existente
                manterSaldo();
                return -1;
            }
        }
        return -2;
    }

    //sobrecarga de metodo
    public byte impressao(int qtdPagina, int qtdCopia) {
        if (qtdPagina > 0 && qtdCopia > 0) {
            int impressaoFinal = qtdPagina * qtdCopia; //multiplica a quantidade de páginas e cópias para saber o preco final
            float precoTotal = impressaoFinal * precoPagina;

            if (saldo >= precoTotal) {
                saldo -= precoTotal;
                totalPagImpressa += impressaoFinal;
                manterSaldo();
                return -1;
            }
        }
        return -2;
    }
}