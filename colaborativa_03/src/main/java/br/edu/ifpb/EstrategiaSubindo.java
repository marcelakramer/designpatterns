package br.edu.ifpb;

import java.util.List;

public class EstrategiaSubindo implements EstrategiaAtendimento {
    @Override
    public void processarFila(Elevador elevador) {
        List<Integer> fila = elevador.getFilaDeRequisicoes();
        for (Integer andar : fila) {
            if (andar > elevador.getAndarAtual()) {
                elevador.moverParaAndar(andar);
                return;  // Processar uma requisição por vez
            }
        }
    }
}
