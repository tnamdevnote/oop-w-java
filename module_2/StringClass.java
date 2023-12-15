package module_2;
public class StringClass {
  public static void main(String[] args) {
    // Declare a variable
    String major;
    // Creates a new string object by calling constructor("Computer Science") internally.
    // Then the reference to the address in the heap is assigned to major.
    major = new String("Computer Science");
    System.out.println(major.length());
  }
}
