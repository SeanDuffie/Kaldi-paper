package me.seanduffie.kaldi.events;

import me.seanduffie.kaldi.items.ItemManager;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventManager implements Listener {

    /**
     *
     * @param event
     */
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
         if (event.getAction() == Action.RIGHT_CLICK_AIR) {
             if (event.getItem() == null) { return; }
             if (event.getItem().getItemMeta().equals(ItemManager.coffee.getItemMeta())) {
                 Player player = event.getPlayer();
                 player.sendMessage(Component.text("Player Right clicked with coffee"));
             }
         }
    }

    /**
     * Handles the event whenever a player joins
     * <p>
     * First time joining
     * - Sends a one time message
     * - Potentially gives an inventory kit
     * - lists coordinates of landmarks
     * - Lists online people
     * Repeat join
     * - Sends a welcome back message
     * - Lists online people
     * - Shows time of last login
     *
     * @param event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // When a player joins
//        getLogger().info("A player has entered the coffee shop!!");
        System.out.println("A player has entered the coffee shop!!");
        Player player = event.getPlayer();
        String name = player.getPlayerProfile().getName();
        event.joinMessage(Component.text(name + " is back!"));
        event.notify();
        player.sendMessage(Component.text("Welcome back!"));
    }
}
