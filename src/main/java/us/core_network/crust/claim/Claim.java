package us.core_network.crust.claim;

import us.core_network.crust.util.AABB;
import us.core_network.crust.util.Bounds;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

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
    private UUID originalOwner = null;
    private Claim parentClaim = null;

    public Claim(AABB horizontalBounds) {
        this(horizontalBounds, null, null);
    }

    public Claim(AABB horizontalBounds, Bounds verticalBounds, Claim parentClaim) {
        this.horizontalBounds = horizontalBounds;
        this.verticalBounds = verticalBounds;
        this.parentClaim = parentClaim;

        ClaimAbilities parentOwners = null;
        ClaimAbilities parentMembers = null;
        ClaimAbilities parentAnybody = null;

        if (parentClaim != null) {
            parentOwners = parentClaim.groups.get(parentClaim.owners);
            parentMembers = parentClaim.groups.get(parentClaim.members);
            parentAnybody = parentClaim.groups.get(parentClaim.anybody);
        }

        this.groups.put(owners, new ImmutableClaimAbilities(parentOwners, Activity.getAllAllow()));
        this.groups.put(members, MutableClaimAbilities.buildAllowAll(parentMembers));
        this.groups.put(anybody, MutableClaimAbilities.buildDenyAll(parentAnybody));
    }

    public AABB getHorizontalBounds() {
        return horizontalBounds;
    }

    public Bounds getVerticalBounds() {
        return verticalBounds;
    }
}
