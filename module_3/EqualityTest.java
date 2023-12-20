package module_3;

public interface EqualityTest {
  public static void main (String[] args) {
    // Java creates a new string object "park" and put into String constant pool
    String x = "park";
    // Java recycles the "park" in the constant pull and make aliases of it
    String y = "park";

    if (x == y) {
      System.out.println("x and y are aliases");
    }

    if (x != y) {
      System.out.println("x and y are not aliases");
    }

    if (x.equals(y)) {
      System.out.println("x and y have the same contents");
      System.out.println("x: " + x);
      System.out.println("y: " + y);
    }
  }
}
