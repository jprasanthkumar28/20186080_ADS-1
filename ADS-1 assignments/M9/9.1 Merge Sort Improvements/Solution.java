import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for merge sort.
 */
class MergeSort {
    /**
     * final variable.
     */
    private final int Seven = 7;
    /**
     * int array size variable.;;
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
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort.
     * Time complexity is O(N).
     */
    public void insertionSort(Comparable[] a, int lo, int hi) {
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
    public void exch(Object[] a, int i, int j) {
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
    public boolean less(Comparable a, Comparable b) {
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
    public boolean isSorted(Comparable[] a) {
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
    public boolean isSorted(Comparable[] a, int lo, int hi) {
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
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      mid    The middle
     * @param      hi     The higher
     */
    public void merging(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > hi) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**
     * To sort.
     * Time complexity is O(Log(N)).
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      hi     The higher
     */
    public void sort(final Comparable[] array, final Comparable[] aux, int lo,
        final int hi) {
        if (hi <= lo + Seven) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, array, lo, mid);
        sort(aux, array, mid + 1, hi);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = array[i];
            }
        System.out.println("Array is already sorted.So, skipped the call to merge...");
            return;
        }
        merging(array, aux, lo, mid, hi);
    }
    // print array to standard output
    public Object display(Object[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
}
public class Solution {
    private Solution() {
        //Unused Constructor.
    }
    public static void main(String[] args) {
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