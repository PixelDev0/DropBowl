package dev.pixel0.DropBowl;

import dev.pixel0.DropBowl.events.Interact;
import org.bukkit.plugin.java.JavaPlugin;

public class DropBowl extends JavaPlugin {

    private static DropBowl instance;

    private Metrics metrics;
    private final int metricsPluginId = 10377;

    public void onEnable() {
        setInstance(this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
        getConfig().options().copyDefaults(true);
        saveConfig();

        if (getConfig().getBoolean("metrics.enabled")) {
            this.metrics = new Metrics(this, metricsPluginId);
        }
    }
    
    public static DropBowl get() {
        return instance;
    }

    public static void setInstance(DropBowl instance) {
        DropBowl.instance = instance;
    }

}
