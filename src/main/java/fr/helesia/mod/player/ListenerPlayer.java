package fr.helesia.mod.player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class ListenerPlayer implements Listener {

    @EventHandler
    public void click(InventoryClickEvent e){
        if(e.getInventory().getName() == "§fListe du staffs"){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void join(PlayerJoinEvent e){
    }
}
