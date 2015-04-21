package us.core_network.crust.claim.manipulation;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ManipulationHandler {
    void setup(Player player);
    void handleManipulation(Location click);
    void abort();

    Player getPlayer();
}
