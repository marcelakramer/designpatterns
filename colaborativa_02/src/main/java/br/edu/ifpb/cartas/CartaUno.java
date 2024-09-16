package br.edu.ifpb.cartas;

import java.util.Arrays;

public class CartaUno extends Carta {
    public CartaUno(String tipo, String[] cor, int valor) {
        this.face = tipo;  // "Número", "Pular", "Reverso", etc.
        this.naipe = cor;  // "Vermelho", "Amarelo", "Verde", "Azul"
        this.valor = valor; // Para cartas numéricas
    }

    @Override
    public String toString() {
        if (valor != -1) {
            return face + " " + Arrays.toString(naipe) + " com valor " + valor;
        }
        return face + " " + Arrays.toString(naipe);
    }
}
