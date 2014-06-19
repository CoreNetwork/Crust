package us.corenetwork.crust;

import java.util.ArrayList;
import java.util.UUID;

public class CrustPlayer {
  
  public CrustPlayer(UUID playerId) {
    id = playerId;
  }
  
  public UUID id;
  
  public RootClaim claimBeingCreated = null;
  public RootClaim claimBeingResized = null;
  
  public int claimCountLimit = 5; 
  public int accruedClaimBlocks = 1000;
  
  private ArrayList<RootClaim> claims = new ArrayList<RootClaim>();
  
  public ArrayList<Visualization> currentVisualizations = new ArrayList<Visualization>();
  
  
  public String canCreateClaim(){
    int minimumClaimArea = (int) Math.pow(RootClaim.minimumClaimSideLength, 2);
    // Cannot create a claim if you have reached your claim count limit
    if (claims.size() >= claimCountLimit) {
      return "Cannot create claim, claim limit reached.";
    // Cannot create a claim if you don't have enough blocks to meet minimum claim size requirement
    } else if (this.availableClaimBlocks() < minimumClaimArea){
      return "Cannot create claim, you do not have enough blocks to created the minimum claim size required";
    } else {
      return "";
    }
  }
  
  public String generateClaimName() {
    String name = "Claim";
    ArrayList<String> names = new ArrayList<String>();
    for(RootClaim c : claims) {
      names.add(c.name);
    }
    int i = 1;
    while (names.contains(name + i)) {
      i+=1;
    }
    name = name + i;
    return name;
  }
  
  public int availableClaimBlocks() {
    int used = 0;
    for(RootClaim c : claims){
      used += c.size();
    }
    return accruedClaimBlocks - used;
  }
  
  public void addClaim(RootClaim claim) {
    claims.add(claim);
  }
  
  public void removeClaim(RootClaim claim) {
    if (claims.contains(claim)) {
      claims.remove(claim);
    }
  }
  
}
