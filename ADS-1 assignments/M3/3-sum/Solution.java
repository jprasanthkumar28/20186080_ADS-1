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
    private int result, count;
    private int size;
    TripleSum(final int number) {
        this.result = 0;
        this.count = 0;
        this.size = number;
        this.arr = new int[number];
    }
    public int binarySearch(int key)
    {
        int first = 0, last = arr.length - 1;
        while (first <= last)
        {
            int mid = (first + last) / 2;
            if (key < arr[mid]) {
              last = mid - 1;  
            } else if (key > arr[mid]) {
                first = mid + 1; 
            } else {
                return mid;
            }
            count++;
        }
        System.out.println(count);
        return -1;
    }
    public void arraySum(int[] arr) {
        Arrays.sort(arr);
        int result1= 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                result = arr[i] + arr[j];
                result1 = result * -1;
            }
        }
        binarySearch(result1);
        
}
}
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] t = new int[n];
        TripleSum three = new TripleSum(n);
        for (int i = 0; i < n;i++ ) {
            t[i] = scan.nextInt();
        }
        // System.out.println(three.arraySum(t));
        three.arraySum(t);
    }
}
