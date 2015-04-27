package us.core_network.crust.claim.manipulation;

        import org.bukkit.Location;
        import org.bukkit.entity.Player;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.player.PlayerInteractEvent;
        import org.bukkit.event.player.PlayerItemHeldEvent;
        import org.bukkit.inventory.ItemStack;
        import us.core_network.crust.CrustPlugin;
        import us.core_network.crust.claim.Claim;
        import us.core_network.crust.config.ItemConfig;

        import java.util.HashMap;
        import java.util.Set;

/**
 * Handles events relevant to setting up claims and resizing them
 */
public class ManipulationListener implements Listener {
    private static ManipulationListener instance;

    {
        instance = this;
    }

    private HashMap<Player, ManipulationHandler> handlers = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem().getType() == ItemConfig.CLAIM_MANIPULATE_TOOL && event.getClickedBlock() != null) {
            // create claim?
            Location click = event.getClickedBlock().getLocation();
            Set<Claim> claim = CrustPlugin.getInstance().getClaims().get(click);

            if (handlers.get(event.getPlayer()) == null && claim.isEmpty()) {
                CreateHandler handler = new CreateHandler();
                handler.setup(event.getPlayer());
                handler.handleManipulation(click);
                handlers.put(event.getPlayer(), handler);
            } else {
                handlers.get(event.getPlayer()).handleManipulation(click);
            }
        }
    }

    public static void remove(ManipulationHandler manipulationHandler) {
        instance.handlers.remove(manipulationHandler.getPlayer());
    }

    @EventHandler
    public void onActiveSlotChange(PlayerItemHeldEvent event) {
        ItemStack previousItem = event.getPlayer().getInventory().getItem(event.getPreviousSlot());
        ItemStack newItem = event.getPlayer().getInventory().getItem(event.getNewSlot());

        if (previousItem.getType() == ItemConfig.CLAIM_MANIPULATE_TOOL && newItem.getType() != ItemConfig.CLAIM_MANIPULATE_TOOL) {
            ManipulationHandler handler = handlers.get(event.getPlayer());
            if (handler != null) {
                handler.abort();
            }
        }
        if (previousItem.getType() != ItemConfig.CLAIM_MANIPULATE_TOOL && newItem.getType() == ItemConfig.CLAIM_MANIPULATE_TOOL) {
            //TODO print remaining claim blocks
            event.getPlayer().sendMessage("You have this and that many claim blocks left.");
        }
    }
}
