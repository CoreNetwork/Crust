package us.core_network.crust.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.LinkedList;

/**
 * Represents a visualization for one player. Keeps track of which blocks are overwritten to be able to clear it later
 */
public class Visualization {
    private Player player;
    private World world;
    private LinkedList<VisualizationRecord> records = new LinkedList<>();

    public Visualization(Player player) {
        this.player = player;
        this.world = player.getWorld();
    }

    public void reset() {
        records.stream().forEach(record -> player.sendBlockChange(record.getLocation(), record.getLocation().getBlock().getType(), record.getLocation().getBlock().getData()));
        records.clear();
    }

    public void setBlock(int x, int y, int z, Material material) {
        setBlock(x, y, z, material, (byte) 0);
    }

    public void setBlock(int x, int y, int z, Material material, byte data) {
        setBlock(new Location(world, x, y, z), material, data);
    }

    public void setBlock(Location location, Material material) {
        setBlock(location, material, (byte) 0);
    }

    public void setBlock(Location location, Material material, byte data) {
        records.add(new VisualizationRecord(location, material, data));

        player.sendBlockChange(location, material, data);
    }

    private class VisualizationRecord {
        private Location location;
        private Material material;
        private byte data;

        public VisualizationRecord(Location location, Material material, byte data) {
            this.location = location;
            this.material = material;
            this.data = data;
        }

        public Location getLocation() {
            return location;
        }

        public Material getMaterial() {
            return material;
        }

        public byte getData() {
            return data;
        }
    }
}
