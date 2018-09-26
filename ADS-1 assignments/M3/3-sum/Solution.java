import java.util.Scanner;
import java.util.Arrays;
class TripleSum {
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
		for (int i = 0; i < arr.length - 2; i++) {
			result = arr[i] + arr[i + 1] + arr[i + 2];
			if (result == 0) {
				count++;
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