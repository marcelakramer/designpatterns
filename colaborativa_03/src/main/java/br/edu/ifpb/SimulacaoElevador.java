package br.edu.ifpb;

public class SimulacaoElevador {
    public static void main(String[] args) {
        Elevador elevador = Elevador.getInstancia();
        PainelElevador painel = new PainelElevador();
        CentralDeControleElevador controle = new CentralDeControleElevador(elevador, painel);

        // Simulação de ações
        controle.acionarBotaoAndar(5);
        controle.fecharPorta();
        controle.moverElevador();

        controle.acionarBotaoAndar(3);
        controle.moverElevador();
        controle.abrirPorta();
    }
}
