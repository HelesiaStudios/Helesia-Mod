package fr.helesia.mod.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import fr.helesia.mod.utils.ItemBuilder;
import fr.thebatteur.pacapi.items.PactifyItem;
import fr.thebatteur.pacapi.items.Sprite;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("staff")){
            if(!sender.hasPermission("staff")){
                sender.sendMessage("§c\uEEEE⚠ Erreur : Tu ne dispose pas des permissions néccesaires pour exécuter cette commande !");
                return false;
            }

            Player player = (Player) sender;
            Inventory modInv = Bukkit.createInventory(null, 36, "§fListe du staffs");
            ItemStack stained_glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.SILVER).setName("§f").toItemStack();
            modInv.setItem(0, stained_glass);
            modInv.setItem(9, stained_glass);
            modInv.setItem(18, stained_glass);
            modInv.setItem(27, stained_glass);
            modInv.setItem(8, stained_glass);
            modInv.setItem(17, stained_glass);
            modInv.setItem(26, stained_glass);
            modInv.setItem(35, stained_glass);

            ItemStack ownerBanner = new ItemBuilder(Material.BANNER).setDyeColor(DyeColor.RED).setName("§cOwner").toItemStack();
            modInv.setItem(1, ownerBanner);
            if(Bukkit.getOnlinePlayers().contains("6my_")){
                ItemStack ownerFirstSkull = new ItemBuilder(Material.SKULL_ITEM,1, (byte)3).setSkullOwner("6my_").setName("§cOwner 6my_").addLoreLine("§7Statut: §cHors-ligne.").toItemStack();
                modInv.setItem(2, ownerFirstSkull);
            } else {
                ItemStack ownerFirstSkull = new ItemBuilder(Material.SKULL_ITEM,1, (byte)3).setSkullOwner("6my_").setName("§7Statut: §aEn ligne.").toItemStack();
                NBTItem nbtItem = new NBTItem(ownerFirstSkull);
                NBTCompound pacDisplayCompound = nbtItem.addCompound("PacDisplay");
                pacDisplayCompound.setString("Sprite", "BEACON_CHECK");
                pacDisplayCompound.setFloat("Scale", 0.5f);
                pacDisplayCompound.setFloat("TranslatX", 4.0f);
                pacDisplayCompound.setFloat("TranslatY", 4.0f);

                ownerFirstSkull = nbtItem.getItem();

                modInv.setItem(2, ownerFirstSkull);
            }

            player.openInventory(modInv);
        }
        if(label.equalsIgnoreCase("test")){
        }
        return false;
    }

    public ItemStack createBeaconCheckItem() {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        NBTItem nbtItem = new NBTItem(item);
        NBTCompound pacDisplayCompound = nbtItem.addCompound("PacDisplay");
        pacDisplayCompound.setString("Sprite", "BEACON_CHECK");
        pacDisplayCompound.setFloat("Scale", 0.5f);
        pacDisplayCompound.setFloat("TranslatX", 4.0f);
        pacDisplayCompound.setFloat("TranslatY", 4.0f);
        item = nbtItem.getItem();

        return item;
    }
}
