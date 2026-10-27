package br.com.olavo.entidade;

public class SmartTV extends TV {
    private byte modo;
    private String login;
    private String senha;
    private boolean conexaoEstabelecida;

    public SmartTV() {
        modo = 1;
        login = "123456";
        senha = "987654";
        conexaoEstabelecida = false;
    }

    public byte getModo() {
        return modo;
    }

    public byte setModo(byte modo) {
        if (modo == 1 || modo == 2) {
            this.modo = modo;
            return 0;
        }
        return -1;
    }

    public boolean getConexao() {
        return conexaoEstabelecida;
    }

    @Override
    public boolean powerBtn() {
        boolean tvLigada = super.powerBtn(); // o super acessa o metodo pai e traz o retorno

        if (tvLigada) {
            modo = 1; // quando liga, a SmarTV estará em modo TV
        }
        return tvLigada;
    }

    public boolean conectarNet(String login, String senha) {
        if (!conexaoEstabelecida) {
            // compara se o valor do atributo e do parâmetro
            if (login.equals(this.login) && senha.equals(this.senha)) {
                return conexaoEstabelecida = true;
            }
        }
        return conexaoEstabelecida = false;
    }

    public boolean desconectarNet() {
        if (conexaoEstabelecida) {
            modo = 1;
            conexaoEstabelecida = false;
            return true;
        }
        return false;
    }

    public boolean novasCredenciais(String login, String senha) {
        if (conexaoEstabelecida) {
            if ((!login.equals(this.login) && !login.isBlank()) && (!senha.equals(this.senha) && !senha.isBlank())) {
                this.login = login;
                this.senha = senha;
                return true;
            }
        }
        return false;
    }

    @Override
    public byte alterarCanal(byte novoCanal) {
        if (modo == 1) {
            return super.alterarCanal(novoCanal); // busca o retorno da classe-pai e retorna-o novamente
        }
        return -2;
    }

    @Override
    public String toString() {
        String estado = statusFuncionamento ? "Ligada" : "Desligada";
        String modo = this.modo == 1 ? "TV" : "Smart TV";
        String conexao = conexaoEstabelecida ? "Estabelecida" : "Não conectada";

        return  "\nDados da Smart TV" +
                "\nModo: " + modo +
                "\nCanal: " + canal +
                "\nVolume: " + volume +
                "\nStatus da TV: " + estado +
                "\nConexão: " + conexao;
    }
}
