package ru.vsu.kudinov_i_m.cardsUtils;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.Deck;
import ru.vsu.kudinov_i_m.model.Player;

import java.util.List;

public class CardsDistributor
{
    public CardsDistributor(List<Player> listOfPlayers, Deck gameDeck)
    {
        distributeStartCards(listOfPlayers, gameDeck);
    }

    private void distributeStartCards(List<Player> listOfPlayers, Deck gameDeck)
    {
        for(int i = 0; i < listOfPlayers.size(); i++)
        {
            Player currentPlayer = listOfPlayers.get(i);
            currentPlayer.setHand((Card) gameDeck.get(0), (Card) gameDeck.get(1));
            gameDeck.remove(0);
            gameDeck.remove(0);
        }
    }

}
