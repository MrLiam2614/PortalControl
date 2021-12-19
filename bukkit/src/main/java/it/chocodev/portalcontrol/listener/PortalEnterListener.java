package it.chocodev.portalcontrol.listener;

import it.chocodev.portalcontrol.PortalControlImpl;
import it.chocodev.portalcontrol.player.AccessType;
import it.chocodev.portalcontrol.player.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalEnterListener implements Listener {

    @EventHandler
    public void on(PlayerTeleportEvent event) {
        if (!(event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)
                || event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)
                || event.getTo().getWorld().getName().contains("_nether")
                || event.getTo().getWorld().getName().contains("_the_end"))) {
            return;
        }

        PlayerManager playerManager = PortalControlImpl.getInstance().getPlayerManager();

        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) || event.getTo().getWorld().getName().contains("_nether")) {
            if(!playerManager.hasAccess(event.getPlayer(), AccessType.NETHER)) {
                event.setCancelled(true);
                sendMessage(event.getPlayer(), "&4You don't have access to the Nether");
                sendMessage(event.getPlayer(), "&4Complete the advancement: &7" + playerManager.getNetherRequirement());
            }
        }

        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL) || event.getTo().getWorld().getName().contains("_the_end")) {
            if(!playerManager.hasAccess(event.getPlayer(), AccessType.END)) {
                event.setCancelled(true);
                sendMessage(event.getPlayer(), "&4You don't have access to the end");
                sendMessage(event.getPlayer(), "&4Complete the advancement: &7" + playerManager.getEndRequirement());
            }
        }
    }

    public void sendMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
