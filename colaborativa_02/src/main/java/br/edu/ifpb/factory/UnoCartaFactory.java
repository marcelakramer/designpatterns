package br.edu.ifpb.factory;

import br.edu.ifpb.cartas.CartaUno;
import br.edu.ifpb.interfaces.CartaFactory;

public class UnoCartaFactory implements CartaFactory {
    @Override
    public CartaUno criarCarta(String tipo, String[] cor, int valor) {
        return new CartaUno(tipo, cor, valor);
    }
}
