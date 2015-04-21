package us.core_network.crust;

import com.flowpowered.cerealization.config.ConfigurationException;
import com.flowpowered.cerealization.config.annotated.AnnotatedObjectConfiguration;
import com.flowpowered.cerealization.config.yaml.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import us.core_network.crust.claim.Claim;
import us.core_network.crust.claim.manipulation.ManipulationListener;
import us.core_network.crust.config.ItemConfig;
import us.core_network.crust.util.AABBStore;

import java.io.File;
import java.util.logging.Level;

public class CrustPlugin extends JavaPlugin {
    private static CrustPlugin instance;

    public static CrustPlugin getInstance() {
        return instance;
    }

    private AABBStore<Claim> claims = new AABBStore<>();

    @Override

    public void onEnable() {
        instance = this;
        AnnotatedObjectConfiguration configuration = new AnnotatedObjectConfiguration(new YamlConfiguration(new File(getDataFolder(), "config.yml")));
        configuration.add(ItemConfig.class, "Items");
        try {
            configuration.load();
            configuration.save();
        } catch (ConfigurationException e) {
            getLogger().log(Level.SEVERE, "Could not load/save config", e);
        }

        Bukkit.getPluginManager().registerEvents(new ManipulationListener(), this);

        getLogger().info("enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("disabled.");
    }

    public AABBStore<Claim> getClaims() {
        return claims;
    }
}
