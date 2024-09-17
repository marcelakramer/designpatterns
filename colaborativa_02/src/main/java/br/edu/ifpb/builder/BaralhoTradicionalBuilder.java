package br.edu.ifpb.builder;

import br.edu.ifpb.baralhos.BaralhoTradicional;
import br.edu.ifpb.cartas.CartaPoker;
import br.edu.ifpb.factory.TipoCarta;
import br.edu.ifpb.interfaces.BaralhoBuilder;
import br.edu.ifpb.factory.CartaFactory;

public class BaralhoTradicionalBuilder implements BaralhoBuilder {
    private BaralhoTradicional result;
    private CartaFactory cartaFactory;
    private String[] faces;
    private int[] valores;
    private String[] cores;
    private String[] naipes;

    public BaralhoTradicionalBuilder() {
        this.cartaFactory = new CartaFactory();
        this.reset();
    }

    @Override
    public void reset() {
        this.result = new BaralhoTradicional();
    }

    @Override
    public void definirFacesCartas() {
        this.faces = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "As"};
    }

    @Override
    public void definirValoresCartas() {
        throw new UnsupportedOperationException("Baralho Tradicional não possui valores");
    }
    @Override
    public void definirAcoesCartas() {
        throw new UnsupportedOperationException("Baralho Tradicional não possui cartas de ações");
    }
    @Override
    public void definirCartasCoringa() {
        throw new UnsupportedOperationException("Baralho Tradicional não possui cartas coringa");
    }
    @Override
    public void definirValoresEspeciais() {
        throw new UnsupportedOperationException("Baralho Tradicional não possui valores especiais");
    }
    @Override
    public void construirCartasAcoes() {
        throw new UnsupportedOperationException("Baralho Tradicional não possui cartas de ações para serem criadas");
    }
    @Override
    public void construirCartasCoringa() {
        throw new UnsupportedOperationException("Baralho Tradicional não possui cartas coringa para serem criadas");
    }
    @Override
    public void definirNaipesCartas() {
        this.naipes = new String[] {"Copas", "Espadas", "Ouros", "Paus"};
    }

    @Override
    public void definirCoresCartas() {
        this.cores = new String[]{"Vermelho", "Preto"};
    }

    @Override
    public void construirCartasNumericas() {
        for (String naipe : naipes) {
            for (String face : faces) {
                if(naipe.equals("Copas") || naipe.equals("Ouros")) {
                    CartaPoker carta = (CartaPoker) CartaFactory.criarCarta(TipoCarta.TRADICIONAL, face, naipe, new String[]{cores[0]}, 0);
                    result.adicionarCarta(carta);
                }else {
                    CartaPoker carta = (CartaPoker) CartaFactory.criarCarta(TipoCarta.TRADICIONAL, face, naipe, new String[]{cores[1]}, 0);
                    result.adicionarCarta(carta);
                }
            }
        }
    }

    @Override
    public void embaralharCartas() {
        result.shuffle();
    }

    @Override
    public BaralhoTradicional getResult() {
        return result;
    }
}

