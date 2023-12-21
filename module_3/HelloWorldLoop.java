package module_3;

/** While Loop */
// public class HelloWorldLoop {
//   public static void main (String[] args) {
//     int counter = 0;
//     while (counter < 10) {
//       System.out.println("Hello World");
//       counter++;
//     }
//   }
// }


/** Do-While Loop */
// public class HelloWorldLoop {
//   public static void main (String[] args) {
//     int counter = 1;
//     do {
//       System.out.println("Hello World!" + counter);
//       counter++;
//     } while (counter <= 10);
//   }
// }

/** For Loop */
// public class HelloWorldLoop {
//   public static void main (String[] args) {
//     // int counter;
//     for (int counter = 1; counter <= 10; counter++) {
//       System.out.println("Hello World! " + counter);
//     }
//   }
// }

/** Nested Loop */

public class HelloWorldLoop {
  public static void main (String[] args) {
    for (int i = 50; i > 0; i -= 10) {
      System.out.print(i);
    }
  }
}