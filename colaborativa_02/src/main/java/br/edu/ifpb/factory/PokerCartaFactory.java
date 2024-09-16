package br.edu.ifpb.factory;

import br.edu.ifpb.cartas.CartaPoker;
import br.edu.ifpb.interfaces.CartaFactory;

public class PokerCartaFactory implements CartaFactory {
    @Override
    public CartaPoker criarCarta(String face, String[] naipe, int valor) {
        return new CartaPoker(face, naipe, valor);
    }
}
