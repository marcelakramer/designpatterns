package br.edu.ifpb;

import java.util.HashMap;
import java.util.Map;

public class PainelInterno {
    private Map<Integer, BotaoInterno> botoesInternos = new HashMap<>();

    public PainelInterno(CentralDeControleElevador controle, int totalAndares) {
        for (int andar = 0; andar < totalAndares; andar++) {
            botoesInternos.put(andar, new BotaoInterno(andar, controle));
        }
    }

    public void pressionarBotao(int andar) {
        if (botoesInternos.containsKey(andar)) {
            botoesInternos.get(andar).selecionarAndar();
        } else {
            System.out.println("Botão para o andar " + andar + " não encontrado.");
        }
    }
}

