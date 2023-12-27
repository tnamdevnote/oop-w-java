package module_4;

import module_4.ArraySearch;

public class SomeOtherProgram {
  public static void main (String[] args) {
    String[] movies = {"Harry Potter", "Thor", "Cinema Paradiso", "Good Will Hunting", "Wonka", "Hunger Game"};

    System.out.println(ArraySearch.searchStringArray("Harry Potter", movies));
    System.out.println(ArraySearch.searchStringArray("Goblet of Fire", movies));
  }
}
