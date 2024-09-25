package br.edu.ifpb;

public class ElevadorParado implements ElevadorEstado {
    private Elevador elevador;
    private boolean portaAberta;

    public ElevadorParado(Elevador elevador) {
        this.elevador = elevador;
        this.portaAberta = true; // Elevador começa parado com a porta aberta
    }

    @Override
    public void acionarBotao(int andar) {
        elevador.adicionarRequisicao(andar);
        if (andar > elevador.getAndarAtual()) {
            elevador.setEstado(new ElevadorSubindo(elevador));
        } else if (andar < elevador.getAndarAtual()) {
            elevador.setEstado(new ElevadorDescendo(elevador));
        }
    }

    @Override
    public void abrirPorta() {
        if (!portaAberta) {
            System.out.println("Abrindo porta...");
            portaAberta = true;
            elevador.setStatus("Porta Aberta");
        } else {
            System.out.println("A porta já está aberta.");
        }
    }

    @Override
    public void fecharPorta() {
        if (portaAberta) {
            System.out.println("Fechando porta...");
            portaAberta = false;
            elevador.setStatus("Porta Fechada");
        } else {
            System.out.println("A porta já está fechada.");
        }
    }

    @Override
    public void mover() {
        if (!elevador.getFilaDeRequisicoes().isEmpty()) {
            elevador.mover();
        } else {
            System.out.println("O elevador está parado. Para mover, acione um andar.");
        }
    }
}
