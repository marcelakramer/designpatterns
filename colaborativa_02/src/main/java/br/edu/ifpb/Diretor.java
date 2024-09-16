package br.edu.ifpb;

import br.edu.ifpb.interfaces.BaralhoBuilder;

public class Diretor {
    private BaralhoBuilder builder;

    public Diretor(BaralhoBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(BaralhoBuilder builder) {
        this.builder = builder;
    }

    public void make(String type) {
        builder.reset();
        builder.definirCartas();
        builder.construirCartasNumericas();
        builder.embaralharCartas();
    }

    public BaralhoBuilder getBuilder() {
        return builder;
    }
}
