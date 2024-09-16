package br.edu.ifpb.cartas;

import java.util.Arrays;

public class CartaUno extends Carta {
    public CartaUno(String tipo, String[] cor, int valor) {
        this.face = tipo;
        this.naipe = cor;
        this.valor = valor;
    }

    @Override
    public String toString() {
        if (valor != -1) {
            return face + " " + Arrays.toString(naipe) + " com valor " + valor;
        }
        return face + " " + Arrays.toString(naipe);
    }
}
