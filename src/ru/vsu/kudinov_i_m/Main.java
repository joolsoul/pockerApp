package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.cardsUtils.CardsDistributor;
import ru.vsu.kudinov_i_m.comparator.HandComparator;
import ru.vsu.kudinov_i_m.comparator.HandEvaluator;
import ru.vsu.kudinov_i_m.model.Deck;
import ru.vsu.kudinov_i_m.model.GameHand;
import ru.vsu.kudinov_i_m.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Deck gameDeck = new Deck();
        GameHand gameHand = new GameHand(gameDeck);
        System.out.println(gameHand.toString());
        System.out.println();

        Player p1 = new Player(1201);
        Player p2 = new Player(1202);
        //Player p3 = new Player(1203);

        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(p1);
        listOfPlayers.add(p2);
        //listOfPlayers.add(p3);

        new CardsDistributor(listOfPlayers, gameDeck);

        for (int i = 0; i < listOfPlayers.size(); i++)
        {
            System.out.println("player" + (i + 1));
            listOfPlayers.get(i).showCards();
        }
        System.out.println();

        //gameDeck.print();

        HandEvaluator sd = new HandEvaluator(gameHand, p1);
        sd.isCombination();
        System.out.println("p1");
        System.out.println(sd.getCurrentCombination());
        System.out.println(sd.getValueOfCombination());
        System.out.println();

        HandEvaluator sl = new HandEvaluator(gameHand, p2);
        sl.isCombination();
        System.out.println("p2");
        System.out.println(sl.getCurrentCombination());
        System.out.println(sl.getValueOfCombination());
        System.out.println();

        if(new HandComparator().compare(p1, p2) == 0)
        {
            System.out.println("p1 and p2");
        }
        if(new HandComparator().compare(p1, p2) > 0)
        {
            System.out.println("p1");
            System.out.println(p1.getCurrentCombination());
            System.out.println(p1.getValueOfCombination());
        }
        if(new HandComparator().compare(p1, p2) < 0)
        {
            System.out.println("p2");
            System.out.println(p2.getCurrentCombination());
            System.out.println(p2.getValueOfCombination());
        }

    }
}



