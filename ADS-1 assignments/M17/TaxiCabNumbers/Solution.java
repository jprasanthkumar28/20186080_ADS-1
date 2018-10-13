import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * Integer varaible.
     */
    private final int sum;
    /**
     * Integer varaible.
     */
    private final int i;
    /**
     * Integer varaible.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      val1    I 1
     * @param      val2    The j 1
     */
    CubeSum(final int val1, final int val2) {
        this.sum = val1 * val1 *  val1 + val2 * val2 * val2;
        this.i = val1;
        this.j = val2;
    }
    /**
     * Gets the sum.
     * Time complexity is 1.
     *
     * @return     The sum.
     */
    public int getSum() {
        return this.sum;
    }
    /**
     * Gets i.
     * Time complexity is 1.
     *
     * @return     I.
     */
    public int getVal1() {
        return this.i;
    }
    /**
     * Gets the j.
     * Time complexity is 1.
     *
     * @return     The j.
     */
    public int getVal2() {
        return this.j;
    }
    /**
     * compareTo method is using to compare the two objects.
     * Time complexity is 1.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return Integer.toString(sum);
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
        // default constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int num = 600;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int count = 0;
        int z = -1;
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= num; i++) {
            pq.insert(new CubeSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (z == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == m - 1) {
                n--;
                if (n == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            z = s.getSum();
            if (s.getVal2() < num) {
                pq.insert(new CubeSum(s.getVal1(), s.getVal2() + 1));
            }
        }
    }
}
