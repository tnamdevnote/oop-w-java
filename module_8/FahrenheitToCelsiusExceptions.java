package module_8;

import java.util.InputMismatchException;
import java.util.Scanner;
public class FahrenheitToCelsiusExceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean success = false;
        int fahrenheit = 0;
        while (!success) {
          try {
            System.out.print("Enter a Fahrenheit value: ");
            fahrenheit = input.nextInt();
            success = true;
          } catch (InputMismatchException e) {
            System.out.println("Sorry, that wasn't an int.");
            System.out.println("Please re-run the program again.");
          } catch (ArithmeticException ae) {
            System.out.println("You entered an invalid number.");
            System.out.println(ae.getMessage());
          } catch (Exception e) {
            System.out.println(e.getMessage());
          } finally {
            input.nextLine();
          }
        }

        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.printf("Fahrenheit: %d\n", fahrenheit);
        System.out.printf("Celsius:    %.1f\n", celsius);
    }
}