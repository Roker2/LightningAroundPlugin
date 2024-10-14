package pl.roker2.lightning;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public final class Lightning extends JavaPlugin {
    BukkitTask task = null;
    long n = 5L; // seconds

    @Override
    public void onEnable() {
        saveDefaultConfig();

        n = getConfig().getLong("seconds");

        BukkitScheduler scheduler = Bukkit.getScheduler();
        task = scheduler.runTaskTimer(this,
                RandomLightningCaster::castLightning,
                0L, 20L * n);
    }

    @Override
    public void onDisable() {
        if (task != null)
            task.cancel();
    }

    private void generateDefaultConfig() {
        FileConfiguration config = getConfig();
        config.addDefault("seconds", 5L);
        config.addDefault("radius", 10);
        saveDefaultConfig();
    }
}
