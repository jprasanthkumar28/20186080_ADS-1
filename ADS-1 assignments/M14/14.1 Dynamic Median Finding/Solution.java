import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution () {
    /**
     * Empty Constructer.
     */
    }

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        MinPQ<Float> minPQ = new MinPQ<Float>(n);
        MaxPQ<Float> maxPQ = new MaxPQ<Float>(n);

        Float median = 0.0f;
        for (int i = 0; i < n; i++) {
            Float value = scan.nextFloat();
            if (value > median) {
                minPQ.insert(value);
            } else {
                maxPQ.insert(value);
            }

            if (minPQ.size() - maxPQ.size() > 1) {
                maxPQ.insert(minPQ.delMin());

            }
            if (maxPQ.size() - minPQ.size() > 1) {
                minPQ.insert(maxPQ.delMax());
                
            }

            if (minPQ.size() == maxPQ.size()) {
                median = (minPQ.min() + maxPQ.max()) / 2;
                System.out.println(median);
            }

            if (maxPQ.size() > minPQ.size()) {
                median = maxPQ.max();
                System.out.println(median);
            }

            if (minPQ.size() > maxPQ.size()) {
                median = minPQ.min();
                System.out.println(median);
            }

        }

    }
}