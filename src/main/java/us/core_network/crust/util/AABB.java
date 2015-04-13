package us.core_network.crust.util;

import org.bukkit.Location;

/**
 * Axis-aligned bounding-box
 */
public class AABB {
    private Bounds xBounds, zBounds;

    public AABB(int startX, int startZ, int endX, int endZ) {
        xBounds = new Bounds(startX, endX);
        zBounds = new Bounds(startZ, endZ);
    }

    public Bounds getxBounds() {
        return xBounds;
    }

    public Bounds getzBounds() {
        return zBounds;
    }

    public boolean isInside(Location location) {
        return isInside(location.getBlockX(), location.getBlockZ());
    }

    public boolean isInside(int x, int z) {
        return xBounds.isBetween(x) && zBounds.isBetween(z);
    }
}
