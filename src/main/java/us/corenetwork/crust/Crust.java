package us.corenetwork.crust;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Crust extends JavaPlugin {

  public static Crust instance;
  
  public Store store;
  
  // Public API
  public boolean isClaimed(Location loc) {
    RootClaim claim = this.store.getClaimForBlock(loc.getBlock());
    return claim != null;
  }
  
  public boolean isClaimed(Block block) {
    RootClaim claim = this.store.getClaimForBlock(block);
    return claim != null;
  }
  
  @Override
  public void onEnable() {
    instance = this;
    store = new Store();
    
    PluginManager pluginMgr = getServer().getPluginManager();
    pluginMgr.registerEvents(new PlayerListener(), this);
    pluginMgr.registerEvents(new BlockListener(), this);
  }
	
  @Override
  public void onDisable() {
//  	getLogger().info("onDisable has been invoked!");
  }  
}
