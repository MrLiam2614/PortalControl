package it.chocodev.portalcontrol.listener;

import it.chocodev.portalcontrol.PortalControlImpl;
import it.chocodev.portalcontrol.player.AccessType;
import it.chocodev.portalcontrol.player.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalEnterListener implements Listener {

    @EventHandler
    public void on(PlayerTeleportEvent event) {
        if (!(event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)
                || event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL))) {
            return;
        }

        PlayerManager playerManager = PortalControlImpl.getInstance().getPlayerManager();

        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
            if(!playerManager.hasAccess(event.getPlayer(), AccessType.NETHER)) {
                event.setCancelled(true);
            }
        }

        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)) {
            if(!playerManager.hasAccess(event.getPlayer(), AccessType.END)) {
                event.setCancelled(true);
            }
        }
    }

}
