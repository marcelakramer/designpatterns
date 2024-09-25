package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;

public class Elevador {
    private static Elevador instanciaUnica;
    private ElevadorEstado estado;
    private EstrategiaAtendimento estrategia;
    private int andarAtual = 0;
    private String status = "Parado";
    private List<Integer> filaDeRequisicoes = new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();

    private Elevador() {
        this.estado = new ElevadorParado(this); // Elevador começa parado com a porta aberta
        this.estrategia = new EstrategiaSubindo(); // Estratégia padrão
    }

    public static Elevador getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Elevador();
        }
        return instanciaUnica;
    }

    public void adicionarRequisicao(int andar) {
        if (!filaDeRequisicoes.contains(andar)) {
            filaDeRequisicoes.add(andar);
            System.out.println("Requisição adicionada para o andar: " + andar);
        }
        notificarObservadores();
    }

    public void abrirPorta() {
        estado.abrirPorta();
        notificarObservadores();
    }

    public void fecharPorta() {
        estado.fecharPorta();
        notificarObservadores();
    }

    public void mover() {
        // Verificar se a fila de requisições está vazia
        if (!filaDeRequisicoes.isEmpty()) {
            // A estratégia de atendimento vai processar a fila
            estrategia.processarFila(this);
            notificarObservadores();
        } else {
            System.out.println("Não há requisições na fila.");
        }
    }

    public void setEstado(ElevadorEstado novoEstado) {
        this.estado = novoEstado;
        notificarObservadores();
    }

    public void setEstrategia(EstrategiaAtendimento novaEstrategia) {
        this.estrategia = novaEstrategia;
    }

    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    private void notificarObservadores() {
        for (Observer observer : observadores) {
            observer.atualizar(andarAtual, status, filaDeRequisicoes);
        }
    }

    public void moverParaAndar(int andar) {
        System.out.println("Movendo para o andar: " + andar);
        andarAtual = andar;
        filaDeRequisicoes.remove((Integer) andar);  // Remover o andar atual da fila
        notificarObservadores();
        // Verificar se chegou ao destino final
        if (filaDeRequisicoes.isEmpty()) {
            setEstado(new ElevadorParado(this));  // Mudar o estado para parado
            abrirPorta();  // Abrir a porta ao chegar no destino
        }
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public List<Integer> getFilaDeRequisicoes() {
        return filaDeRequisicoes;
    }

    public String getStatus() {
        return status;
    }

    public boolean chegouAoDestino() {
        return filaDeRequisicoes.isEmpty();
    }

    public void atualizarAndar() {
        // Atualizar logicamente o andar atual (simulação)
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
