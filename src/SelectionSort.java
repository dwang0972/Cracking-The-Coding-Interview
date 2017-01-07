/**
 * Created by david on 12/25/2016.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] test = {1, 1, 1};
        selectionSort(test);
        printArray(test);
        System.out.println(isSorted(test));

    }

    static void selectionSort(int[] arr) {
        int minIndex = 0;
        for (int x = 0; x < arr.length; x++) {
            int min = Integer.MAX_VALUE;
            for (int i = x; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[x];
            arr[x] = temp;
        }
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int compare = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (compare > arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printArray(int[] arr) {
        for (int x: arr) {
            System.out.print(x + " ");
        }
    }


}
