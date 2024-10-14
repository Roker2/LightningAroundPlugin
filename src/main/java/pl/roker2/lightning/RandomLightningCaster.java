package pl.roker2.lightning;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class RandomLightningCaster {
    int radius;

    RandomLightningCaster(JavaPlugin plugin) {
        radius = plugin.getConfig().getInt("radius");
    }

    public void castLightning() {
        Player player = RandomPlayerPicker.getRandomPlayer();
        if (player != null) {
            World world = player.getWorld();
            Location location = getRandomPositionAroundPlayer(player);
            world.strikeLightning(location);
        }
    }

    Location getRandomPositionAroundPlayer(Player player) {
        Location location = player.getLocation();
        int newX = getRandom(location.getBlockX() - radius,
                location.getBlockX() + radius);
        int newY = getRandom(location.getBlockY() - radius,
                location.getBlockY() + radius);
        location.setX(newX);
        location.setY(newY);
        return location;
    }

    static int getRandom(int from, int to) {
        if (from < to)
            return from + new Random().nextInt(Math.abs(to - from));
        return from - new Random().nextInt(Math.abs(to - from));
    }
}