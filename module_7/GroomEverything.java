package module_7;

public class GroomEverything {
  public static void main(String[] args) {
    Groomable[] groomer = {
      new Wolf(17.01, 3),
      new Poodle("Taek", 9, "Aesop", "Aesop"),
      new Wolf(16, 5),
      new Poodle("Yejoo", 5, "Dove", "Dove"),
      new Car("Honda", "Accord", 2009),
    };

    for (Groomable c : groomer) {
      c.groom();
      c.pay();
    }
  }
}
