package me.seanduffie.kaldi;

import me.seanduffie.kaldi.commands.CommandManager;
import me.seanduffie.kaldi.events.EventManager;
import me.seanduffie.kaldi.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kaldi extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Your coffee is currently brewing :)");
        ItemManager.init(); // Initializes the Item Classes
        getServer().getPluginManager().registerEvents(new EventManager(), this); // Initializes the Event Manager
        getCommand("brew-coffee").setExecutor(new CommandManager()); // Initializes the Command Manager

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Your coffee is finished brewing ;)");
    }

}
