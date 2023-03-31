package fr.cyberldelta88.OpTools.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClickGuiEvent implements Listener {

    @EventHandler
    public void clickguinevent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getName().equalsIgnoreCase(ChatColor.RED + "OpTools")) {

            switch (e.getCurrentItem().getType()) {

                case BARRIER:
                    p.closeInventory();
                    if (p.getGameMode().equals(GameMode.CREATIVE)) {
                        p.setGameMode(GameMode.SURVIVAL);
                    } else {

                        p.setGameMode(GameMode.CREATIVE);
                    }
                    break;
                case POTION:
                    p.closeInventory();
                    if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
                        p.removePotionEffect(PotionEffectType.INVISIBILITY);

                    } else {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 100));
                    }
                    break;
                case BEDROCK:
                    p.closeInventory();
                    if (p.getAllowFlight() == true) {
                        p.setAllowFlight(false);
                    } else {
                        p.setAllowFlight(true);
                    }
                    break;
                case COOKED_BEEF:
                    p.closeInventory();
                    p.setFoodLevel(20);
                    p.setSaturation(20);
                    break;
                case GOLDEN_APPLE:
                    p.closeInventory();
                    p.setHealth(20);
                    break;
            }

            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.NOTE_STICKS, 3.0F, 0.533F);
        }
    }
}
