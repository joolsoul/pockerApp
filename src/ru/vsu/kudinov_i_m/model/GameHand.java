package ru.vsu.kudinov_i_m.model;

import java.util.ArrayList;
import java.util.List;

public class GameHand
{
    private final List<Card> cards = new ArrayList<>();

    public GameHand(Deck gameDeck)
    {
        initStartHand(gameDeck);
    }

    //тест исправить на 3!!!
    private void initStartHand(Deck gameDeck)
    {
        for (int i = 0; i < 5; i++)
        {
            cards.add((Card) gameDeck.get(0));
            gameDeck.remove(0);
        }
    }

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public List<Card> getCards()
    {
        return cards;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (Card card : cards)
        {
            result.append(card).append(" ");
        }
        return result.toString();
    }
}

