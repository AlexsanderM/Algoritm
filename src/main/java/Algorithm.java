import sort.QuickSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Algorithm {
    public static void main(String[] args) {
        int[] quickSortArray = { 2, 55, 1, 77, 32, 9, 0};
        System.out.println(Arrays.toString(quickSortArray));

        QuickSort.quickSort(quickSortArray, 0, quickSortArray.length - 1);
        System.out.println(Arrays.toString(quickSortArray));


    }
}
