package br.edu.ifpb;

import java.util.List;

public class PainelElevador implements Observer {
    @Override
    public void atualizar(int andarAtual, String status, List<Integer> fila) {
        System.out.println("Painel atualizado: Andar atual: " + andarAtual + " | Status: " + status + " | Fila: " + fila);
    }
}

