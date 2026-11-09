package br.com.olavo.entidades;

public class SmartTVControladora extends SmartTV {
    @Override
    public boolean conectarNet(String login, String senha) {
        // Só permite conectar se estiver no modo 2 (Smart)
        if (getModo() == 2) {
            return super.conectarNet(login, senha);
        }
        return false; 
    }

    @Override
    public byte alterarCanal(byte novoCanal) {
        // Bloqueia o canal 5
        if (novoCanal != 5) {
            return super.alterarCanal(novoCanal);
        }
        System.out.println("Acesso negado: O canal 5 está bloqueado nesta TV!");
        return -2;
    }

    @Override
    public boolean powerBtn() {
        // Chama o powerBtn da superclasse e, se a TV ligar, força o canal para 11
        boolean tvLigada = super.powerBtn();
        if (tvLigada) {
            this.canal = 11;
        }
        return tvLigada;
    }
}
