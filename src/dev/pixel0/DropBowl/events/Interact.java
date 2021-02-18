package dev.pixel0.DropBowl.events;

import dev.pixel0.DropBowl.DropBowl;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {

    private DropBowl plugin = DropBowl.get();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (event.getItem().getType() == null) return;

        if (event.getItem().getType().equals(Material.BOWL)) {

            if (!plugin.getConfig().getBoolean("enabled")) return;
            if (!event.getPlayer().hasPermission(plugin.getConfig().getString("node"))) return;

            event.getPlayer().getInventory().remove(Material.BOWL);
        }

    }

}
