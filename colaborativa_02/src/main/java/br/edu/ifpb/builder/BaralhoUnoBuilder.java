package br.edu.ifpb.builder;

import br.edu.ifpb.baralhos.BaralhoUno;
import br.edu.ifpb.cartas.CartaUno;
import br.edu.ifpb.factory.UnoCartaFactory;
import br.edu.ifpb.interfaces.BaralhoBuilder;
import br.edu.ifpb.interfaces.CartaFactory;

// BaralhoUnoBuilder.java
public class BaralhoUnoBuilder implements BaralhoBuilder {
    private BaralhoUno result;
    private CartaFactory cartaFactory;
    private String[] cores;
    private int[] valores;

    private String[] acoes;

    private String[] specialAcoes;

    private int[] valoresAcoes;

    public BaralhoUnoBuilder() {
        this.cartaFactory = new UnoCartaFactory();
        this.reset();
    }

    @Override
    public void reset() {
        this.result = new BaralhoUno();
    }

    @Override
    public void definirCartas() {
        this.cores = new String[] {"Vermelho", "Azul", "Verde", "Amarelo"};
        this.valores = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.acoes = new String[] {"Pular", "Reverter", "+2"};
        this.specialAcoes = new String[] {"Curinga", "+4"};
        this.valoresAcoes = new int[] {20, 50};
    }

    @Override
    public void construirCartasNumericas() {
        for (String cor : cores) {
            for (Integer valor : valores) {
                CartaUno carta = (CartaUno) cartaFactory.criarCarta(valor.toString(), new String[]{cor}, valor);
                result.adicionarCarta(carta);
            }
            for (String acao : acoes) {
                CartaUno carta = (CartaUno) cartaFactory.criarCarta(acao, new String[]{cor},  valoresAcoes[0]);
                result.adicionarCarta(carta);
            }
        }
        for (String acao : specialAcoes) {
            CartaUno carta = (CartaUno) cartaFactory.criarCarta(acao, cores, valoresAcoes[1]);
            result.adicionarCarta(carta);
        }


    }


    @Override
    public void embaralharCartas() {
        result.shuffle();
    }

    @Override
    public BaralhoUno getResult() {
        return result;
    }
}
