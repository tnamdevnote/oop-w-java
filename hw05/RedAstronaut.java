package hw05;

import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
  private String skill;

  private static final int DEFAULT_SUSLEVEL = 15;
  private static final String DEFAULT_SKILL = "experienced";

  public RedAstronaut(String name) {
    this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
  }

  public RedAstronaut (String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }

  public void emergencyMeeting() {
    if (isFrozen()) {
      return;
    }

    int nonFrozenPlayerCount = 0;
    Player[] players = getPlayers();

    for (Player p: players) {
      if (!p.isFrozen() && !p.equals(this)) {
        nonFrozenPlayerCount++;
      }
    }

    if (nonFrozenPlayerCount == 0) {
      return;
    } 
    if (nonFrozenPlayerCount == 1) {
      for (Player p: players) {
        if (!p.isFrozen() && !p.equals(this)) {
          p.setFrozen(true);
        }
      }
    }
    if (nonFrozenPlayerCount >= 2) {
      Player[] nonFrozenPlayers = new Player[nonFrozenPlayerCount];
      int count = 0;
      for (Player p: players) {
        if (!p.isFrozen() && !p.equals(this)) {
          nonFrozenPlayers[count] = p;
          count++;
        }
      }
      nonFrozenPlayers = Arrays.copyOf(nonFrozenPlayers, count);

      Arrays.sort(nonFrozenPlayers);
      // retrieve the last item in the array, which has the highest susLevel
      int length = nonFrozenPlayers.length;
      Player playerWithHighestSusLevel = nonFrozenPlayers[length-1];

      // vote. freeze the player with highest suslevel
      if (playerWithHighestSusLevel.getSusLevel() != nonFrozenPlayers[length-2].getSusLevel()) {
        playerWithHighestSusLevel.setFrozen(true);
        gameOver();
      };

    }
  }

  // public void emergencyMeeting() {
  //   if (isFrozen()) {
  //     return;
  //   }
  //   Player[] players = getPlayers();
  //   // sort the array
  //   Arrays.sort(players);
  //   // retrieve the last item in the array, which has the highest susLevel
  //   int length = players.length;
  //   Player playerWithHighestSusLevel = players[length-1];

  //   // vote. freeze the player with highest suslevel
  //   if (playerWithHighestSusLevel.getSusLevel() != players[length-2].getSusLevel()) {
  //     playerWithHighestSusLevel.setFrozen(true);
  //     gameOver();
  //   };
  // }

  public void freeze(Player p) {
    if (!isFrozen() && p instanceof Crewmate && !p.isFrozen()) {
      if (getSusLevel() < p.getSusLevel()) {
        p.setFrozen(true);
      } else {
        int currentSusLevel = getSusLevel();
        setSusLevel(currentSusLevel * 2);
      }
      gameOver();
    }
  }

  public void sabotage(Player p) {
    if (!isFrozen() && p instanceof Crewmate && !p.isFrozen()) {
      int crewmateSusLevel = p.getSusLevel();
      if (getSusLevel() < 20) {
        p.setSusLevel((int)(crewmateSusLevel * 1.5));
      } else {
        p.setSusLevel((int)(crewmateSusLevel * 1.25));
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RedAstronaut) {
        RedAstronaut player = (RedAstronaut) o;
        return getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                && getSusLevel() == player.getSusLevel() && skill == player.skill;
    }
    return false;
  }

  @Override
  public String toString() {
    String message = super.toString() + ". I am an " + skill + " player!";
    if (getSusLevel() > 15) {
      return message.toUpperCase();
    } else {
      return message;
    }
  }
}
