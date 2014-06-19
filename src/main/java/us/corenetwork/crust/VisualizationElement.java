package us.corenetwork.crust;

import org.bukkit.Location;
import org.bukkit.Material;

public class VisualizationElement {
  public Location location;
  public Material material;
  public byte blockData;
  
  public VisualizationElement(Location location, Material material) {
    this.location = location;
    this.material = material;
    this.blockData = (byte) 0;
  }
  
  public VisualizationElement(Location location, Material material, byte blockData) {
    this.location = location;
    this.material = material;
    this.blockData = blockData;
  }

}
