package us.core_network.crust.claim;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Group that can be queried for a player to check if it's inside that group
 */
public interface Group extends Set<UUID> {
    public String getDisplayName();
}
