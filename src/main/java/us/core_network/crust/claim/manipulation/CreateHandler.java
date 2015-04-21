package us.core_network.crust.claim.manipulation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import us.core_network.crust.CrustPlugin;
import us.core_network.crust.claim.Claim;
import us.core_network.crust.util.AABB;
import us.core_network.crust.util.Visualization;
import us.core_network.crust.util.Visualizations;

import java.util.Set;

/**
 * handles creating claims
 */
public class CreateHandler implements ManipulationHandler {
    private Player player;
    private Visualization vis;
    private Location firstEdge = null;

    @Override
    public void setup(Player player) {
        this.player = player;
        vis = new Visualization(player);
    }

    @Override
    public void handleManipulation(Location click) {
        if (firstEdge == null) {
            firstEdge = click;
            Visualizations.drawFirstEdge(vis, firstEdge);
            getPlayer().sendMessage("Claim first corner set.");
        } else {
            Set<Claim> claims = CrustPlugin.getInstance().getClaims().get(click);
            if (claims.isEmpty()) {
                vis.reset();
                Visualizations.drawBorder(vis, firstEdge, click);
                int minX = Math.min(firstEdge.getBlockX(), click.getBlockX());
                int minZ = Math.min(firstEdge.getBlockZ(), click.getBlockZ());
                int maxX = Math.max(firstEdge.getBlockX(), click.getBlockX());
                int maxZ = Math.max(firstEdge.getBlockZ(), click.getBlockZ());
                Claim claim = new Claim(new AABB(minX, minZ, maxX, maxZ));
                CrustPlugin.getInstance().getClaims().put(claim.getHorizontalBounds(), claim);
                getPlayer().sendMessage("Claim created.");
                abort();
            } else {
                getPlayer().sendMessage("There's already a claim there.");
                claims.forEach(claim -> {
                    Visualizations.drawBorder(vis, claim.getHorizontalBounds().getLowerCorner(player.getWorld()), claim.getHorizontalBounds().getUpperCorner(player.getWorld()));
                });
            }
        }
    }

    @Override
    public void abort() {
        ManipulationListener.remove(this);
    }

    public Player getPlayer() {
        return player;
    }
}
