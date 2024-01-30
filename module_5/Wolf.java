package module_5;

public class Wolf extends Canine {
  protected int rank;

  public Wolf(double size, int rank) {
    super(size);
    this.rank = rank;
  }

  public int getRank() {
    return this.rank;
  }

  public void bark() {
    for (int i = 1; i <=3; i++) {
      super.bark();
    }
  }
  
  public void bark(int barkMultiple) {
    for (int i = 1; i <= barkMultiple; i++) {
      super.bark();
    }
  }

  public void groom() {
    System.out.println("lick");
  }

  public static void main(String args[]) {
    Wolf alpha = new Wolf(9.6, 1);
    alpha.bark();
  }
}
