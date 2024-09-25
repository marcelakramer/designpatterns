package br.edu.ifpb;

public class ElevadorDescendo implements ElevadorEstado {
    private Elevador elevador;

    public ElevadorDescendo(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void acionarBotao(int andar) {
        elevador.adicionarRequisicao(andar);
    }

    @Override
    public void abrirPorta() {
        System.out.println("Não é possível abrir a porta enquanto o elevador está descendo.");
    }

    @Override
    public void fecharPorta() {
        System.out.println("Porta já está fechada.");
    }

    @Override
    public void mover() {
        elevador.atualizarAndar();
        if (elevador.chegouAoDestino()) {
            elevador.setEstado(new ElevadorPortaAberta(elevador));
        }
    }
}
