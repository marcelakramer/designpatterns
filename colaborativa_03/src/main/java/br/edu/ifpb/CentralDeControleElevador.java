package br.edu.ifpb;

public class CentralDeControleElevador {
    private Elevador elevador;
    private PainelElevador painel;

    public CentralDeControleElevador(Elevador elevador, PainelElevador painel) {
        this.elevador = elevador;
        this.painel = painel;
        elevador.addObserver(painel);
    }

    public void acionarBotaoAndar(int andar) {
        elevador.adicionarRequisicao(andar);
    }

    public void abrirPorta() {
        elevador.abrirPorta();
    }

    public void fecharPorta() {
        elevador.fecharPorta();
    }

    public void moverElevador() {
        elevador.mover();
    }
}
