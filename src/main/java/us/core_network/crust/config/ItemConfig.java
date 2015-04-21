package us.core_network.crust.config;

import com.flowpowered.cerealization.config.annotated.Setting;
import org.bukkit.Material;

public class ItemConfig {
    @Setting("ClaimManipulationTool")
    public static Material CLAIM_MANIPULATE_TOOL = Material.BONE;
}
