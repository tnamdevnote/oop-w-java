package hw02;

import java.util.Scanner;

public class Calculator {
  public static void main (String[] args) {

    System.out.println("List of operations: add subtract multiply divide alphabetize");
    // initialize scanner variable
    Scanner input = new Scanner(System.in);

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
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };
        if (input.hasNextInt()) {
          addInput2 = input.nextInt();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };

        System.out.println("Answer: " + (addInput1 + addInput2));

        break;
      case "subtract":
        // some operation;
        System.out.println("Enter two integers: ");
        int subtractInput1;
        int subtractInput2;

        if (input.hasNextInt()) {
          subtractInput1 = input.nextInt();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };
        if (input.hasNextInt()) {
          subtractInput2 = input.nextInt();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };

        System.out.println("Answer: " + (subtractInput1 - subtractInput2));
        break;

      case "multiply":
        // some operation;
        System.out.println("Enter two doubles: ");
        double multiplyInput1;
        double multiplyInput2;

        if (input.hasNextDouble()) {
          multiplyInput1 = input.nextDouble();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };
        if (input.hasNextDouble()) {
          multiplyInput2 = input.nextDouble();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };

        double multiplyResult = multiplyInput1 * multiplyInput2;

        System.out.printf("Answer: " + "%.2f\n", multiplyResult);
        break;

      case "divide":
        // some operation;
        System.out.println("Enter two doubles: ");
        double divideInput1;
        double divideInput2;

        if (input.hasNextDouble()) {
          divideInput1 = input.nextDouble();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };
        if (input.hasNextDouble()) {
          divideInput2 = input.nextDouble();
          if (divideInput2 == 0) {
            System.out.println("Invalid input entered. Terminating...");
            return;
          }
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        };

        double divideResult = divideInput1 / divideInput2;

        System.out.printf("Answer: " + "%.2f\n", divideResult);
        break;
      case "alphabetize":
        // some operation;
        System.out.println("Enter two words: ");
        String alphabetizeInput1;
        String alphabetizeInput2;

        if (input.hasNext()) {
          alphabetizeInput1 = input.next();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        }; 
        if (input.hasNext()) {
          alphabetizeInput2 = input.next();
        } else {
          System.out.println("Invalid input entered. Terminating...");
          return;
        }; 

        if (alphabetizeInput1.toLowerCase().compareTo(alphabetizeInput2.toLowerCase()) < 0) {
          System.out.println("Answer: " + alphabetizeInput1 + " comes before " + alphabetizeInput2 + " alphabetically.");
        } else if (alphabetizeInput1.toLowerCase().compareTo(alphabetizeInput2.toLowerCase()) > 0) {
          System.out.println("Answer: " + alphabetizeInput2 + " comes before " + alphabetizeInput1 + " alphabetically.");
        } else {
          System.out.println("Answer: Chicken or Egg.");
        }


        break;
      default:
        System.out.println("Invalid input entered. Terminating...");
        break;
    }
  }
}