package br.edu.ifpb;

public class SimulacaoElevador {
    public static void main(String[] args) {
        Elevador elevador = Elevador.getInstancia();
        PainelElevador painel = new PainelElevador();
        CentralDeControleElevador controle = new CentralDeControleElevador(elevador, painel);

        // Criando botões externos para chamar o elevador
        BotaoChamadaExterna botaoAndar3 = new BotaoChamadaExterna(3, controle);
        BotaoChamadaExterna botaoAndar5 = new BotaoChamadaExterna(5, controle);

        // Criando o painel interno do elevador com botões para todos os andares
        PainelInterno painelInterno = new PainelInterno(controle, 10);  // Painel com 10 andares (0 a 9)

        // Simulação
        botaoAndar3.chamarElevador();  // Alguém chama o elevador no andar 3
        controle.fecharPorta();
        controle.moverElevador();  // Elevador vai para o andar 3

        painelInterno.pressionarBotao(5);  // Pessoa dentro do elevador seleciona o andar 5
        controle.fecharPorta();
        controle.moverElevador();  // Elevador vai para o andar 5
        controle.abrirPorta();

        botaoAndar5.chamarElevador();  // Alguém chama o elevador no andar 5
        controle.fecharPorta();
        controle.moverElevador();  // Elevador vai para o andar 5

        painelInterno.pressionarBotao(1);  // Pessoa dentro do elevador seleciona o andar 1
        controle.fecharPorta();
        controle.moverElevador();  // Elevador vai para o andar 1
        controle.abrirPorta();
    }
}
