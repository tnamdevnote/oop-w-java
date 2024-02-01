package module_6;

public class BinarySearch {
  private static int[] arr = {6,7,2,1,5,9};

  public static int binarySearch(Comparable[] arr, Comparable target) {
    int start = 0, end = arr.length-1, mid = 0;

    while (start <= end) {
      mid = (start + end) / 2;
      if (arr[mid].compareTo(target) == 0) {
        return mid;
      } else if (arr[mid].compareTo(target) > 0) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {

  }
}
