package ru.vsu.kudinov_i_m.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.cardsUtils.Combination;
import ru.vsu.kudinov_i_m.comparator.HandEvaluator;

import java.util.ArrayList;
import java.util.List;

public class Tests
{

    @Test
    public void isPairTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♣', "4", 4));
        hand.add(new Card('♣', "5", 5));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "6", 6));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isPair();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(2, as);
        Assert.assertEquals(Combination.Pair, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isPairTest2()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "4", 4));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "4", 4));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isPair();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(4, as);
        Assert.assertEquals(Combination.Pair, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isPairTest3()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "8", 8));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "9", 9));
        hand.add(new Card('♣', "7", 7));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "7", 7));
        player.add(new Card('♣', "5", 5));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isPair();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(7, as);
        Assert.assertEquals(Combination.Pair, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isTwoPairsTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♣', "7", 7));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "4", 4));
        player.add(new Card('♣', "4", 4));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isTwoPairs();

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(4, as1);
        Assert.assertEquals(3, as2);
        Assert.assertEquals(Combination.TwoPairs, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isTwoPairsTest2()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♣', "5", 5));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "6", 6));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isTwoPairs();

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(3, as1);
        Assert.assertEquals(2, as2);
        Assert.assertEquals(Combination.TwoPairs, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isTwoPairsTest3()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♣', "A", 14));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "A", 14));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isTwoPairs();

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(14, as1);
        Assert.assertEquals(3, as2);
        Assert.assertEquals(Combination.TwoPairs, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isThreeOfAKindTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♦', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♦', "3", 3));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "3", 3));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isThreeOfAKind();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(3, as);
        Assert.assertEquals(Combination.ThreeOfAKind, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isThreeOfAKindTest2()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♦', "3", 3));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "4", 4));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isThreeOfAKind();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(3, as);
        Assert.assertEquals(Combination.ThreeOfAKind, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isThreeOfAKindTest3()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♦', "7", 7));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "7", 7));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isThreeOfAKind();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(7, as);
        Assert.assertEquals(Combination.ThreeOfAKind, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isFourOfAKindTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "2", 2));
        hand.add(new Card('♦', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♦', "3", 3));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♠', "2", 2));
        player.add(new Card('♣', "7", 7));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFourOfAKind();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(2, as);
        Assert.assertEquals(Combination.FourOfAKind, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isFourOfAKindTest2()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♦', "4", 4));
        hand.add(new Card('♠', "4", 4));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♦', "3", 3));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "4", 4));
        player.add(new Card('♣', "4", 4));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFourOfAKind();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(4, as);
        Assert.assertEquals(Combination.FourOfAKind, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isFourOfAKindTest3()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "5", 5));
        hand.add(new Card('♦', "2", 2));
        hand.add(new Card('♣', "5", 5));
        hand.add(new Card('♦', "Q", 12));
        hand.add(new Card('♦', "5", 5));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♠', "5", 5));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFourOfAKind();

        Assert.assertEquals(Combination.FourOfAKind, handEvaluator.getCurrentCombination());
        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(5, as);


    }

    @Test
    public void isFlushTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "4", 4));
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♥', "5", 5));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♥', "6", 6));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "7", 7));
        player.add(new Card('♥', "8", 8));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFlush();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(8, as);
        Assert.assertEquals(Combination.Flush, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♦', "4", 4));
        hand.add(new Card('♠', "5", 5));
        hand.add(new Card('♦', "5", 5));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "6", 6));
        player.add(new Card('♣', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraight();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(6, as);
        Assert.assertEquals(Combination.Straight, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightTest2()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "7", 7));
        hand.add(new Card('♦', "4", 4));
        hand.add(new Card('♠', "8", 8));
        hand.add(new Card('♦', "5", 5));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "6", 6));
        player.add(new Card('♣', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraight();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(8, as);
        Assert.assertEquals(Combination.Straight, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightTest3()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "7", 7));
        hand.add(new Card('♦', "4", 4));
        hand.add(new Card('♠', "5", 5));
        hand.add(new Card('♦', "10", 10));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "6", 6));
        player.add(new Card('♣', "8", 8));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraight();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(8, as);
        Assert.assertEquals(Combination.Straight, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightTest4()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♦', "5", 5));
        hand.add(new Card('♠', "6", 6));
        hand.add(new Card('♦', "7", 7));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "8", 8));
        player.add(new Card('♣', "9", 9));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraight();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(9, as);
        Assert.assertEquals(Combination.Straight, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightTest5()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "Q", 12));
        hand.add(new Card('♣', "10", 10));
        hand.add(new Card('♦', "J", 11));
        hand.add(new Card('♠', "2", 2));
        hand.add(new Card('♦', "K", 13));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "A", 14));
        player.add(new Card('♣', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraight();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(14, as);
        Assert.assertEquals(Combination.Straight, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightTest6()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♣', "3", 3));
        hand.add(new Card('♦', "4", 4));
        hand.add(new Card('♠', "5", 5));
        hand.add(new Card('♦', "7", 7));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "8", 8));
        player.add(new Card('♣', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraight();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(5, as);
        Assert.assertEquals(Combination.Straight, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isStraightFlushTest6()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♥', "2", 2));
        hand.add(new Card('♥', "3", 3));
        hand.add(new Card('♥', "4", 4));
        hand.add(new Card('♥', "5", 5));
        hand.add(new Card('♦', "7", 7));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♥', "8", 8));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isStraightFlush();

        int as = handEvaluator.getValueOfCombination().get(0);
        Assert.assertEquals(5, as);
        Assert.assertEquals(Combination.StraightFlush, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isRoyalFlushTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♦', "10", 10));
        hand.add(new Card('♥', "10", 10));
        hand.add(new Card('♥', "J", 11));
        hand.add(new Card('♥', "Q", 12));
        hand.add(new Card('♥', "K", 13));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isRoyalFlush();

        Assert.assertEquals(Combination.RoyalFlush, handEvaluator.getCurrentCombination());

    }

    @Test
    public void isFullHouseTest1()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♦', "10", 10));
        hand.add(new Card('♥', "10", 10));
        hand.add(new Card('♥', "J", 11));
        hand.add(new Card('♠', "J", 11));
        hand.add(new Card('♠', "A", 14));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFullHouse();

        Assert.assertEquals(Combination.FullHouse, handEvaluator.getCurrentCombination());

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(14, as1);
        Assert.assertEquals(11, as2);
    }

    @Test
    public void isFullHouseTest2()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♦', "10", 10));
        hand.add(new Card('♦', "Q", 12));
        hand.add(new Card('♥', "J", 11));
        hand.add(new Card('♠', "J", 11));
        hand.add(new Card('♠', "A", 14));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFullHouse();

        Assert.assertEquals(Combination.FullHouse, handEvaluator.getCurrentCombination());

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(14, as1);
        Assert.assertEquals(11, as2);
    }

    @Test
    public void isFullHouseTest3()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♦', "10", 10));
        hand.add(new Card('♦', "J", 11));
        hand.add(new Card('♥', "J", 11));
        hand.add(new Card('♠', "J", 11));
        hand.add(new Card('♠', "A", 14));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFullHouse();

        Assert.assertEquals(Combination.FullHouse, handEvaluator.getCurrentCombination());

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(11, as1);
        Assert.assertEquals(14, as2);
    }

    @Test
    public void isFullHouseTest4()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♦', "10", 10));
        hand.add(new Card('♦', "J", 11));
        hand.add(new Card('♥', "J", 11));
        hand.add(new Card('♣', "A", 14));
        hand.add(new Card('♠', "A", 14));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFullHouse();

        Assert.assertEquals(Combination.FullHouse, handEvaluator.getCurrentCombination());

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(11, as1);
        Assert.assertEquals(14, as2);
    }

    @Test
    public void isFullHouseTest5()
    {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card('♣', "J", 11));
        hand.add(new Card('♦', "J", 11));
        hand.add(new Card('♥', "J", 11));
        hand.add(new Card('♣', "A", 14));
        hand.add(new Card('♠', "A", 14));

        List<Card> player = new ArrayList<>();
        player.add(new Card('♦', "A", 14));
        player.add(new Card('♥', "A", 14));

        HandEvaluator handEvaluator = new HandEvaluator(hand, player);
        handEvaluator.isFullHouse();

        Assert.assertEquals(Combination.FullHouse, handEvaluator.getCurrentCombination());

        int as1 = handEvaluator.getValueOfCombination().get(0);
        int as2 = handEvaluator.getValueOfCombination().get(1);
        Assert.assertEquals(11, as1);
        Assert.assertEquals(14, as2);
    }
}
