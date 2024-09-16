package br.edu.ifpb.builder;

import br.edu.ifpb.baralhos.BaralhoPoker;
import br.edu.ifpb.cartas.CartaPoker;
import br.edu.ifpb.factory.PokerCartaFactory;
import br.edu.ifpb.interfaces.BaralhoBuilder;
import br.edu.ifpb.interfaces.CartaFactory;

public class BaralhoPokerBuilder implements BaralhoBuilder {
    private BaralhoPoker result;
    private CartaFactory cartaFactory;
    private String[] faces;
    private int[] valores;

    public BaralhoPokerBuilder() {
        this.cartaFactory = new PokerCartaFactory();
        this.reset();
    }

    @Override
    public void reset() {
        this.result = new BaralhoPoker();
    }

    @Override
    public void definirCartas() {
        this.faces = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "As"};
        this.valores = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1};
    }

    @Override
    public void construirCartasNumericas() {
        String[] naipes = {"Copas", "Espadas", "Ouros", "Paus"};

        for (String naipe : naipes) {
            for (int i = 0; i < faces.length; i++) {
                CartaPoker carta = (CartaPoker) cartaFactory.criarCarta(faces[i], new String[]{naipe}, valores[i]);
                result.adicionarCarta(carta);
            }
        }
    }

    @Override
    public void embaralharCartas() {
        result.shuffle();
    }

    @Override
    public BaralhoPoker getResult() {
        return result;
    }
}

