package br.edu.ifpb.interfaces;

import br.edu.ifpb.baralhos.Baralho;

public interface BaralhoBuilder {
    void reset();
    void definirCartas();
    void construirCartasNumericas();
    void embaralharCartas();
    Baralho getResult();
}