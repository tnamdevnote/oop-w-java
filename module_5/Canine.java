package module_5;

public abstract class Canine {
  protected double size;

  public Canine(double size) {
    this.size = size;
  }

  public void bark() {
    System.out.println("Woof woof");
  }
  public abstract void groom();
}
