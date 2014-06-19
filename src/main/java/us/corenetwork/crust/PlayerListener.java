package us.corenetwork.crust;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {
  
  private CrustPlayer getPlayer(Player p) {
    return Crust.instance.store.getPlayer(p);
  }
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    CrustPlayer cPlayer = this.getPlayer(player);
    Action action = event.getAction();
    Block block = event.getClickedBlock();
    ItemStack item = event.getItem();
    RootClaim claim;
    
    // Right-clicking with a Bone in hand
    if (action == Action.RIGHT_CLICK_BLOCK && item.getType() == Material.BONE) {
      claim = Crust.instance.store.getClaimForBlock(block);
      
      if (claim == null) {
        if (cPlayer.claimBeingCreated != null) {
          claim = cPlayer.claimBeingCreated;
          claim.secondCorner = block.getLocation();
          if (claim.size() > cPlayer.availableClaimBlocks()) {
            player.sendMessage(String.format("You would need %d more blocks to create a claim that large.", claim.size() - cPlayer.availableClaimBlocks()));
          } else if(!claim.meetsMinimumSizelength()){
            player.sendMessage(String.format("Claim too small, must be at least %dx%d blocks", RootClaim.minimumClaimSideLength, RootClaim.minimumClaimSideLength));
          } else {
            // successful claim creation
            claim.name = cPlayer.generateClaimName();
            cPlayer.addClaim(claim);
            player.sendMessage("Claim created: " + claim.name);
            Crust.instance.store.addClaim(claim);
            Visualization viz = Visualization.forClaim(claim);
            Visualization.Apply(player, viz);
            cPlayer.claimBeingCreated = null;
          }
        } else if (cPlayer.claimBeingResized != null ) {
          
        } else {
          String reason = cPlayer.canCreateClaim();
          if (reason.equalsIgnoreCase("")) {
            claim = new RootClaim(cPlayer.id);
            claim.firstCorner = block.getLocation();
            claim.world = block.getLocation().getWorld();
            cPlayer.claimBeingCreated = claim;
            Visualization viz = Visualization.forClaimCreation(block.getLocation());
            Visualization.Apply(player, viz);
          } else {
            player.sendMessage(reason);
          }
        }
      } else {
        Visualization viz = Visualization.forClaim(claim);
        Visualization.Apply(player, viz);
        // If they click on the corner of their own claim, then start resizing
        if(claim.ownerId == player.getUniqueId() && claim.isCorner(block.getLocation()) ) {
//          claim.
          cPlayer.claimBeingResized = claim;
          player.sendMessage(String.format("Resizing %s",claim.name));
        }
      }
    }
  }

}
