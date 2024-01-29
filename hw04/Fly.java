package hw04;

public class Fly {
  private double mass;
  private double speed;

  public static final double DEFAULT_MASS = 5;
  public static final double DEFAULT_SPEED = 10;

  // constructor chaining
  public Fly() {
    this(DEFAULT_MASS, DEFAULT_SPEED);
  }

  public Fly(double mass) {
    this(mass, DEFAULT_SPEED);
  }

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  // getter
  public double getMass() {
    return this.mass;
  }

  public double getSpeed() {
    return this.speed;
  }

  // setter
  public void setMass(double newMass) {
    if (newMass >= 0) {
      this.mass = newMass;
    }
  }

  public void setSpeed(double newSpeed) {
    if (newSpeed >= 0) {
      this.speed = newSpeed;
    }
  }

  // toString
  public String toString() {
    if (mass == 0) {
      return "I'm dead, but I used to be a fly with a speed of " + speed + ".";
    } else {
      return "I'm a speedy fly with " + String.format("%.2f", speed) + " speed and " + mass + " mass.";
    }
  }

  // grow
  public void grow(int addedMass) {
    for (int i = 0; i < addedMass; i++) {
      mass++;
      if (mass <= 20) {
        speed++;
      } else {
        speed = speed - 0.5;
      };
    }
  }

  public boolean isDead() {
    return mass == 0 ? true : false;
  }

  // remove upon submission
  public static void main(String[] args) {
    Fly flyOne = new Fly();
    System.out.println(flyOne.toString());
    Fly flyTwo = new Fly(10, 50);
    System.out.println(flyTwo.toString());
    
    flyTwo.grow(45);
    System.out.println(flyTwo.toString());
  }
}
