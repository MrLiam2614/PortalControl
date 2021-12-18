package it.chocodev.portalcontrol;

import it.chocodev.portalcontrol.player.PlayerManager;

public interface PortalControl {

    /**
     * Returns the instance of {@link PlayerManager}
     * @return instance of the player manager
     */
    public PlayerManager getPlayerManager();
}
