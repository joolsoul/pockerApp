package ru.vsu.kudinov_i_m.cardsUtils;

public enum Rank
{
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10),
    Jack("J", 11),
    Queen("Q", 12),
    King("K", 13),
    Ace("A", 14);

   private String rank;
    private int value;

    Rank(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public String getRank()
    {
        return rank;
    }

    public int getValue()
    {
        return value;
    }
}
