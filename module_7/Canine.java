package module_7;

public abstract class Canine implements Groomable {
  protected double size;

  public Canine(double size) {
    this.size = size;
  }

  public void bark() {
    System.out.println("Woof woof");
  }
  // we no longer need to define groom methods here, as Groomable
	// interface allows access to groom methods()
	// we are simply passing down Groomable interface to subclasses. 
  // public abstract void groom();
}
