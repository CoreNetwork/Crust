package us.core_network.crust.claim;

public abstract class ClaimAbilities {
    private ClaimAbilities parent = null;

    public ClaimAbilities(ClaimAbilities parent) {
        this.parent = parent;
    }

    public abstract boolean hasPermission(Activity activity);

    public ClaimAbilities getParent() {
        return parent;
    }
}
