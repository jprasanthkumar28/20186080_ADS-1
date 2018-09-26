import java.util.Scanner;
import java.util.Arrays;
class Compare {
        private int[] array;
        private int size;
        Compare(final int number) {
                this.size = number;
                this.array = new int[number];
        }
        public int array(int[] arr) {
                Arrays.sort(arr);
                int count = 0;
                int i = 0, first;
                first = i + 1;
                for (i = 0; i < arr.length - 11; i++) {
                        if (arr[i] == arr[first] ) {
                                count++;
                        }
                first++;
                }
                return count;
        } 
}
public class Solution {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] t = new int[n];
        Compare three = new Compare(n);
        for (int i = 0; i < n;i++ ) {           
                t[i] = scan.nextInt();
        }
        System.out.println(three.array(t));
        }
}