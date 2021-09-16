package ru.vsu.kudinov_i_m.comparator;

import ru.vsu.kudinov_i_m.cardsUtils.Combination;
import ru.vsu.kudinov_i_m.model.Player;
import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.GameHand;

import java.util.*;

public class HandEvaluator
{
    private Combination currentCombination = Combination.None;
    private GameHand gameHand;
    private Player player;
    private List<Card> cards;
    private Map<Integer, Integer> ranksMap = new TreeMap<>();
    private List<Integer> valueOfCombination = new ArrayList<>();

    public HandEvaluator(GameHand gameHand, Player player)
    {
        this.gameHand = gameHand;
        this.player = player;
        getSetHands();
        sort();
        fillRanksMap();
    }

    //test
    public HandEvaluator(List<Card> hand, List<Card> player)
    {
        cards = new ArrayList<>();
        cards.addAll(hand);
        cards.addAll(player);
        sort();
        fillRanksMap();
    }

    public Combination getCurrentCombination()
    {
        return currentCombination;
    }

    public List<Integer> getValueOfCombination()
    {
        return valueOfCombination;
    }

    private void getSetHands()
    {
        cards = new ArrayList<>();
        cards.addAll(gameHand.getCards());
        cards.addAll(player.getPlayerHand());
    }

    private void sort()
    {
        Collections.sort(cards, Comparator.comparing(Card::getValue));
    }

    private void fillRanksMap()
    {
        for(Card card : cards)
        {
            boolean isKeyInMap = false;
            for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
            {
                if (entry.getKey().equals(card.getValue()))
                {
                    int value = entry.getValue();
                    entry.setValue(value + 1);
                    isKeyInMap = true;
                }
            }
            if (!isKeyInMap)
            {
                ranksMap.put(card.getValue(), 1);
            }
        }
    }

