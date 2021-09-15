package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.cardsUtils.Combination;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private List<Card> hand;
    private int balance;
    private int bet;

    private Combination currentCombination;
    private List<Integer> valueOfCombination;

    private boolean isPassed;
    private boolean isChecked;

    public Player()
    {

    }

    public Player(Card firstCard, Card secondCard, int balance)
    {
        this.hand = new ArrayList<>();
        hand.add(firstCard);
        hand.add(secondCard);
        this.balance = balance;
    }

    public Player(Card firstCard, Card secondCard)
    {
        this.hand = new ArrayList<>();
        hand.add(firstCard);
        hand.add(secondCard);
    }

    public Player(int balance)
    {
        this.balance = balance;
    }

    public void setHand(Card firstCard, Card secondCard)
    {
        this.hand = new ArrayList<>();
        hand.add(firstCard);
        hand.add(secondCard);
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public List<Card> getHand()
    {
        return hand;
    }

    public int getBalance()
    {
        return balance;
    }

    public void showCards()
    {
        System.out.println(hand.toString());
    }

    public int getBet()
    {
        return bet;
    }

    public void setBet(int bet)
    {
        this.bet = bet;
    }

    public boolean isPassed()
    {
        return isPassed;
    }

    public int makeBet()
    {
        balance -= bet;
        return bet;
    }

    public void raiseBet(int numbers)
    {
        bet += numbers;
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
        bet = 0;
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
