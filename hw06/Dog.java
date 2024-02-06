package hw06;

public class Dog extends Pet {
  private double droolRate;

  private static final double DEFAULT_DROOL_RATE = 5.0;

  public Dog (String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
  }

  public Dog (String name, double health, int painLevel) {
    this(name, health, painLevel, DEFAULT_DROOL_RATE);
  }

  public double getDroolRate() {
    return droolRate;
  }

  public int treat() {
    int min;
    if (droolRate < 3.5) {
      min = (int) Math.ceil((getPainLevel() * 2)/ getHealth());
    } else if (droolRate <= 7.5) {
      min = (int) Math.ceil(getPainLevel() / getHealth());
    } else {
      min = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
    }
    heal();
    
    return min;
  }

  public void speak() {
    super.speak();
    String sound = getPainLevel() > 5 ? "BARK " : "bark ";
    String output = "";

    for (int p = 0; p < getPainLevel(); p++) {
      output = output + sound;
    }
    System.out.println(output.trim());
  }

  public boolean equals(Object o) {
    if (o instanceof Dog) {
      Dog d = (Dog) o;
      return super.equals(d) && d.droolRate == this.droolRate;
    }

    return false;
  }
}
