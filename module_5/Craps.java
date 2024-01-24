package module_5;

public class Craps {
  private Die die1, die2;
  private int point;

  public Craps() {
    die1 = new Die();
    die2 = new Die();
  }

  private int toss() {
    int total = die1.roll() + die2.roll();
    System.out.println("Die One: " + die1.getFaceValue() + " Die Two: " + die2.getFaceValue());
    
    return total;
  };

  public void go() {
    point = toss();

    if ((point == 7) || (point == 11)) {
      System.out.println("You win!");
    } else if ((point == 2) || (point == 3) || (point == 11)) {
      System.out.println("You lost!");
    } else {
      System.out.println("Proceeding to next round");
      stage2();
    }
  };

  private void stage2() {
    boolean endGame = false;

    while (!endGame) {
      int total = toss();
      if (total == point) {
        endGame = true;
        System.out.println("You win!");
      } else if (total == 7) {
        endGame = true;
        System.out.println("You lost!");
      }
    }
  }

  public static void main(String args[]) {
    Craps game = new Craps();

    game.go();
  }
}
