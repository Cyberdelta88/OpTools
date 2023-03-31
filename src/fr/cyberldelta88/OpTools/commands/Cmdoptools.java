package fr.cyberldelta88.OpTools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Cmdoptools implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("op")) {
                Inventory gui = Bukkit.createInventory(p, 9, ChatColor.RED + "OpTools");


                ItemStack gamemode = new ItemStack(Material.BARRIER);
                ItemStack invisible = new ItemStack(Material.POTION);
                ItemStack fly = new ItemStack(Material.BEDROCK);
                ItemStack feed = new ItemStack(Material.COOKED_BEEF);
                ItemStack heal = new ItemStack(Material.GOLDEN_APPLE);

                ItemMeta MetaGamemode = gamemode.getItemMeta();
                MetaGamemode.setDisplayName(ChatColor.DARK_BLUE + "Gamemode");
                ArrayList<String> gamemodelore = new ArrayList<>();
                gamemodelore.add(ChatColor.BLUE + "Switch your gamemode :");
                gamemodelore.add(ChatColor.BLUE + "from creative to survival");
                gamemodelore.add(ChatColor.BLUE + "or from survival to creative");
                MetaGamemode.setLore(gamemodelore);
                gamemode.setItemMeta(MetaGamemode);

                ItemMeta MetaIvisible = invisible.getItemMeta();
                MetaIvisible.setDisplayName(ChatColor.DARK_GREEN + "Vanish");
                ArrayList<String> invisiblelore = new ArrayList<>();
                invisiblelore.add(ChatColor.GREEN + "Puts you invisible or visible");
                MetaIvisible.setLore(invisiblelore);
                invisible.setItemMeta(MetaIvisible);

                ItemMeta Metafly = fly.getItemMeta();
                Metafly.setDisplayName(ChatColor.DARK_AQUA + "Fly");
                ArrayList<String> flylore = new ArrayList<>();
                flylore.add(ChatColor.AQUA + "Switch your fly mode");
                MetaIvisible.setLore(flylore);
                fly.setItemMeta(Metafly);

                ItemMeta MetaHeal = heal.getItemMeta();
                MetaHeal.setDisplayName(ChatColor.DARK_PURPLE + "Heal");
                heal.setItemMeta(MetaHeal);

                ItemMeta Metafeed = feed.getItemMeta();
                Metafeed.setDisplayName(ChatColor.DARK_GRAY + "Feed");
                feed.setItemMeta(Metafeed);



                ItemStack[] guicontent = {gamemode, invisible, fly, feed, heal};
                gui.setContents(guicontent);

                p.openInventory(gui);
            }


        }


        return true;
    }
}
