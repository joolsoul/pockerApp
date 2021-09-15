package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.model.Player;

import java.util.List;

public class ArtificialIntelligence
{
    private List<Player> players;

    public ArtificialIntelligence(List<Player> players)
    {
        this.players = players;
    }

    private void makeBet()
    {
        for(int i = 0; i < players.size(); i++)
        {
            switch (players.get(i).getCurrentCombination())
            {
                case None:
                    Player temp = players.get(i);
                    players.remove(i);
                    boolean isPlayersChecked = true;
                    for(Player player : players)
                    {
                        if(player.isChecked())
                        {
                            isPlayersChecked = false;
                            break;
                        }
                    }
                    players.add(i, temp);
                    if(isPlayersChecked)
                    {
                        players.get(i).setChecked();
                    }
                    else
                    {
                        int maxBet = 0;
                        for (Player player : players)
                        {
                            if(player.getBet() > maxBet)
                            {
                                maxBet = player.getBet();
                            }
                        }
                    }

                case HighCard:

            }
        }
    }



}
