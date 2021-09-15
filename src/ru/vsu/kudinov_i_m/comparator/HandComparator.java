package ru.vsu.kudinov_i_m.comparator;

import ru.vsu.kudinov_i_m.cardsUtils.Combination;
import ru.vsu.kudinov_i_m.model.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HandComparator implements Comparator<Player>
{
    @Override
    public int compare(Player player1, Player player2)
    {
        Combination combination1 = player1.getCurrentCombination();
        Combination combination2 = player2.getCurrentCombination();

        if(combination1 == combination2)
        {
            List<Integer> values1 = player1.getValueOfCombination();
            List<Integer> values2 = player2.getValueOfCombination();
            int value1 = Collections.max(values1);
            int value2 = Collections.max(values2);

            return Integer.compare(value1, value2);
        }

        return combination1.compareTo(combination2);
    }
}
