/**
 * Created by david on 12/25/2016.
 */
public class QuickSort_LeftPivot {
//    int[] array;

    public static void main(String[] args) {
        int[] test_arr = {5, 4, 4};
        QuickSort_LeftPivot test = new QuickSort_LeftPivot();
        test.QuickSort(test_arr);
        printArray(test_arr);
//        QuickSort_LeftPivot test = new QuickSort_LeftPivot(test_arr);
//        test.QuickSort(0, 6);
//        printArray(test.array);
    }

    public void QuickSort(int array[])
// pre: array is full, all elements are non-null integers
// post: the array is sorted in ascending order
    {
        QuickSort(array, 0, array.length - 1);              // quicksort all the elements in the array
    }


    public void QuickSort(int array[], int start, int end)
    {
        int i = start;                          // index of left-to-right scan
        int k = end;                            // index of right-to-left scan

        if (end - start >= 1)                   // check that there are at least two elements to sort
        {
            int pivot = array[start];       // set the pivot as the first element in the partition

            while (k > i)                   // while the scan indices from left and right have not met,
            {
                while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
                    i++;                                    // element greater than the pivot
                while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
                    k--;                                        // element not greater than the pivot
                if (k > i)                                       // if the left seekindex is still smaller than
                    swap(array, i, k);                      // the right index, swap the corresponding elements
            }
            swap(array, start, k);          // after the indices have crossed, swap the last element in
            // the left partition with the pivot
            QuickSort(array, start, k - 1); // quicksort the left partition
            QuickSort(array, k + 1, end);   // quicksort the right partition
        }
        else    // if there is only one element in the partition, do not do any sorting
        {
            return;                     // the array is sorted, so exit
        }
    }

    public void swap(int array[], int index1, int index2)
// pre: array is full and index1, index2 < array.length
// post: the values at indices 1 and 2 have been swapped
    {
        int temp = array[index1];           // store the first value in a temp
        array[index1] = array[index2];      // copy the value of the second into the first
        array[index2] = temp;               // copy the value of the temp into the second
    }


//    public QuickSort_LeftPivot(int[] array) {
//        this.array = array;
//    }
//
//
//    public void QuickSort(int first, int last) {
//        if (array == null || last == first || Math.abs(last-first) == 1) {
//            if (this.array[last] < this.array[first]) {
//                swap(first, last);
//            }
//            return;
//        } else {
//            int pivot = array[first];
//            System.out.print("array before sorting: ");
//            printArray(this.array);
//            int pivotPos = this.sortSubarray(pivot, first, last);
//            System.out.print("array after sorting: ");
//            printArray(this.array);
//            this.QuickSort(first, pivotPos - 1);
//            this.QuickSort(pivotPos + 1, last);
//        }
//
////        printArray(this.array);
//
//    }
//
//    public int sortSubarray(int pivot, int first, int last) {
////        printArray(this.array);
//        int runner = last-1;
//        int tracker = last;
//
//        while (runner > first) {
//
//            while (this.array[tracker] > pivot && runner > first) {
//                tracker--;
//                runner--;
//            }
//
//            if (this.array[runner] > pivot) {
//                System.out.print("array before swapping: ");
//                printArray(this.array);
//                this.swap(runner, tracker);
//                System.out.print("array after swapping: ");
//                printArray(this.array);
//                tracker--;
//                runner--;
//            } else if (runner > first) {
//                    runner--;
//                }
//
//        }
//
//        if (this.array[tracker] < pivot) {
//            this.swap(runner, tracker);
//            return tracker;
//        }
//
//        return first;
//
//    }
//
//    void swap(int first, int second) {
//        int temp = this.array[first];
//        this.array[first] = this.array[second];
//        this.array[second] = temp;
//    }


    static void printArray(int[] arr) {
        for (int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }
}
