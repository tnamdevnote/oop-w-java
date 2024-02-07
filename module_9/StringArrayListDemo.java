package module_9;

import java.util.ArrayList;

public class StringArrayListDemo {
  public static void main(String[] args) {
    ArrayList<String> playlist = new ArrayList<>();
    playlist.add("Humpty Dumpty");
    playlist.add("Swing Low Sweet Chariot");
    playlist.add("Dynamite");
    playlist.add("Itsy Bitsy Spider");
    playlist.add("Rather Be");
    System.out.println(playlist.toString());

    playlist.remove("Humpty Dumpty");
    System.out.println(playlist.toString());
    System.out.println(playlist.contains("Humpty Dumpty"));
    System.out.println(playlist.toString());
  }
}
