package pl.roker2.lightning;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomPlayerPicker {
    public static Player getRandomPlayer() {
        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
        if (players.isEmpty())
            return null;
        int randomIndex = new Random().nextInt(players.size());
        List<? extends Player> playerList = new ArrayList<>(players);
        return playerList.get(randomIndex);
    }
}
