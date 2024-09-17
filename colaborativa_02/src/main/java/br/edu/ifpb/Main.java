package br.edu.ifpb;

import br.edu.ifpb.baralhos.Baralho;
import br.edu.ifpb.builder.BaralhoTradicionalBuilder;
import br.edu.ifpb.builder.BaralhoUnoBuilder;

public class Main {
    public static void main(String[] args) {
        Diretor diretor = new Diretor(new BaralhoTradicionalBuilder());

        // Construindo o baralho de Poker
        diretor.make("Tradicional");
        Baralho baralhoPoker = diretor.getBuilder().getResult();
        System.out.println("Baralho Tradicional:");
        System.out.println(baralhoPoker);
        System.out.println("Número de cartas do Baralho Tradicional:");
        System.out.println(baralhoPoker.getCartas().size());

        // Construindo o baralho de Uno
        diretor.changeBuilder(new BaralhoUnoBuilder());
        diretor.make("Uno");
        Baralho baralhoUno = diretor.getBuilder().getResult();
        System.out.println("Baralho de Uno:");
        System.out.println(baralhoUno);
        System.out.println("Número de cartas do Baralho de Uno:");
        System.out.println(baralhoUno.getCartas().size());
    }
}