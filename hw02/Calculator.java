package hw02;

import java.util.Scanner;

public class Calculator {
  public static void main (String[] args) {
    // initialize scanner variable
    Scanner input = new Scanner(System.in);

    // Extract error message into a variable for reusability.
    String errorMessage = "Invalid input entered. Terminating...";

    System.out.println("List of operations: add subtract multiply divide alphabetize");

    // receive input
    System.out.println("Enter an operation: ");
    String operation = input.next().toLowerCase();

    switch (operation) {
      case "add":
        // some operation;
        System.out.println("Enter two integers: ");
        int addInput1;
        int addInput2;

        if (input.hasNextInt()) {
          addInput1 = input.nextInt();
          if (input.hasNextInt()) {
            addInput2 = input.nextInt();
            System.out.println("Answer: " + (addInput1 + addInput2));
          } else {
            System.out.println(errorMessage);
          };
        } else {
          System.out.println(errorMessage);
        };

        break;
      case "subtract":
        // some operation;
        System.out.println("Enter two integers: ");
        int subtractInput1;
        int subtractInput2;

        if (input.hasNextInt()) {
          subtractInput1 = input.nextInt();
          if (input.hasNextInt()) {
            subtractInput2 = input.nextInt();
            System.out.println("Answer: " + (subtractInput1 - subtractInput2));
          } else {
            System.out.println(errorMessage);
          };
        } else {
          System.out.println(errorMessage);
        };
        break;

      case "multiply":
        // some operation;
        System.out.println("Enter two doubles: ");

        if (input.hasNextDouble()) {
          double multiplyInput1 = input.nextDouble();
          if (input.hasNextDouble()) {
           double multiplyInput2 = input.nextDouble();
            System.out.printf("Answer: " + "%.2f\n", multiplyInput1 * multiplyInput2);
          } else {
            System.out.println(errorMessage);
          } 
        } else {
          System.out.println(errorMessage);
        };

        break;

      case "divide":
        // some operation;
        System.out.println("Enter two doubles: ");
        double divideInput1;
        double divideInput2;

        if (input.hasNextDouble()) {
          divideInput1 = input.nextDouble();
          if (input.hasNextDouble()) {
            divideInput2 = input.nextDouble();
            if (divideInput2 != 0) {
              System.out.printf("Answer: " + "%.2f\n", divideInput1 / divideInput2);
            } else {
              System.out.println(errorMessage);
            }
          } else {
            System.out.println(errorMessage);
          };
        } else {
          System.out.println(errorMessage);
        };

        break;
      case "alphabetize":
        // some operation;
        System.out.println("Enter two words: ");
        String alphabetizeInput1 = input.next();
        String alphabetizeInput2 = input.next();
        
        if (alphabetizeInput1.toLowerCase().equals(alphabetizeInput2.toLowerCase())) {
          System.out.println("Answer: Chicken or Egg.");
        } else if (alphabetizeInput1.toLowerCase().compareTo(alphabetizeInput2.toLowerCase()) < 0) {
          System.out.println("Answer: " + alphabetizeInput1 + " comes before " + alphabetizeInput2 + " alphabetically.");
        } else if (alphabetizeInput1.toLowerCase().compareTo(alphabetizeInput2.toLowerCase()) > 0) {
          System.out.println("Answer: " + alphabetizeInput2 + " comes before " + alphabetizeInput1 + " alphabetically.");
        } else {
          System.out.println(errorMessage);
        }

        break;
      default:
        System.out.println(errorMessage);
        break;
    }
  }
}