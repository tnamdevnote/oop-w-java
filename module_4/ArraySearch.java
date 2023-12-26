package module_4;

public class ArraySearch {
  public static void main (String[] args) {
    String[] concepts = { "abstraction", "polymorphism", "inheritance", "encapsulation" };
    String result = "not found";

    for (String concept: concepts) {
      if (concept.equals("polymorphism")) {
        result = "found";
        break; // breaks the loop once we find the value.
      }
    }
    System.out.println(result);
  }
}
