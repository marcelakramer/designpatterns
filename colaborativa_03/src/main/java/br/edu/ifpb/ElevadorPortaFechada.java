package br.edu.ifpb;

public class ElevadorPortaFechada implements ElevadorEstado {
    private Elevador elevador;

    public ElevadorPortaFechada(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void acionarBotao(int andar) {
        elevador.adicionarRequisicao(andar);
    }

    @Override
    public void abrirPorta() {
        elevador.setEstado(new ElevadorPortaAberta(elevador));
    }

    @Override
    public void fecharPorta() {
        System.out.println("Porta já está fechada.");
    }

    @Override
    public void mover() {
        elevador.atualizarAndar();
    }
}

