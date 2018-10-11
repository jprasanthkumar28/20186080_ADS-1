import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * name variable.
     */
    private String name;
    /**
     * author variable.
     */
    private String author;
    /**
     * price variable.
     */
    private String price;
    /**
     * Constructs the object.
     *
     * @param      nm    { parameter_description }
     * @param      au    { parameter_description }
     * @param      pr    { parameter_description }
     */
    protected Book(final String nm, final String au, final String pr) {
        this.name = nm;
        this.author = au;
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
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public String getPrice() {
        return this.price;
    }
    /**
     * to compare the books.
     *
     * @param      that  The that
     *
     * @return     1 if greater , -1 if lesser and 0 if equal.
     */
    public int compareTo(final Book that) {
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
         * Book class object for key.
         */
        Book mainKey;
        /**
         * value variable.
         */
        private String value;
        /**
         * for left and right value, Node object.
         */
        Node left, right;
        /**
         * Constructs the object.
         *
         * @param      key    The key
         * @param      value  The value
         */
        Node(final Book key, final String value) {
            this.mainKey = key;
            this.value = value;
        }
    }
    /**
     * Constructs the object.
     */
    BinaryTree() {
        root = null;
    }
    public void put(final Book key, final String value) {
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
    public Node put(final Node a, final Book key, final String value) {
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
    public String get(final Book key) {
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
        return null;
    }
}
/**
 * Client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
    /**
     * Empty Constructer.
     */
    }
    /**
     * Cleint function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        while (scan.hasNextLine()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                Book book = new Book(tokens[1], tokens[2], tokens[2 + 2]);
                bt.put(book, tokens[2 + 2]);
                break;
                case "get":
                book = new Book(tokens[1], tokens[2], tokens[2 + 1]);
                System.out.println(bt.get(book));
                break;
                default:
                break;
            }
        }
    }
}
