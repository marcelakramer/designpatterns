package br.edu.ifpb.cartas;

import java.util.Arrays;

public class CartaUno extends Carta {
    public CartaUno(String tipo, String[] cor, int valor) {
        this.face = tipo;
        this.cor = cor;
        this.valor = valor;
    }

    @Override
    public String toString() {
        if (valor != -1) {
            return face + " " + Arrays.toString(cor) + " com valor " + valor;
        }
        return face + " " + Arrays.toString(cor);
    }
}
