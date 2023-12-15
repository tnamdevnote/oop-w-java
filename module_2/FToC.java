package module_2;

// imports Java's Scanner API
import java.util.Scanner;

// public class FToC {
//   public static void main(String[] args) {
//     // System.in as input. This will allow constructor to read characters from the device.
//     Scanner input = new Scanner(System.in); //read keyboard input.
//     // Print out a prompt asking for a fahrenheit value.
//     // Using "print" method to take input on the same line.
//     System.out.print("Enter a Fahrenheit value: ");
    
//     if (input.hasNextInt()) {
//       // assign input value to fahrenheit variable;
//       int fahrenheit = input.nextInt();
//       // convert fahrenheit to celsius
//       double celsius = (5D/9) * (fahrenheit - 32);
//       // print celsius
//       System.out.println(celsius);
//     } else {
//       System.out.println("Please enter a valid input");
//     }
//   }
// }

/** Multiple Prompts and Tokens */
// public class FToC {
//   public static void main(String[] args) {
//     // System.in as input. This will allow constructor to read characters from the device.
//     Scanner input = new Scanner(System.in); //read keyboard input.
//     // First Prompt
//     System.out.print("Enter a Fahrenheit value: ");
//     // assign input value to fahrenheit variable;
//     int fahrenheit = input.nextInt();
//     String day = input.nextLine().trim();
//     // convert fahrenheit to celsius
//     double celsius = (5D/9) * (fahrenheit - 32);
//     // print celsius
//     System.out.println(day + " Fahrenheit: " + fahrenheit);
//     System.out.println(day + " Celsius: " + celsius);
//   }
// }
/** Formatting String */

public class FToC {
  public static void main(String[] args) {
    // System.in as input. This will allow constructor to read characters from the device.
    Scanner input = new Scanner(System.in); //read keyboard input.
    // First Prompt
    System.out.print("Enter a Fahrenheit value: ");
    int fahrenheit = input.nextInt();

    System.out.print("Enter a day of the week: ");
    String day = input.next();

    System.out.print("Enter your preferred Celsius label(Celsius, Centigrade, or C): ");
    String ctext = input.next();


    // convert fahrenheit to celsius
    double celsius = (5D/9) * (fahrenheit - 32);
    // print celsius
    System.out.printf("%s Fahrenheit: %d\n", day, fahrenheit);
    // System.out.println(day + " Celsius: " + celsius);
    System.out.printf("%s %s: %13.1f\n", day, ctext, celsius);
  }
}