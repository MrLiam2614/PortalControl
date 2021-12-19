package it.chocodev.portalcontrol.player;

import org.bukkit.entity.Player;

public interface PlayerManager {

    /**
     * Method used to check if player has the achievements to enter a portal
     * @param player the player to check if has permission
     * @param accessType the type of portal you want to check
     * @return true if player has access to portals, false if not
     */
    public boolean hasAccess(Player player, AccessType accessType);

    String getNetherRequirement();
    String getEndRequirement();
}
