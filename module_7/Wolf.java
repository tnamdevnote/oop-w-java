package module_7;

public class Wolf extends Canine implements Comparable<Wolf> {
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

  public void pay() {
    System.out.println("Grrrr! Warning, don’t try and chase me for payment. I'm a wolf. Run Run Run!");
  }

  public int compareTo(Wolf anotherWolf) {
    return -(rank - ((Wolf)anotherWolf).rank);
  }

  public static void main(String args[]) {
    Wolf alpha = new Wolf(17.6, 1);
    Wolf puppy = new Wolf(3, 10);
    System.out.println(alpha.compareTo(puppy));
  }
}
