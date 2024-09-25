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
        this.estado = new ElevadorPortaAberta(this); // Estado inicial com a porta aberta
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
        estado.mover();
        notificarObservadores();
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
        andarAtual = andar;
        System.out.println("Movendo para o andar: " + andarAtual);
        notificarObservadores();
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
        // Atualizar andar atual logicamente aqui
    }
}

