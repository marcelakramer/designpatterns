package br.edu.ifpb;

import br.edu.ifpb.baralhos.Baralho;
import br.edu.ifpb.builder.BaralhoPokerBuilder;
import br.edu.ifpb.builder.BaralhoUnoBuilder;

public class Main {
    public static void main(String[] args) {
        Diretor diretor = new Diretor(new BaralhoPokerBuilder());

        // Construindo o baralho de Poker
        diretor.make("Poker");
        Baralho baralhoPoker = diretor.getBuilder().getResult();
        System.out.println("Baralho de Poker:");
        System.out.println(baralhoPoker);

        // Construindo o baralho de Uno
        diretor.changeBuilder(new BaralhoUnoBuilder());
        diretor.make("Uno");
        Baralho baralhoUno = diretor.getBuilder().getResult();
        System.out.println("Baralho de Uno:");
        System.out.println(baralhoUno);
    }
}