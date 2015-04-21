package us.core_network.crust.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

/**
 * has helper methods to draw various visualizations
 */
public class Visualizations {
    public static void drawFirstEdge(Visualization vis, Location edge) {
        vis.setBlock(edge, Material.DIAMOND_BLOCK);
    }

    public static void drawBorder(Visualization vis, Location firstEdge, Location secondEdge) {
        int minX, minZ, maxX, maxZ;

        minX = Math.min(firstEdge.getBlockX(), secondEdge.getBlockX());
        minZ = Math.min(firstEdge.getBlockZ(), secondEdge.getBlockZ());
        maxX = Math.max(firstEdge.getBlockX(), secondEdge.getBlockX());
        maxZ = Math.max(firstEdge.getBlockZ(), secondEdge.getBlockZ());

        World world = firstEdge.getWorld();
        // draw 4 corners
        drawAtHighestY(vis, minX, minZ, world, Material.GLOWSTONE);
        drawAtHighestY(vis, minX, maxZ, world, Material.GLOWSTONE);
        drawAtHighestY(vis, maxX, minZ, world, Material.GLOWSTONE);
        drawAtHighestY(vis, maxX, maxZ, world, Material.GLOWSTONE);
    }

    private static void drawAtHighestY(Visualization vis, int x, int z, World world, Material material) {
        int y = world.getHighestBlockYAt(x, z) - 1;
        vis.setBlock(x, y, z, material);
    }
}
