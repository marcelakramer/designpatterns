package br.edu.ifpb;

import java.util.List;

public interface Observer {
    void atualizar(int andarAtual, String status, List<Integer> fila);
}

