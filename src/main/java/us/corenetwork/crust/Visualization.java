package us.corenetwork.crust;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Visualization {
  
  public ArrayList<VisualizationElement> elements = new ArrayList<VisualizationElement>();
  
  public static void Apply(Player player, Visualization visualization) {
    Apply(player, visualization, true);
  }
  
  public static void Apply(Player player, Visualization visualization, Boolean cancelCurrent){
    CrustPlayer cPlayer = Crust.instance.store.getPlayer(player);   
    if (cancelCurrent && cPlayer.currentVisualizations.size() > 0 ) {
      Visualization.Revert(player);
    }
    Crust.instance.getServer().getScheduler().scheduleSyncDelayedTask(Crust.instance, new VisualizationTask(player, cPlayer, visualization), 5L);
  }
  
  public static void Revert(Player player) {
    CrustPlayer cPlayer = Crust.instance.store.getPlayer(player);
    
    if (cPlayer.currentVisualizations.size() > 0 && player.isOnline()){
      VisualizationElement elem;
      Block block;
      for (Visualization viz : cPlayer.currentVisualizations){
        for (int i = 0; i < viz.elements.size(); i++ ){
          elem = viz.elements.get(i);
          block = elem.location.getBlock();
          player.sendBlockChange(elem.location, block.getType(), block.getData());
        }
      }
    }
  }
  
  public static Visualization forClaimCreation(Location loc) {
    Visualization visualization = new Visualization();
    
    ArrayList<VisualizationElement> elems = visualization.elements;
    
    elems.add(new VisualizationElement(new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()), Material.DIAMOND_BLOCK));
    elems.add(new VisualizationElement(new Location(loc.getWorld(), loc.getBlockX()-1, loc.getBlockY(), loc.getBlockZ()), Material.DIAMOND_BLOCK));
    elems.add(new VisualizationElement(new Location(loc.getWorld(), loc.getBlockX()+1, loc.getBlockY(), loc.getBlockZ()), Material.DIAMOND_BLOCK));
    elems.add(new VisualizationElement(new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()-1), Material.DIAMOND_BLOCK));
    elems.add(new VisualizationElement(new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()+1), Material.DIAMOND_BLOCK));
    
    return visualization;
  }

  public static Visualization forClaim(RootClaim claim) {
    Visualization visualization = new Visualization();
    Material cornerMaterial = Material.GLOWSTONE;
    Material accentMaterial = Material.GOLD_BLOCK;
    
    ArrayList<VisualizationElement> elems = visualization.elements;
    
    int smallX = Math.min(claim.firstCorner.getBlockX(), claim.secondCorner.getBlockX());
    int largeX = Math.max(claim.firstCorner.getBlockX(), claim.secondCorner.getBlockX());
    
    int smallZ = Math.min(claim.firstCorner.getBlockZ(), claim.secondCorner.getBlockZ());
    int largeZ = Math.max(claim.firstCorner.getBlockZ(), claim.secondCorner.getBlockZ());
    
    int y = claim.firstCorner.getBlockY();
    
    World w = claim.firstCorner.getWorld();
    
    // Add the four corners
    elems.add(new VisualizationElement(new Location(w, smallX, y, smallZ), cornerMaterial));
    elems.add(new VisualizationElement(new Location(w, smallX+1, y, smallZ), accentMaterial));
    elems.add(new VisualizationElement(new Location(w, smallX, y, smallZ+1), accentMaterial));
    
    elems.add(new VisualizationElement(new Location(w, smallX, y, largeZ), cornerMaterial));
    elems.add(new VisualizationElement(new Location(w, smallX+1, y, largeZ), accentMaterial));
    elems.add(new VisualizationElement(new Location(w, smallX, y, largeZ-1), accentMaterial));
    
    elems.add(new VisualizationElement(new Location(w, largeX, y, smallZ), cornerMaterial));
    elems.add(new VisualizationElement(new Location(w, largeX-1, y, smallZ), accentMaterial));
    elems.add(new VisualizationElement(new Location(w, largeX, y, smallZ+1), accentMaterial));
    
    elems.add(new VisualizationElement(new Location(w, largeX, y, largeZ), cornerMaterial));
    elems.add(new VisualizationElement(new Location(w, largeX-1, y, largeZ), accentMaterial));
    elems.add(new VisualizationElement(new Location(w, largeX, y, largeZ-1), accentMaterial));
    
    // Add the four sides
    for (int i=smallX+1; i < largeX; i+=4){
      elems.add(new VisualizationElement(new Location(w, i, y, smallZ), accentMaterial));
      elems.add(new VisualizationElement(new Location(w, i, y, largeZ), accentMaterial));
    }
    
    for (int i=smallZ+1; i < largeZ; i+=4){
      elems.add(new VisualizationElement(new Location(w, smallX, y, i), accentMaterial));
      elems.add(new VisualizationElement(new Location(w, largeX, y, i), accentMaterial));
    }
    
    
    return visualization;
  }

}
