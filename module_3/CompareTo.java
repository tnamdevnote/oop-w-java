package module_3;
import java.util.Scanner;

public class CompareTo {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = input.next();


    int result = name.compareTo("Nam");
    // if "Taek" does not equal 
    if (result > 0) {
      System.out.println(result);
    } else {
      System.out.println("Nope");
    }
    System.out.println(name);
  }
}
