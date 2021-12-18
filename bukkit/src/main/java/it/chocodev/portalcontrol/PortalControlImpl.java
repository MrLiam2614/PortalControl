package it.chocodev.portalcontrol;

import it.chocodev.portalcontrol.listener.PortalEnterListener;
import it.chocodev.portalcontrol.player.PlayerManagerImpl;
import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public class PortalControlImpl extends JavaPlugin implements PortalControl {
    private static PortalControlImpl instance;

    private PlayerManagerImpl playerManager;

    public static PortalControlImpl getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        PortalControlProvider.register(this);

        this.playerManager = new PlayerManagerImpl();

        Bukkit.getPluginManager().registerEvents(new PortalEnterListener(), this);
    }

    @Override
    public PlayerManagerImpl getPlayerManager() {
        return playerManager;
    }
}
