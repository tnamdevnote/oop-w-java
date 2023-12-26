package module_4;

public class Average {
  public static void main(String[] args) {
    double[] weekHighs = { 80, 70, 75, 69, 72, 74, 90 };
    double highestSum = 0;
    for (int index = 0; index < weekHighs.length; index++) {
      highestSum = highestSum + weekHighs[index];
    }
    double average = highestSum / weekHighs.length;

    System.out.println(average);
  }
}
