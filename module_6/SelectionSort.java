package module_6;

public class SelectionSort {
  private static int[] arr = {6,7,2,1,5,9};

  public static void selectionSort(Comparable[] arr) {
    int minIndex;
    // used to perform swaps
    Comparable nextSmallest;

    // this loop determines how many times it should run.
    for (int i = 0; i < arr.length-1; i++) {
        minIndex = i;
        // scans a list for a smallest item
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[minIndex].compareTo(arr[j]) > 0) {
            minIndex = j;
          }
        }

        // store the smallest value
        nextSmallest = arr[minIndex];
        // -- swap --
        // replace the next smallest value with unsorted value
        arr[minIndex] = arr[i];
        // replace unsorted value with next smallest.
        arr[i] = nextSmallest;
    } 
  }

  public static void main(String[] args) {

  }
}