package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.cardsUtils.Combination;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private List<Card> playerHand;
    private int currentBalance;
    private int currentBet;

    private Combination currentCombination;
    private List<Integer> valueOfCombination;

    private boolean isPassed;
    private boolean isChecked;

    public Player()
    {

    }

    public Player(Card firstCard, Card secondCard, int balance)
    {
        this.playerHand = new ArrayList<>();
        playerHand.add(firstCard);
        playerHand.add(secondCard);
        this.currentBalance = balance;
    }

    public Player(Card firstCard, Card secondCard)
    {
        this.playerHand = new ArrayList<>();
        playerHand.add(firstCard);
        playerHand.add(secondCard);
    }

    public Player(int balance)
    {
        this.currentBalance = balance;
    }

    public void setHand(Card firstCard, Card secondCard)
    {
        this.playerHand = new ArrayList<>();
        playerHand.add(firstCard);
        playerHand.add(secondCard);
    }

    public void setCurrentBalance(int currentBalance)
    {
        this.currentBalance = currentBalance;
    }

    public List<Card> getPlayerHand()
    {
        return playerHand;
    }

    public int getCurrentBalance()
    {
        return currentBalance;
    }

    public void showCards()
    {
        System.out.println(playerHand.toString());
    }

    public int getCurrentBet()
    {
        return currentBet;
    }

    public void setCurrentBet(int currentBet)
    {
        this.currentBet = currentBet;
    }

    public boolean isPassed()
    {
        return isPassed;
    }

    public int makeBet()
    {
        currentBalance -= currentBet;
        return currentBet;
    }

    public void raiseBet(int numbers)
    {
        currentBet += numbers;
    }

    public void setPassed()
    {
        isPassed = true;
    }

    public void setChecked()
    {
        isChecked = true;
    }

    public void resetForNewHand()
    {
        isChecked = false;
        isPassed = false;
        currentBet = 0;
    }

    public Combination getCurrentCombination()
    {
        return currentCombination;
    }

    public boolean isChecked()
    {
        return isChecked;
    }

    public List<Integer> getValueOfCombination()
    {
        return valueOfCombination;
    }

    public void setCurrentCombination(Combination currentCombination)
    {
        this.currentCombination = currentCombination;
    }

    public void setValueOfCombination(List<Integer> valueOfCombination)
    {
        this.valueOfCombination = valueOfCombination;
    }
}
