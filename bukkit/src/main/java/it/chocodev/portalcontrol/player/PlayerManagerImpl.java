package it.chocodev.portalcontrol.player;

import it.chocodev.portalcontrol.PortalControlImpl;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicBoolean;

public class PlayerManagerImpl implements PlayerManager{
    private String netherRequirement;
    private String endRequirement;

    public PlayerManagerImpl() {
        initRequirements();
    }

    @Override
    public boolean hasAccess(Player player, AccessType accessType) {
        switch (accessType) {
            case NETHER:
                return hasAchievement(player, netherRequirement);
            case END:
                return hasAchievement(player, endRequirement);
            default:
                break;
        }
        return false;
    }

    @Override
    public String getEndRequirement() {
        return endRequirement;
    }

    @Override
    public String getNetherRequirement() {
        return netherRequirement;
    }

    private boolean hasAchievement(Player player, String achievement) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Bukkit.advancementIterator().forEachRemaining(advancement -> {
            if(advancement.getKey().toString().equals(achievement)) {
                if(player.getAdvancementProgress(advancement).isDone()) {
                    atomicBoolean.set(true);
                }
            }
        });
        return atomicBoolean.get();
    }

    private void initRequirements() {
        FileConfiguration fileConfiguration = PortalControlImpl.getInstance().getConfig();

        this.netherRequirement = fileConfiguration.getString("nether_required_advancement");
        this.endRequirement = fileConfiguration.getString("end_required_advancement");
    }
}
