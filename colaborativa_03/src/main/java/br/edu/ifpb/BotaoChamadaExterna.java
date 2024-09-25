package br.edu.ifpb;

public class BotaoChamadaExterna {
    private int andar;
    private CentralDeControleElevador controle;

    public BotaoChamadaExterna(int andar, CentralDeControleElevador controle) {
        this.andar = andar;
        this.controle = controle;
    }

    public void chamarElevador() {
        System.out.println("Chamando o elevador para o andar: " + andar);
        controle.acionarBotaoAndar(andar);
    }
}

