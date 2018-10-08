import java.util.Scanner;
class MinPQ<P extends Comparable<P>> {
    private P[] array;
    MinPQ(final P[] a) {
        this.array = a;
    }
    public boolean isMinHeap() {
        if (array.length == 0) {
            return false;
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                if (less(i + 1, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean less(final int a, final int b) {
        return array[a].compareTo(array[b]) < 0;
    }
}
public class Solution {
    private Solution() {
        //Unused Constructor.
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int data = Integer.parseInt(scan.nextLine());
        switch (str) {
        case "String":
            while (data > 0) {
                String[] tokens = scan.nextLine().split(",");
                MinPQ<String> min = new MinPQ<String>(tokens);
                System.out.println(min.isMinHeap());
                data--;
            }
            break;
        case "Integer":
            while (data > 0) {
                String[] tokens = scan.nextLine().split(",");
                Integer[] intTokens = new Integer[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    intTokens[j] = Integer.parseInt(tokens[j]);
                }
                MinPQ<Integer> min = new MinPQ<Integer>(intTokens);
                System.out.println(min.isMinHeap());
                data--;
            }
            break;
        case "Double":
            while (data > 0) {
                String[] tokens = scan.nextLine().split(",");
                Double[] doubleTokens = new Double[tokens.length];
                for (int k = 0; k < tokens.length; k++) {
                    doubleTokens[k] = Double.parseDouble(tokens[k]);
                }
                MinPQ<Double> min = new MinPQ<Double>(doubleTokens);
                System.out.println(min.isMinHeap());
                data--;
            }
            break;
        case "Float":
            while (data > 0) {
                String[] tokens = scan.nextLine().split(",");
                Float[] floatTokens = new Float[tokens.length];
                for (int l = 0; l < tokens.length; l++) {
                    floatTokens[l] = Float.parseFloat(tokens[l]);
                }
                MinPQ<Float> min = new MinPQ<Float>(floatTokens);
                System.out.println(min.isMinHeap());
                data--;
            }
            break;
        }
    }
}