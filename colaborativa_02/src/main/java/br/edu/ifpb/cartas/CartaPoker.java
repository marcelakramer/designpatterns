package br.edu.ifpb.cartas;

import java.util.Arrays;

public class CartaPoker extends Carta {
    protected String naipe;
    public CartaPoker(String face, String naipe, String[] cor) {
        this.face = face;
        this.naipe = naipe;
        this.valor = 0;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return face + " de " + naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

}
