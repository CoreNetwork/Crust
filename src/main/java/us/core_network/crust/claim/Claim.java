package us.core_network.crust.claim;

import us.core_network.crust.util.AABB;
import us.core_network.crust.util.Bounds;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Claim
 */
public class Claim {
    private AABB horizontalBounds;
    private Bounds verticalBounds;
    private Map<Group, ClaimAbilities> groups = new LinkedHashMap<Group, ClaimAbilities>();
    private ListGroup owners = new ListGroup();
    private ListGroup members = new ListGroup();
    private AllGroup anybody = new AllGroup();
    private Claim parentClaim = null;

    public Claim(AABB horizontalBounds) {
        this(horizontalBounds, null, null);
    }

    public Claim(AABB horizontalBounds, Bounds verticalBounds, Claim parentClaim) {
        this.horizontalBounds = horizontalBounds;
        this.verticalBounds = verticalBounds;
        this.parentClaim = parentClaim;

        this.groups.put(owners, MutableClaimAbilities.buildAllowAll());
        this.groups.put(members, MutableClaimAbilities.buildAllowAll());
        this.groups.put(anybody, MutableClaimAbilities.buildDenyAll());
    }

    public AABB getHorizontalBounds() {
        return horizontalBounds;
    }

    public Bounds getVerticalBounds() {
        return verticalBounds;
    }
}
