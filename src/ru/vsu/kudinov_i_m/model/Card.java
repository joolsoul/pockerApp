package ru.vsu.kudinov_i_m.model;

public class Card
{
    private char suit;
    private String rank;
    private int value;

    public Card(char suit, String rank, int value)
    {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public char getSuit()
    {
        return suit;
    }

    public String getRank()
    {
        return rank;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "Card{" + "suit=" + suit + ", rank=" + rank +'}';
    }
}
