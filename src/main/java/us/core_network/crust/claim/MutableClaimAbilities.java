package us.core_network.crust.claim;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Tracks a claim's permissions
 */
public class MutableClaimAbilities extends ClaimAbilities {
    private Map<Activity, Boolean> store = new LinkedHashMap<>();

    public static ClaimAbilities buildAllowAll(ClaimAbilities parent) {
        MutableClaimAbilities claimAbilities = new MutableClaimAbilities(parent);
        claimAbilities.store = Activity.getAllAllow();
        return claimAbilities;
    }

    public static ClaimAbilities buildDenyAll(ClaimAbilities parent) {
        MutableClaimAbilities claimAbilities = new MutableClaimAbilities(parent);
        claimAbilities.store = Activity.getAllDeny();
        return claimAbilities;
    }

    public MutableClaimAbilities(ClaimAbilities parent) {
        super(parent);
    }

    public void setActivity(Activity activity, Boolean allow) {
        if (allow != null) {
            store.put(activity, allow);
        } else {
            store.remove(activity);
        }
    }

    public void setAllow(Activity activity) {
        store.put(activity, true);
    }

    public void setDeny(Activity activity) {
        store.put(activity, false);
    }

    public void setInherit(Activity activity) {
        store.remove(activity);
    }

    @Override
    public boolean hasPermission(Activity activity) {
        Boolean perm = store.get(activity);
        if (perm == null && getParent() != null) {
            return getParent().hasPermission(activity);
        } else if (perm != null) {
            return perm;
        }
        return false;
    }


}
