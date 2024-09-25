package br.edu.ifpb;

public class ElevadorPortaAberta implements ElevadorEstado {
    private Elevador elevador;

    public ElevadorPortaAberta(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void acionarBotao(int andar) {
        elevador.adicionarRequisicao(andar);
    }

    @Override
    public void abrirPorta() {
        System.out.println("Porta já está aberta.");
    }

    @Override
    public void fecharPorta() {
        elevador.setEstado(new ElevadorPortaFechada(elevador));
    }

    @Override
    public void mover() {
        System.out.println("Não pode se mover com a porta aberta.");
    }
}
