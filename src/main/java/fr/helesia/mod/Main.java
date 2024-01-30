package fr.helesia.mod;

import fr.helesia.mod.commands.Commands;
import fr.helesia.mod.player.ListenerPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("staff").setExecutor(new Commands());
        getCommand("test").setExecutor(new Commands());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ListenerPlayer(), this);
    }

    @Override
    public void onDisable() {
    }
}
