package br.com.olavo.entidade;

public class TV {
    public short volume = 0;
    public short canal = 1;
    public boolean status = false;

    public boolean mudarCanal(short novoCanal) {
        if(novoCanal == 1 ||
           novoCanal == 3 ||
           novoCanal == 5 ||
           novoCanal == 7 ||
           novoCanal == 11)
        {
            canal = novoCanal;
            return true;
        }
        else {
            return false;
        }
    }

    public void aumentaVolume() {
        if (volume >= 0) {
            volume++; //Muda o valor do atributo diretamente
            if (volume > 100) {
                volume = 100;
            }
        }
    }

    public void diminuiVolume() {
        if (volume <= 100) {
            volume--;
            if (volume < 0) {
                volume = 0;
            }
        }
    }

    public void powerBtn() {
        status = status ? false : true;
    }

    public String exibirStatus() {
        String estado;
        estado = status ? "Ligada" : "Desligada";

        return "Canal: " + canal +
                "\nVolume: " + volume +
                "\nStatus da TV: " + estado;
    }
}
