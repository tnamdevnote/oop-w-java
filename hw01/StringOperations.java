package hw01;

public class StringOperations {
  public static void main(String[] args) {
    String name = "Luke Nam";
    System.out.println(name);
    
    name = name.replace('L', 'A');
    name = name.replace('m', 'z');
    System.out.println(name);

    String url = new String("www.tnam.dev");
    System.out.println(url);

    String newSubstring = url.substring(4, url.length() - 4);
    System.out.println(newSubstring + 1331);
  }
}
