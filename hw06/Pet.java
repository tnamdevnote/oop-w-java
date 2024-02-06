package hw06;

// This class represents any pet that would seek consultation from the clinic.
public abstract class Pet {
  private String name;
  private double health;
  private int painLevel;

  public Pet(String name, double health, int painLevel) {
    this.name = name;
    if (health > 1.0) {
      this.health = 1.0;
    } else if (health < 0.0) {
      this.health = 0.0;
    } else {
      this.health = health;
    }
    if (painLevel > 10) {
      this.painLevel = 10;
    } else if (painLevel < 1) {
      this.painLevel = 1;
    } else {
      this.painLevel = painLevel;
    }
  }

  // getters 
  public String getName() {
    return name;
  }

  public double getHealth() {
    return health;
  }

  public int getPainLevel() {
    return painLevel;
  }

  // abstract methods
  public abstract int treat();

  public void speak() {
    String output = String.format("Hello! My name is %s", name);
    output = (painLevel > 5) ? output.toUpperCase() : output;
    System.out.println(output);
    
  }

  public boolean equals(Object o) {
    if (o instanceof Pet) {
      Pet p = (Pet) o;
      return this.name.equals(p.name);
    }

    return false;
  }

  protected void heal() {
    health = 1.0;
    painLevel = 1;
  }
}
