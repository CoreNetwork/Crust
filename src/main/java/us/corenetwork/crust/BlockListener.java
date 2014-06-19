package us.corenetwork.crust;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockListener implements Listener {
  
  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    
    ArrayList<VisualizationElement> elems = new ArrayList<VisualizationElement>();
    Visualization viz = new Visualization();
    Block block = event.getBlock();
    Location loc = block.getLocation();
    loc.setY(loc.getY() + 1);
    elems.add(new VisualizationElement(loc, Material.GOLD_BLOCK, (byte)0));
    viz.elements = elems;
    
//    Visualization.Apply(player, viz, true);
//    event.setCancelled(true);
  }
}
