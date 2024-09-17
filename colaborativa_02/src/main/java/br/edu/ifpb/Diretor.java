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
        if (type.equals("Tradicional")) {
            builder.reset();
            builder.definirFacesCartas();
            builder.definirCoresCartas();
            builder.definirNaipesCartas();
            builder.definirCoresCartas();
            builder.construirCartasNumericas();
            builder.embaralharCartas();
        } else if (type.equals("Uno")) {
            builder.reset();
            builder.definirFacesCartas();
            builder.definirCoresCartas();
            builder.definirValoresCartas();
            builder.definirAcoesCartas();
            builder.definirCartasCoringa();
            builder.definirValoresEspeciais();
            builder.construirCartasNumericas();
            builder.construirCartasAcoes();
            builder.construirCartasCoringa();
            builder.embaralharCartas();
        }

    }

    public BaralhoBuilder getBuilder() {
        return builder;
    }
}
