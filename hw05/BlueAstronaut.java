package hw05;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
  private int numTasks;
  private int taskSpeed;

  private static final int DEFAULT_SUSLEVEL = 15;
  private static final int DEFAULT_NUMTASKS = 6;
  private static final int DEFAULT_TASKSPEED = 10;

  public BlueAstronaut(String name) {
    this(name, DEFAULT_SUSLEVEL, DEFAULT_NUMTASKS, DEFAULT_TASKSPEED);
  }

  public BlueAstronaut (String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public int getNumTasks() {
    return numTasks;
  }

  public int getTaskSpeed() {
    return taskSpeed;
  }

  public void emergencyMeeting() {
    if (isFrozen()) {
      return;
    }

    int nonFrozenPlayerCount = 0;
    Player[] players = getPlayers();

    for (Player p: players) {
      if (!p.isFrozen()) {
        nonFrozenPlayerCount++;
      }
    }

    if (nonFrozenPlayerCount == 0) {
      return;
    } 
    if (nonFrozenPlayerCount == 1) {
      for (Player p: players) {
        if (!p.isFrozen()) {
          p.setFrozen(true);
        }
      }
    }
    if (nonFrozenPlayerCount >= 2) {
      Player[] nonFrozenPlayers = new Player[nonFrozenPlayerCount];
      int count = 0;
      for (Player p: players) {
        if (!p.isFrozen()) {
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

  public void completeTask() {
    if (isFrozen() || numTasks == 0) {
      return;
    }

    if (taskSpeed > 20) {
      numTasks -= 2;
    } else {
      numTasks -= 1;
    }

    if (numTasks < 0) {
      numTasks = 0;
    }

    if (numTasks == 0 ) {
      System.out.println("I have completed all my tasks");
      setSusLevel((int)(getSusLevel()/2));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof BlueAstronaut) {
        BlueAstronaut player = (BlueAstronaut) o;
        return getName().equals(player.getName()) 
          && this.isFrozen() == player.isFrozen()
          && getSusLevel() == player.getSusLevel()
          && numTasks == player.numTasks
          && taskSpeed == player.taskSpeed;
    }
    return false;
  }

  @Override
  public String toString() {
    String message = super.toString() + ". I have " + numTasks + " left over!";
    if (getSusLevel() > 15) {
      return message.toUpperCase();
    } else {
      return message;
    }
  }
}
