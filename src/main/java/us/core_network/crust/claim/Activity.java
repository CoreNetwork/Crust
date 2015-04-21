package us.core_network.crust.claim;

import java.util.HashMap;
import java.util.Map;

public enum Activity {
    ACCESS_DOOR,
    ACCESS_GATE,
    OPEN_CHEST,
    OPEN_HOPPER,
    OPEN_DISPENSER,
    TRADE,
    HURT_ANIMAL,
    PLACE_LEAD,
    PLACE_VEHICLE,
    PLACE_BLOCK,
    RESIZE,
    DELETE,
    ADD_MEMBERS,
    DISOWN_MEMBERS;

    public static Map<Activity, Boolean> getAllAllow() {
        return getAs(true, values());
    }

    public static Map<Activity, Boolean> getAllDeny() {
        return getAs(false, values());
    }

    public static Map<Activity, Boolean> getAs(Boolean allow, Activity... activities) {
        HashMap<Activity, Boolean> ret = new HashMap<Activity, Boolean>();
        for (Activity activity : activities) {
            ret.put(activity, allow);
        }
        return ret;
    }
}
