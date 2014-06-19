package us.corenetwork.crust;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Store {
  
  private ConcurrentHashMap<String, ArrayList<RootClaim>> chunks = new ConcurrentHashMap<String, ArrayList<RootClaim>>();
  private ArrayList<RootClaim> claimsArray = new ArrayList<RootClaim>();
  private ConcurrentHashMap<UUID, CrustPlayer> crustPlayers = new ConcurrentHashMap<UUID, CrustPlayer>();
  
  synchronized public CrustPlayer getPlayer(Player player) {
    UUID playerId = player.getUniqueId();
    
    CrustPlayer cPlayer = crustPlayers.get(playerId);
    if (cPlayer == null) {
      cPlayer = new CrustPlayer(playerId);
      crustPlayers.put(playerId, cPlayer);
    }
    return cPlayer; 
  }
  
  private String keyForChunk(Chunk c) {
    return c.getWorld().getEnvironment() + ":" + c.getX() + "," + c.getZ();
  }

  public RootClaim getClaimForBlock(Block block) {
    ArrayList<RootClaim> claims = chunks.get(keyForChunk(block.getChunk()));
    Location loc = block.getLocation();
    if (claims == null) {
      return null;
    }
    for(RootClaim c : claims) {
      if (c.contains(loc)) {
        return c;
      }
    }
    return null;
  }

  public void addClaim(RootClaim claim) {
    claimsArray.add(claim);
    ArrayList<Chunk> claimChunks = claim.getChunks();
    ArrayList<RootClaim> chunkClaims;
    String chunkKey;
    for(Chunk c : claimChunks) {
      chunkKey = keyForChunk(c);
      chunkClaims = chunks.get(chunkKey);
      if (chunkClaims == null) chunkClaims = new ArrayList<RootClaim>();
      if (!chunkClaims.contains(claim)) {
        chunkClaims.add(claim);
        chunks.put(chunkKey, chunkClaims);
      }
    }
  }
}
