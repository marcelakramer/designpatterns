package br.edu.ifpb.builder;

import br.edu.ifpb.baralhos.BaralhoUno;
import br.edu.ifpb.cartas.CartaUno;
import br.edu.ifpb.factory.TipoCarta;
import br.edu.ifpb.interfaces.BaralhoBuilder;
import br.edu.ifpb.factory.CartaFactory;

// BaralhoUnoBuilder.java
public class BaralhoUnoBuilder implements BaralhoBuilder {
    private BaralhoUno result;
    private CartaFactory cartaFactory;
    private String[] cores;
    private String[] faces;
    private int[] valores;

    private String[] acoes;

    private String[] coringas;

    private Integer[] valoresEspeciais;

    public BaralhoUnoBuilder() {
        this.cartaFactory = new CartaFactory();
        this.reset();
    }
    @Override
    public void definirNaipesCartas() {
        throw new UnsupportedOperationException("Baralho de Uno não possui naipes");
    }

    @Override
    public void reset() {
        this.result = new BaralhoUno();
    }

    @Override
    public void definirFacesCartas(){
        this.faces = new String[] {"0","1","2", "3", "4", "5", "6", "7", "8", "9"};
    }
    @Override
    public void definirCoresCartas() {
        this.cores = new String[]{"Vermelho", "Azul", "Verde", "Amarelo"};
    }
    @Override
    public void definirValoresCartas() {
        this.valores = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    @Override
    public void definirAcoesCartas() {
        this.acoes = new String[]{"Pular", "Reverter", "+2"};
    }
    @Override
    public void definirCartasCoringa() {
        this.coringas = new String[]{"Coringa", "+4", "Trocar as mãos"};
    }
    @Override
    public void definirValoresEspeciais() {
        this.valoresEspeciais = new Integer[] {20, 50};
    }

    @Override
    public void construirCartasNumericas() {
        for (String cor : cores) {
            for (int i = 0; i < faces.length; i++) {
                CartaUno carta1 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, faces[i], null, new String[]{cor}, valores[i]);
                CartaUno carta2 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, faces[i], null, new String[]{cor}, valores[i]);
                result.adicionarCarta(carta1);
                result.adicionarCarta(carta2);
            }
        }
    }

    @Override
    public void construirCartasAcoes() {
        for (String cor : cores) {
            for (String acao : acoes) {
                CartaUno carta1 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, acao, null, new String[]{cor}, valoresEspeciais[0]);
                CartaUno carta2 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, acao, null, new String[]{cor}, valoresEspeciais[0]);
                result.adicionarCarta(carta1);
                result.adicionarCarta(carta2);
            }
        }
    }

    @Override
    public void construirCartasCoringa() {

        for (String coringa : coringas) {
            if (coringa.equals("Trocar as mãos")) {
                CartaUno carta1 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, coringa, null, cores, valoresEspeciais[1]);
                result.adicionarCarta(carta1);
            } else {
                for (int i = 0; i < 4; i++) {
                    CartaUno carta1 = (CartaUno) CartaFactory.criarCarta(TipoCarta.UNO, coringa, null, cores, valoresEspeciais[1]);
                    result.adicionarCarta(carta1);
                }
            }
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
