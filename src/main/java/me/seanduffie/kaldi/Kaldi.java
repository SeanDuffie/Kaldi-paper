package me.seanduffie.kaldi;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;
import java.util.UUID;

public final class Kaldi extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Your coffee is currently brewing ;)");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Your coffee is finished brewing :)");
    }

    /**
     * Handles the event whenever a player joins
     * <p>
     * First time joining
     * <ul>
     * <li>Sends a one time message</li>
     * <li>Potentially gives an inventory kit</li>
     * <li>lists coordinates of landmarks</li>
     * <li>Lists online people</li>
     * </ul>
     * Repeat join
     * <ul>
     * <li>Sends a welcome back message</li>
     * <li>Lists online people</li>
     * <li>Shows time of last login</li>
     * </ul>
     * </p>
     * @param event Join Event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // When a player joins
        Player player = event.getPlayer();
        String name = player.getName();
        UUID id = player.getPlayerProfile().getId();
        InetSocketAddress ip = player.getAddress();

        getLogger().info("A player (" + name + " : " + id + ") has entered the coffee shop!!");
        event.joinMessage(Component.text("Welcome back to the server, " + name + "!!!"));
    }

    /**
     * Handles the event whenever a player leaves
     * @param event Quit Event
     */
    @EventHandler
    public void onPlayerExit(PlayerQuitEvent event) {
        // When a player leaves
        Player player = event.getPlayer();
        String name = player.getName();
        UUID id = player.getPlayerProfile().getId();
        InetSocketAddress ip = player.getAddress();

        getLogger().info("A player (" + name + " : " + id + ") has left the coffee shop!");
        event.quitMessage(Component.text("Goodbye " + name + "!"));
    }
}
