package br.edu.ifpb.interfaces;

import br.edu.ifpb.baralhos.Baralho;

public interface BaralhoBuilder {
    void reset();
    void definirCartas(); // Define as cartas e suas características (faces, valores, cores, etc.)
    void construirCartasNumericas();  // Adiciona as cartas numéricas
    void embaralharCartas();  // Embaralha o baralho
    Baralho getResult();
}