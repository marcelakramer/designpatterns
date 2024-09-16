package br.edu.ifpb.baralhos;


import br.edu.ifpb.cartas.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Baralho.java
public abstract class Baralho {
    protected List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
    }

    public void adicionarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    public void adicionarCartas(List<Carta> cartas) {
        this.cartas.addAll(cartas);
    }

    public void shuffle() {
        Collections.shuffle(this.cartas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta).append("\n");
        }
        return sb.toString();
    }
}