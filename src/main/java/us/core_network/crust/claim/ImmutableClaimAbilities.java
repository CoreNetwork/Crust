package us.core_network.crust.claim;

import java.util.Map;

/**
 * Claim ability provider which is immutable. Use for owners so they can't remove abilities from themselves
 */
public class ImmutableClaimAbilities extends MutableClaimAbilities {
    public ImmutableClaimAbilities(ClaimAbilities parent, Map<Activity, Boolean> init) {
        super(parent);
        for (Map.Entry<Activity, Boolean> entry : init.entrySet()) {
            super.setActivity(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void setActivity(Activity activity, Boolean allow) {

    }

    @Override
    public void setAllow(Activity activity) {

    }

    @Override
    public void setDeny(Activity activity) {

    }

    @Override
    public void setInherit(Activity activity) {

    }
}

