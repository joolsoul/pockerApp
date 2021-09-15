package ru.vsu.kudinov_i_m.cardsUtils;


import ru.vsu.kudinov_i_m.model.Deck;

import java.util.Collections;

public class DeckShuffle
{
    public static void shuffleOfDeck(Deck gameDeck)
    {
        Collections.shuffle(gameDeck);
    }

}
