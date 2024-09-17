package br.edu.ifpb.interfaces;

import br.edu.ifpb.baralhos.Baralho;

public interface BaralhoBuilder {
    void reset();
    void definirCoresCartas();
    void definirValoresCartas();
    void definirAcoesCartas();
    void definirCartasCoringa();
    void definirValoresEspeciais();
    void definirFacesCartas();
    void definirNaipesCartas();
    void construirCartasNumericas();
    void construirCartasAcoes();
    void construirCartasCoringa();
    void embaralharCartas();
    Baralho getResult();
}