package hw06;

public class Cat extends Pet {
  private int miceCaught;

  private static final int DEFAULT_MICE_CAUGHT = 0;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    this.miceCaught = miceCaught < 0 ? 0 : miceCaught;
  }

  public Cat(String name, double health, int painLevel) {
    this(name, health, painLevel, DEFAULT_MICE_CAUGHT);
  }

  public int getMiceCaught() {
    return miceCaught;
  }

  public int treat() {
    int min;
    if (miceCaught < 4) {
      min = (int) Math.ceil((getPainLevel() * 2)/ getHealth());
    } else if (miceCaught <= 7) {
      min = (int) Math.ceil(getPainLevel() / getHealth());
    } else {
      min = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
    }
    heal();
    
    return min;
  }

  public void speak() {
    super.speak();
    String sound = getPainLevel() > 5 ? "MEOW " : "meow ";
    String output = "";

    for (int p = 0; p < getPainLevel(); p++) {
      output = output + sound;
    }
    System.out.println(output.trim());
  }

  public boolean equals(Object o) {
    if (o instanceof Cat) {
      Cat d = (Cat) o;
      return super.equals(d) && d.miceCaught == this.miceCaught;
    }

    return false;
  }
}
