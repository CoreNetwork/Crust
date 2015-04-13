package us.core_network.crust.util;

import org.bukkit.Location;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Stores objects along with an AABB-key. Provides lookup methods for locations that return all objects whose AABB-key returns true for isInside.
 */
public class AABBStore<T> {
    LinkedHashMap<AABB, T> store = new LinkedHashMap<AABB, T>();

    public Set<T> get(Location location) {
        return get(location.getBlockX(), location.getBlockZ());
    }

    public Set<T> get(int x, int z) {
        // TODO rewrite trivial implementation
        LinkedHashSet<T> ret = new LinkedHashSet<T>();
        for (Map.Entry<AABB, T> entry : store.entrySet()) {
            if (entry.getKey().isInside(x, z)) {
                ret.add(entry.getValue());
            }
        }
        return ret;
    }
}
