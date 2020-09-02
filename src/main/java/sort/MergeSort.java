package sort;

public class MergeSort {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = { 3,6,1,7,2,8,10,4,9,5};
        int n = num.length;

        mergeSort(num, 0, n - 1);

        for (int h = 0; h < n; h++)
            System.out.print(num[h]+ " ");
    }

    /*
     * Internal method that makes recursive calls to sort the data
     * elements is the array of elements to be sorted
     * low is the left most position of the array
     * high is the right most position of the array
     */
    public static void mergeSort(int[] elements, int low, int high) {
        if (low < high) { // list contains at least 2 elements
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid); // recursion : sort first half
            mergeSort(elements, mid + 1, high); // recursion : sort second half
            merge(elements, low, mid, high); // merge both sorted halves
        }
    }

    /*
     * Merge sorted array of elements from low to mid and mid+1
     * low is the left most position of the subset of elements
     * high is the right most position of the subset of elements
     */
    private static void merge(int[] subset, int low, int mid, int high) {

        int n = high-low+1;
        int[] Temp = new int[n];

        int i = low, j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid)
                Temp[k++] = subset[j++];
            else if (j > high)
                Temp[k++] = subset[i++];
            else if (subset[i] < subset[j])
                Temp[k++] = subset[i++];
            else
                Temp[k++] = subset[j++];
        }
        for (j = 0; j < n; j++)
            subset[low + j] = Temp[j];
    }
}
