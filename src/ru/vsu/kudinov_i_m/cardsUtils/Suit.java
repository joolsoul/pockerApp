package ru.vsu.kudinov_i_m.cardsUtils;

public enum Suit
{
    Hearts('♥'),
    Clubs('♣'),
    Spades('♠'),
    Diamonds('♦');

    private char suit;

    Suit(char suit)
    {
        this.suit = suit;
    }

    public char getSuit()
    {
        return suit;
    }
}
