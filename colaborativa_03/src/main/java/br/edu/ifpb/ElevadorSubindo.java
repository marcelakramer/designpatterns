package br.edu.ifpb;

public class ElevadorSubindo implements ElevadorEstado {
    private Elevador elevador;

    public ElevadorSubindo(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void acionarBotao(int andar) {
        elevador.adicionarRequisicao(andar);
    }

    @Override
    public void abrirPorta() {
        System.out.println("Não é possível abrir a porta enquanto o elevador está subindo.");
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