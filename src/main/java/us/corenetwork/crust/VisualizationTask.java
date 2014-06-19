package us.corenetwork.crust;

import org.bukkit.entity.Player;

public class VisualizationTask implements Runnable {
  
  private Player player;
  private CrustPlayer cPlayer;
  private Visualization visualization;
  
  public VisualizationTask(Player player, CrustPlayer cPlayer, Visualization visualization) {
    this.player = player;
    this.cPlayer = cPlayer;
    this.visualization = visualization;
  }

  public void run() {
    VisualizationElement elem;
    for (int i = 0; i < visualization.elements.size(); i++) {
      elem = visualization.elements.get(i);
      player.sendBlockChange(elem.location, elem.material, elem.blockData);
    }
    
    cPlayer.currentVisualizations.add(visualization); 
  }

}
