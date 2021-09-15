package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.cardsUtils.CardsDistributor;

import java.util.ArrayList;
import java.util.List;

public class GameLobby
{
    private int bank;
    private Deck gameDeck;
    private List<Player> listOfPlayers = new ArrayList<>();
    private GameHand gameHand;

    private int handCounter = 1;
    private boolean isBettingTime;

    public GameLobby(int bank)
    {
        this.bank = bank;
        initGame();
    }

    private void initGame()
    {
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);

        gameDeck = new Deck();
        new CardsDistributor(listOfPlayers, gameDeck);
        gameHand = new GameHand(gameDeck);
    }






}
