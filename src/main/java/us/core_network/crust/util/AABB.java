package us.core_network.crust.util;

import org.bukkit.Location;
import org.bukkit.World;

import java.io.Serializable;

/**
 * Axis-aligned bounding-box
 */
public class AABB implements Serializable {
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

    public Location getLowerCorner(World world) {
        return new Location(world, xBounds.getLower(), 0, zBounds.getLower());
    }

    public Location getUpperCorner(World world) {
        return new Location(world, xBounds.getUpper(), 0, zBounds.getUpper());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AABB aabb = (AABB) o;

        if (xBounds != null ? !xBounds.equals(aabb.xBounds) : aabb.xBounds != null) return false;
        return !(zBounds != null ? !zBounds.equals(aabb.zBounds) : aabb.zBounds != null);
    }

    @Override
    public int hashCode() {
        int result = xBounds != null ? xBounds.hashCode() : 0;
        result = 31 * result + (zBounds != null ? zBounds.hashCode() : 0);
        return result;
    }
}
