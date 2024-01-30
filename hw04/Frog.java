package hw04;

public class Frog {
  // Instance variables
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  
  // Static/Constant variables
  private static String species = "Rare Pepe";
  public static final int DEFAULT_AGE = 5;
  public static final double DEFAULT_TONGUE_SPEED = 10;

  public Frog(String name) {
    this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int)(ageInYears * 12), tongueSpeed);
  }  

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    this.isFroglet = (age > 1 && age < 7 );
  }
  
  public static String getSpecies() {
    return species;
  }
  public static void setSpecies(String newSpecies) {
    species = newSpecies;
  }

  public void grow(int numMonths) {
    for (int i = 1; i <= numMonths; i++) {
      age++;
      if (age <= 12) {
        tongueSpeed++;
      }
      if (age > 30) {
        tongueSpeed--;
      }
    }
    tongueSpeed = (tongueSpeed < 5) ? 5 : tongueSpeed;
    isFroglet = (age > 1 && age < 7 );
  }

  public void grow() {
    grow(1);
  }

  public void eat(Fly fly) {
    if (fly.isDead()) return;
    boolean isCaught = tongueSpeed >  fly.getSpeed();
    
    if (isCaught && fly.getMass() >= 0.5 * age) {
      grow();
      fly.setMass(0);
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    if (isFroglet) {
      return "My name is " + name + " and I’m a rare froglet! I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    } else {
      return "My name is " + name + " and I’m a rare frog. I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    }
  }

  public static void main(String[] args) {
    // Fly fly = new Fly();
    // Frog frogOne = new Frog("Taek");
    // System.out.println(frogOne.toString());
    Frog frogTwo = new Frog("Yejoo", 25, 30);
    System.out.println(frogTwo.toString());
    
    frogTwo.grow(10);
    System.out.println(frogTwo.toString());
    // System.out.println(fly.getMass());
    // frogTwo.eat(fly);
    // System.out.println(frogTwo.toString());
    // System.out.println(fly.getMass());
  }
}
