import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for SortedArray array.
 * @author Prasanth...
 */
class SortedArray {
    /**
     * frist array.
     */
    private int[] array1;
    /**
     *Size of first array.
     */
    private int size1;
    /**
     * second array.
     */
    private int[] array2;
    /**
     * Size of 2nd array.
     */
    private int size2;
    /**
     * newarray.
     */
    private int[] newarray;
    /**
     * Constructs the object.
     *
     * @param      arr1   The archive 1
     * @param      arr2   The archive 2
     */
    SortedArray(final int[] arr1, final int[] arr2) {
        this.array1 = arr1;
        this.size1 = array1.length;
        this.array2 = arr2;
        this.size2 = array2.length;
        this.newarray = new int[size1 + size2];
    }
    /**
     * {Method to sortArray the array}.
     *
     * @param      a1    Array 1
     * @param      a2    Array 2
     *
     * @return     {Array}
     */
    public int[] sortArray(final int[] a1, final int[] a2) {
        int i = 0, j = 0, k = 0;
        while (i < size1 && j < size2) {
            if (a1[i] < a2[j]) {
                this.newarray[k++] = a1[i++];
            } else {
                this.newarray[k++] = a2[j++];
            }
        }
        while (i < size1) {
            this.newarray[k++] = a1[i++];
        }
        while (j < size2) {
            this.newarray[k++] = a2[j++];
        }
        return this.newarray;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int[] arr1 = new int[first];
        int[] arr2 = new int[second];
        if (first > 0) {
            String[] tokens = scan.next().split(",");
            for (int i = 0; i < first; i++) {
                arr1[i] = Integer.parseInt(tokens[i]);
            }
        }
        if (second > 0) {
            String[] tokens1 = scan.next().split(",");
            for (int i = 0; i < second; i++) {
                arr2[i] = Integer.parseInt(tokens1[i]);
            }
        }
        SortedArray sa = new SortedArray(arr1, arr2);
        int[] a = sa.sortArray(arr1, arr2);
        System.out.println(Arrays.toString(a).substring(
            1, Arrays.toString(a).length() - 1).replace(" ", ""));
    }
}
