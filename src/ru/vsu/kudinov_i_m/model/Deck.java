package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.cardsUtils.DeckShuffle;
import ru.vsu.kudinov_i_m.cardsUtils.Rank;
import ru.vsu.kudinov_i_m.cardsUtils.Suit;

import java.util.ArrayList;

public class Deck extends ArrayList
{
    public Deck()
    {
        initDeck();
        DeckShuffle.shuffleOfDeck(this);
    }

    private void initDeck()
    {
        this.clear();
        for (Suit suit : Suit.values())
        {
            for (Rank rank : Rank.values())
            {
                this.add(new Card(suit.getSuit(), rank.getRank(), rank.getValue()));
            }
        }
    }

    public void print()
    {
        for(Object card : this)
        {
            System.out.println(card.toString());
        }
    }
}
