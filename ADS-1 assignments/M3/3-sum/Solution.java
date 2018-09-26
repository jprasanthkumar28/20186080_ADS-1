import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for triple sum.
 * @author Prasanth...
 */
class TripleSum {
    /**
     * integer array.
     */
    private int[] arr;
    /**
     * variable result and count.
     */
    private int result, count;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      number  The number
     */
    TripleSum(final int number) {
        this.result = 0;
        this.count = 0;
        this.size = number;
        this.arr = new int[number];
    }
    /**
     * binary search program.
     *
     * @param      array  The array
     * @param      key    The key
     *
     * @return     value.
     */
    public int binarySearch(final int[] array, final int key) {
        int first = 0, last = array.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
            // count++;
        }
        return -1;
    }
    /**
     * to find sum.
     *
     * @param      arr1   The arr1
     *
     * @return     count.
     */
    public int arraySum(final int[] arr1) {
        Arrays.sort(arr1);
        // int result1= 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                // result = arr[i] + arr[j];
                // result1 = result * -1;
                int k = binarySearch(arr1, -(arr1[i] + arr1[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //Empty Constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] t = new int[n];
        TripleSum three = new TripleSum(n);
        for (int i = 0; i < n; i++) {
            t[i] = scan.nextInt();
        }
        // System.out.println(three.arraySum(t));
        //three.arraySum(t);
        int count1 = three.arraySum(t);
         System.out.println(count1);
    }
}
