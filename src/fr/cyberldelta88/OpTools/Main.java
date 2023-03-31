package fr.cyberldelta88.OpTools;

import fr.cyberldelta88.OpTools.commands.Cmdoptools;
import fr.cyberldelta88.OpTools.listeners.ClickGuiEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("OpTools is started");

        this.getCommand("optools").setExecutor(new Cmdoptools());

        getServer().getPluginManager().registerEvents(new ClickGuiEvent(), this);
    }


    @Override
    public void onDisable() {
        System.out.println("OpTools is stoped");
    }
}
