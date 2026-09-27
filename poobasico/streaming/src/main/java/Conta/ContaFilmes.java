package Conta;

public class ContaFilmes {
    private String idiomaFilme;
    private String resolucaoTela;
    
    private void buscarPreferenciasDoUsuario() {
        idiomaFilme = "PT-BR";
    }
    
    private void identificarResolucao() {
        resolucaoTela = "Full HD";
    }
    
    // Método para acessar os atributos privados da Class e tornar public
    
    public void acessarFilme() {
        buscarPreferenciasDoUsuario();
        identificarResolucao();
    }
    
    private void carregarAudioFilme() {
        if (idiomaFilme == "PT-BR" || idiomaFilme == "EN-US") {
            System.out.println("Carregando o aúdio em " + idiomaFilme);
        
        } else {
            System.out.println("Carregando o aúdio em EN-US");
        }
    }
     
    public void assitirFilme(String nomeFilme) {
        System.out.println("Iniciando o filme " + nomeFilme);
        System.out.println("Carregando o filme na resolução " + resolucaoTela);
        carregarAudioFilme(); // Chamade de método para deixar o resultado como public
    }       
}
