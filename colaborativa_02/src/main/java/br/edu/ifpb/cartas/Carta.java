package br.edu.ifpb.cartas;

import java.util.Arrays;

public abstract class Carta {
    protected String face;
    protected String[] naipe;
    protected int valor;

    @Override
    public String toString() {
        return face + " de " + Arrays.toString(naipe);
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void setNaipe(String[] naipe) {
        this.naipe = naipe;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
