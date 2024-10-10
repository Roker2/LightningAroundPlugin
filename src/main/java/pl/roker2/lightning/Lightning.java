package pl.roker2.lightning;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public final class Lightning extends JavaPlugin {
    BukkitTask task = null;
    static final long n = 5L; // seconds

    @Override
    public void onEnable() {
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
}
