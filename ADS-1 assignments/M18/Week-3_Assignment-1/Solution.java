import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	private Solution() {

	}
	// public static void main(final String[] args) {
 //        Scanner scan = new Scanner(System.in);
 //        int n = Integer.parseInt(scan.nextLine());

 //        Stock[] stock = new Stock[n];
 //        for (int k = 0; k < n; k++) {
 //            String[] tokens = scan.nextLine().split(",");
 //            stock[k] = new Stock(tokens[0], Float.parseFloat(tokens[1]));
 //        }
 //        MinPQ<Stock> pq = new MinPQ<Stock>();
 //        for (int i = 0; i <= n; i++) {
 //           	pq.insert(new Stock(tokens));
 //        }
 //        // Insertion.sort(students);
 //        // print(students);
 //    }
        public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        while (scan.hasNextLine()) {
        	String n = scan.nextLine();
            String[] tokens = scan.nextLine().split(",");
            switch (n) {
                case "put":
                Stock stock = new Stock(tokens[0], Float.parseFloat(tokens[1]));
                bt.put(stock, Float.parseFloat(tokens[1]));
                break;
                case "get":
                stock = new Stock(tokens[0], Float.parseFloat(tokens[1]));
                System.out.println(bt.get(stock));
                break;
                default:
                break;
            }
        }
    }
}
class Stock implements Comparable<Stock> {
    /**
     * name variable.
     */
    private String name;
    /**
     * price variable.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      nm    for name.
     * @param      au    for author.
     * @param      pr    for price.
     */
    protected Stock(final String nm, final float pr) {
        this.name = nm;
        this.price = pr;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * to compare the books.
     *
     * @param      that  The that
     *
     * @return     1 if greater , -1 if lesser and 0 if equal.
     */
    public int compareTo(final Stock that) {
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for binary tree.
 */
class BinaryTree {
    /**
     * root node varaible.
     */
    private Node root;
    /**
     * Size variable.
     */
    private int size;
    /**
     * Node class.
     */
    private class Node {
        /**
         * Stock class object for key.
         */
        private Stock mainKey;
        /**
         * value variable.
         */
        private float value;
        /**
         * for left and right value, Node object.
         */
        private Node left, right;
        /**
         * Constructs the object.
         *
         * @param      key    The key
         * @param      value1  The value
         */
        Node(final Stock key, final float value1) {
            this.mainKey = key;
            this.value = value1;
        }
    }
    /**
     * Constructs the object.
     */
    BinaryTree() {
        root = null;
    }
    /**
     * to put the value.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Stock key, final float value) {
        root = put(root, key, value);
    }
    /**
     * to put the values.
     *
     * @param      a      { parameter_description }
     * @param      key    The key
     * @param      value  The value
     *
     * @return     the value.
     */
    public Node put(final Node a, final Stock key, final float value) {
        if (a == null) {
            return new Node(key, value);
        }
        int compare = key.getName().compareTo(a.mainKey.getName());
        if (compare < 0) {
            a.left = put(a.left, key, value);
        } else if (compare > 0) {
            a.right = put(a.right, key, value);
        } else if (compare == 0) {
            a.value = value;
        }
        return a;
    }
    /**
     * to get the key.
     *
     * @param      key   The key
     *
     * @return     value if present else null.
     */
    public float get(final Stock key) {
        Node a = root;

        while (a != null) {
            int compare = key.getName().compareTo(a.mainKey.getName());
            if (compare < 0) {
                a = a.left;
            } else if (compare > 0) {
                a = a.right;
            } else if (compare == 0) {
                return a.value;
            }
        }
        return 0.0f;
    }
}