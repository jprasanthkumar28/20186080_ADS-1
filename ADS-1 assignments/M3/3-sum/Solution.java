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
    private int[] array;
    private int result;
    private int size;
    TripleSum(final int number) {
        this.result = 0;
        this.size = number;
        this.array = new int[number];
    }
        public int arraySum(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int last = arr.length - 1;
                result = arr[i] + arr[j] + arr[last];
                if (result == 0) {
                    count++;
                }
            last--;
            }
            }
        return count;
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
        System.out.println(three.arraySum(t));
    }
}