package br.edu.ifpb.interfaces;

import br.edu.ifpb.cartas.Carta;

public interface CartaFactory {
    Carta criarCarta(String face, String[] naipe, int valor);
}