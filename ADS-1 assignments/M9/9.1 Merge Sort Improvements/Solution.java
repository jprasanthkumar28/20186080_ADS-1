import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for merge sort.
 */
class MergeSort {
    /**.
     * final variable.
     */
    private final int cutoff = 7;
    /**.
     * int array size variable.
     */
    private int[] array;
    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    MergeSort() {
        this.array = new int[1];
        this.size = 0;
    }
    /**
     * Gets the size.
     * Time complexity is 1.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * to resize the gievn array.
     * Time complexity is N.
     */
    private void resize() {
        array = Arrays.copyOf(array, 2 * array.length);
    }
    /**
     * to add the elements into the array.
     * Time complexity is 1.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param      a     Comparable object.
     * Time complexity is O(N).
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort. Time complexity is O(N).
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     */
    public void insertionSort(final Comparable[] a,
        final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * to exchage or to swao to swap.
     * Time complexity is O(N).
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void exch(final Object[] a, final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * to check two comparable objects.
     * Time complexity is O(1).
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     true or false based on the condition.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Determines if sorted.
     * Time complexity is O(1).
     *
     * @param      a     { parameter_description }
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted.
     * Time complexity is O(log(N)).
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a, final int lo,
        final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * to merge the data.
     * Time complexity is O(N).
     *
     * @param      array1  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      mid    The middle
     * @param      hi     The higher
     */
    public void merging(final Comparable[] array1,
        final Comparable[] aux, final int lo, final int mid, final int hi) {
        assert isSorted(array1, lo, mid);
        assert isSorted(array1, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array1[j++];
            } else if (j > hi) {
                aux[k] = array1[i++];
            } else if (less(array1[j], array1[i])) {
                aux[k] = array1[j++];
            } else {
                aux[k] = array1[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**
     * To sort. Time complexity is O(Log(N)).
     *
     * @param      array2  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      hi     The higher
     */
    public void sort(final Comparable[] array2,
        final Comparable[] aux, final int lo, final int hi) {
        if (hi <= lo + cutoff) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, array2, lo, mid);
        sort(aux, array2, mid + 1, hi);
        if (!less(array2[mid + 1], array2[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = array2[i];
            }
            System.out.println(
            "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merging(array2, aux, lo, mid, hi);
    }
    /**.
     * { function_description }
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Object display(final Object[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
}
/**
 * Client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        MergeSort sortedd = new MergeSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            sortedd.sort(tokens);
            System.out.println(sortedd.display(tokens));
            System.out.println();
        }
    }
}
