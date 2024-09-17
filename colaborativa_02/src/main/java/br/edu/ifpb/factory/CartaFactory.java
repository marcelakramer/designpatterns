package br.edu.ifpb.factory;

import br.edu.ifpb.cartas.Carta;
import br.edu.ifpb.cartas.CartaTradicional;
import br.edu.ifpb.cartas.CartaUno;

public class CartaFactory {
    public static Carta criarCarta(TipoCarta tipo, String face, String naipe, String[] cor, int valor) {
        switch (tipo) {
            case TRADICIONAL:
                return new CartaTradicional(face, naipe, cor);
            case UNO:
                return new CartaUno(face, cor, valor);
            default:
                throw new IllegalArgumentException("Tipo de carta desconhecido: " + tipo);
        }
    }
}