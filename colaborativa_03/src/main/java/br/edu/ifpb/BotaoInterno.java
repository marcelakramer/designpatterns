package br.edu.ifpb;

public class BotaoInterno {
    private int andar;
    private CentralDeControleElevador controle;

    public BotaoInterno(int andar, CentralDeControleElevador controle) {
        this.andar = andar;
        this.controle = controle;
    }

    public void selecionarAndar() {
        System.out.println("Selecionando o andar " + andar + " dentro do elevador.");
        controle.acionarBotaoAndar(andar);
    }
}

