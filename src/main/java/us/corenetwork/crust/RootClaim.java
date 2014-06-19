package us.corenetwork.crust;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

public class RootClaim {
  
  public RootClaim(UUID owner) {
    ownerId = owner;
    id = UUID.randomUUID();
  }
  
  public RootClaim(UUID owner, UUID uuid) {
    ownerId = owner;
    id = uuid;
  }
  
  public UUID id;
  
  public UUID ownerId;
  
  public String name;
  
  // We will be using these Locations for their X,Z coordinates exclusively as RootClaims
  // extend the full height of the world.
  public Location firstCorner;
  public Location secondCorner;
  
  public World world;
  
  public static int minimumClaimSideLength = 5;
  
  public int size() {
    int x1 = firstCorner.getBlockX();
    int x2 = secondCorner.getBlockX();
    int z1 = firstCorner.getBlockZ();
    int z2 = secondCorner.getBlockZ();
    
    return Math.abs(x1 - x2) * Math.abs(z1 - z2);
  }

  public boolean meetsMinimumSizelength() {
    int x1 = firstCorner.getBlockX();
    int x2 = secondCorner.getBlockX();
    int z1 = firstCorner.getBlockZ();
    int z2 = secondCorner.getBlockZ();
    
    return (Math.abs(x1 - x2)+1 >= minimumClaimSideLength) && (Math.abs(z1 - z2)+1 >= minimumClaimSideLength);
  }

  public boolean contains(Location location) {
    int x1 = firstCorner.getBlockX();
    int x2 = secondCorner.getBlockX();
    int z1 = firstCorner.getBlockZ();
    int z2 = secondCorner.getBlockZ();
    int xl = location.getBlockX();
    int zl = location.getBlockZ();
    
    return ( ((xl <= x1 && xl >= x2) || (xl >= x1 && xl <= x2 )) &&
         ((zl <= z1 && zl >= z2) || (zl >= z1 && zl <= z2 )) );
  }
  
  public boolean isCorner(Location location) {
    int x1 = firstCorner.getBlockX();
    int x2 = secondCorner.getBlockX();
    int z1 = firstCorner.getBlockZ();
    int z2 = secondCorner.getBlockZ();
    int xl = location.getBlockX();
    int zl = location.getBlockZ();
    
    return (xl == x1 || xl == x2) && (zl == z1 || zl == z2);
  }
  
  public ArrayList<Chunk> getChunks() {
    World world = firstCorner.getWorld();
    ArrayList<Chunk> chunks = new ArrayList<Chunk>();
    int firstChunkX = firstCorner.getChunk().getX();
    int firstChunkZ = firstCorner.getChunk().getZ();
    int secondChunkX = secondCorner.getChunk().getX();
    int secondChunkZ = secondCorner.getChunk().getZ();
    
    int lowerX = Math.min(firstChunkX, secondChunkX);
    int upperX = Math.max(firstChunkX, secondChunkX);
    int lowerZ = Math.min(firstChunkZ, secondChunkZ);
    int upperZ = Math.max(firstChunkZ, secondChunkZ);
    
    for (int i = lowerX; i <= upperX; i++) {
      for (int j = lowerZ; j <= upperZ; j++ ){
        chunks.add(world.getChunkAt(i, j));
      }
    }
    
    return chunks;
  }
}
