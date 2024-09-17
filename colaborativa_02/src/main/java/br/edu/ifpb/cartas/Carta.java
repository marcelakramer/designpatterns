package br.edu.ifpb.cartas;

import java.util.Arrays;

public abstract class Carta {
    protected String face;

    protected int valor;

    protected String[] cor;

    public void setFace(String face) {
        this.face = face;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
