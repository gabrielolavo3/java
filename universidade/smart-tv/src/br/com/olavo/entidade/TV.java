package br.com.olavo.entidade;

public class TV {
    protected byte volume;
    protected byte canal;
    protected boolean statusFuncionamento;

    public TV() {
        volume = 0;
        canal = 1;
        statusFuncionamento = false;
    }

    public byte getVolume() {
        return volume;
    }

    public byte getCanal() {
        return canal;
    }

    public boolean getStatus() {
        return statusFuncionamento;
    }

    public byte alterarCanal(byte novoCanal) {
        if (statusFuncionamento) {
            if ((novoCanal >= 1 && novoCanal <= 11) && novoCanal % 2 != 0) {
                canal = novoCanal;
                return -1;
            }
        }
        return -2;
    }

    public byte addVolume() {
        if (statusFuncionamento) {
            volume = (byte) (volume < 100 ? volume + 1 : 100);
            return -1;
        }
        return -2;
    }

    public byte diminuiVolume() {
        if (statusFuncionamento) {
            volume = (byte) (volume > 0 ? volume - 1 : 0);
            return -1;
        }
        return -2;
    }

    public boolean powerBtn() {
        statusFuncionamento = statusFuncionamento ? false : true;
        return statusFuncionamento;
    }

    @Override
    public String toString() {
        String estado = statusFuncionamento ? "Ligada" : "Desligada";

        return  "\nDados da TV" +
                "\nCanal: " + canal +
                "\nVolume: " + volume +
                "\nStatus da TV: " + estado;
    }
}