    public void isCombination()
    {
        isRoyalFlush();
        if(currentCombination != Combination.RoyalFlush)
        {
            isStraightFlush();
            if(currentCombination != Combination.StraightFlush)
            {
                isFourOfAKind();
                if(currentCombination != Combination.FourOfAKind)
                {
                    isFullHouse();
                    if(currentCombination != Combination.FullHouse)
                    {
                        isFlush();
                        if(currentCombination != Combination.Flush)
                        {
                            isStraight();
                            if(currentCombination != Combination.Straight)
                            {
                                isThreeOfAKind();
                                if(currentCombination != Combination.ThreeOfAKind)
                                {
                                    isTwoPairs();
                                    if(currentCombination != Combination.TwoPairs)
                                    {
                                        isPair();
                                        if(currentCombination != Combination.Pair)
                                        {
                                            isHighCard();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void isPair()
    {
        valueOfCombination.clear();
        for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue() == 2)
            {
                currentCombination = Combination.Pair;
                valueOfCombination.add(entry.getKey());
            }
        }
        if(!valueOfCombination.isEmpty())
        {
            int value = valueOfCombination.get(valueOfCombination.size() - 1);
            valueOfCombination.clear();
            valueOfCombination.add(value);
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isTwoPairs()
    {
        valueOfCombination.clear();
        List<Integer> valuesOfPairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue().equals(2))
            {
                valuesOfPairs.add(entry.getKey());
            }
        }
        if(valuesOfPairs.size() > 1)
        {
            valueOfCombination.add(valuesOfPairs.get(valuesOfPairs.size() - 1));
            valueOfCombination.add(valuesOfPairs.get(valuesOfPairs.size() - 2));
            currentCombination = Combination.TwoPairs;
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isThreeOfAKind()
    {
        valueOfCombination.clear();
        for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue() == 3)
            {
                currentCombination = Combination.ThreeOfAKind;
                valueOfCombination.add(entry.getKey());
            }
        }
        if(!valueOfCombination.isEmpty())
        {
            int value = valueOfCombination.get(valueOfCombination.size() - 1);
            valueOfCombination.clear();
            valueOfCombination.add(value);
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isFourOfAKind()
    {
        valueOfCombination.clear();
        for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue() == 4)
            {
                currentCombination = Combination.FourOfAKind;
                valueOfCombination.add(entry.getKey());
            }
        }
        if(!valueOfCombination.isEmpty())
        {
            int value = valueOfCombination.get(valueOfCombination.size() - 1);
            valueOfCombination.clear();
            valueOfCombination.add(value);
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isFlush()
    {
        char suitHighestCard = ' ';
        valueOfCombination.clear();
        Map<Character, Integer> suitsMap = new TreeMap<>();

        for (Card card : cards)
        {
            boolean isKeyInMap = false;
            for (Map.Entry<Character, Integer> entry : suitsMap.entrySet())
            {
                if (entry.getKey().equals(card.getSuit()))
                {
                    int value = entry.getValue();
                    entry.setValue(value + 1);
                    isKeyInMap = true;
                }
            }
            if (!isKeyInMap)
            {
                suitsMap.put(card.getSuit(), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : suitsMap.entrySet())
        {
            if(entry.getValue() > 4)
            {
                currentCombination = Combination.Flush;
                suitHighestCard = entry.getKey();
            }
        }

        for (Card card : cards)
        {
            if(card.getSuit() == suitHighestCard)
            {
                valueOfCombination.add(card.getValue());
            }
        }
        if(!valueOfCombination.isEmpty())
        {
            int value = valueOfCombination.get(valueOfCombination.size() - 1);
            valueOfCombination.clear();
            valueOfCombination.add(value);
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isStraight()
    {
        valueOfCombination.clear();
        for (int i = 0; i < cards.size(); i++)
        {
               if(i != cards.size() - 1 && cards.get(i + 1).getValue() == cards.get(i).getValue())
               {
                   cards.remove(i + 1);
               }
        }

        for(int i = 0; i < cards.size() - 4; i++)
        {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue() - 1 &&
                    cards.get(i + 1).getValue() == cards.get(i + 2).getValue() - 1 &&
                    cards.get(i + 2).getValue() == cards.get(i + 3).getValue() - 1 &&
                    cards.get(i + 3).getValue() == cards.get(i + 4).getValue() - 1)
            {
                valueOfCombination.clear();
                valueOfCombination.add(cards.get(i + 4).getValue());
                currentCombination = Combination.Straight;
            }
        }

        if(ranksMap.containsKey(2) && ranksMap.containsKey(3) && ranksMap.containsKey(4) && ranksMap.containsKey(5) && ranksMap.containsKey(14) && !ranksMap.containsKey(6))
        {
            currentCombination = Combination.Straight;
            valueOfCombination.add(5);
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isStraightFlush()
    {
            isFlush();
            if(currentCombination == Combination.Flush)
            {
                isStraight();
                if(currentCombination == Combination.Straight)
                {
                    currentCombination = Combination.StraightFlush;
                }
            }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isFullHouse()
    {
        valueOfCombination.clear();
        int counterOfPairs = 0;
        int rank2cards = 0;
        int rank3cards = 0;
        int rank4cards = 0;
        for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue() == 2)
            {
                counterOfPairs++;
                if(rank2cards < entry.getKey())
                {
                    rank2cards = entry.getKey();
                }

            }
            else if(entry.getValue() == 3)
            {
                if(rank3cards < entry.getKey())
                {
                    valueOfCombination.add(entry.getKey());
                }
            }
            else if(entry.getValue() == 4)
            {
                rank4cards = entry.getKey();
            }
        }

        if(counterOfPairs == 2 && ranksMap.containsValue(3))
        {
            valueOfCombination.add(rank2cards);
            currentCombination = Combination.FullHouse;
        }

        if(ranksMap.containsValue(2) && ranksMap.containsValue(3))
        {
            valueOfCombination.add(rank2cards);
            currentCombination = Combination.FullHouse;
        }

        if(ranksMap.containsValue(2) && ranksMap.containsValue(4))
        {
            valueOfCombination.add(rank2cards);
            valueOfCombination.add(rank4cards);
            currentCombination = Combination.FullHouse;
        }

        if(ranksMap.containsValue(4) && ranksMap.containsValue(3))
        {
            valueOfCombination.add(rank4cards);
            currentCombination = Combination.FullHouse;
        }

        if(ranksMap.containsValue(3) && valueOfCombination.size() == 2)
        {
            currentCombination = Combination.FullHouse;
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isHighCard()
    {
        valueOfCombination.clear();
        if(currentCombination == Combination.None)
        {
            int highCard = 0;
            {
                for(Card card : cards)
                {
                    if(card.getValue() > highCard)
                    {
                        highCard = card.getValue();
                    }
                }
            }
            currentCombination = Combination.HighCard;
            valueOfCombination.add(highCard);
        }
        player.setCurrentCombination(currentCombination);
        player.setValueOfCombination(valueOfCombination);
    }

    public void isRoyalFlush()
    {
        valueOfCombination.clear();
        int valueOfSuitCombinationCard = 0;
        char suitCombination = ' ';
        if(ranksMap.containsKey(14) && ranksMap.containsKey(13) && ranksMap.containsKey(12) && ranksMap.containsKey(11) && ranksMap.containsKey(10))
        {
            for(Map.Entry<Integer, Integer> entry : ranksMap.entrySet())
            {
                if(entry.getKey() > 9 && entry.getValue() == 1)
                {
                    valueOfSuitCombinationCard = entry.getKey();
                }
            }
        }
        if(valueOfSuitCombinationCard != 0)
        {
            for (Card card : cards)
            {
                if(card.getValue() == valueOfSuitCombinationCard)
                {
                    suitCombination = card.getSuit();
                }
            }
        }
        int counterSuitCombination = 0;
        for (Card card : cards)
        {
            if(card.getValue() > 9 && card.getSuit() == suitCombination)
            {
                counterSuitCombination++;
            }
        }
        if(counterSuitCombination > 4)
        {
            currentCombination = Combination.RoyalFlush;
        }
        player.setCurrentCombination(currentCombination);
    }
}
