import java.util.Scanner;
/**
 * Class for sorting.
 */
class Sorting {
    /**.
     * Constructs the object.
     */
    Sorting() {
        /**.
         * Empty Constructer.
         */
    }
    // time complexity for this method is O(N^2).
    // In first for loop and second loop it iterates through the size of arrayay
    /**.
     * insertion sort.
     *
     * @param      array  The arguments
     * @param      low  The arguments
     * @param      high  The arguments
     */
    public void insertion(final Comparable[] array, final int low,
     final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }
    // time complexity of this method is O(1). It swaps the elements only once.
    /**.
     * to swap two numbers.
     *
     * @param      array  The arguments
     * @param      j  The arguments
     * @param      min  The arguments
     */
    public void swap(final Comparable[] array, final int j, final int min) {
        Comparable temp = array[j];
        array[j] = array[min];
        array[min] = temp;
    }
    // time complexity of this method is O(N). It iterates through
    // the arrayay to print all the objects in arrayay.

    /**.
     * Returns a string representation of the object.
     *
     * @param      array   The array
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] array) {
        String str = "[";
        for (int i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[array.length - 1] + "]";
        return str;
    }
    // time complexity is O(log N)
    /**.
     * to sort.
     *
     * @param      array  The arguments
     * @param      low  The arguments
     * @param      high  The arguments
     * @param      cutOff  The arguments
     */
    public void sort(final Comparable[] array, final int low,
     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(array, low, high);
        System.out.println(toString(array));
        sort(array, low, k - 1, cutOff);
        sort(array, k + 1, high, cutOff);
    }
    //time complexity is O(1)

    /**.
     * to sort.
     *
     * @param      array   The arrayay
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
    // time complexity is O(N)
    /**.
     * for partitioning.
     *
     * @param      array   The array
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { description_of_the_return_value }
     */
    public int partition(final Comparable[] array,
     final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }
    // time complexity is O(1)
    /**.
     * to compare.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}
/**
 * client class.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * empty constructer.
         */
    }
    /**.
     * main function.
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is N
    // Because there is one while loop.
    // while loop iterates until it has next line i.e N times.
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Sorting sort = new Sorting();
        int testcases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testcases; i++) {
            int j = Integer.parseInt(scan.nextLine());
            // scan.nextLine();
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                sort.sort(tokens, j);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}
