import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable {
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
    private float price;
    /**
     * Constructs the object.
     *
     * @param      nm    { parameter_description }
     * @param      au    { parameter_description }
     * @param      cost  The cost
     */
    Book(final String nm,
                final String au, final float cost) {
        this.name = nm;
        this.author = au;
        this.price = cost;
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
    public float getPrice() {
        return this.price;
    }
    /**
     * Compares the object.
     *
     * @param      object  The object
     *
     * @return     1 or -1 after comparsion.
     */
    public int compareTo(final Object object) {
        Book that = (Book) object;
        return this.name.compareTo(that.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for binary tree.
 */
class BinaryTree {
    /**
     * root variable.
     */
    private Node root;
    /**
     * Node class.
     */
    private final class Node {
        /**
         * key variable.
         */
        private Book key;
        /**
         * val variable.
         */
        private int val;
        /**
         * left variable.
         */
        private Node left;
        /**
         * right variable.
         */
        private Node right;
        /**
         * size variable.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key1  The key 1
         * @param      val1  The value 1
         * @param      s     { parameter_description }
         */
        private Node(final Book key1, final int val1, final int s) {
            this.key = key1;
            this.val = val1;
            this.size = s;
            left = null;
            right = null;
        }
    }
    /**
     * Constructs the object.
     */
    BinaryTree() {
        root = null;
    }
    /**
     * size function.
     *
     * @return     size of the root.
     */
    public int size() {
        return size(root);
    }
    /**
     * size function.
     *
     * @param      x     { parameter_description }
     *
     * @return     size.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * to get the key.
     *
     * @param      key   The key
     *
     * @return     keyvalue.
     */
    public int get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return -1;
    }
    /**
     * put function.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final int val) {
        root = put(root, key, val);
    }
    /**
     * put function.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     value.
     */
    private Node put(final Node x, final Book key, final int val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
    /**
     * min function.
     *
     * @return     min roots key.
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * min function.
     *
     * @param      x     { parameter_description }
     *
     * @return     min value.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * max function.
     *
     * @return     max value.
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * max value.
     *
     * @param      x     { parameter_description }
     *
     * @return     max value.
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * to get floor value.
     *
     * @param      key   The key
     *
     * @return     floor value.
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * floor function.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * ceiling function.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * ceiling function.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * select function.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * select function.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * rank function.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Book key) {
        return rank(key, root);
    }
    /**
     * rank function.
     *
     * @param      key   The key
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int rank(final Book key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
}
/**
 * Client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree bst = new BinaryTree();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Book book = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[2 + 1]));
                bst.put(book, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                book = new Book(tokens[1], tokens[2],
                                        Float.parseFloat(tokens[2 + 1]));
                if (bst.get(book) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(book));
                }
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                book = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.floor(book));
                break;
            case "ceiling":
                book = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.ceiling(book));
                break;
            default:
                break;
            }
        }
    }
}