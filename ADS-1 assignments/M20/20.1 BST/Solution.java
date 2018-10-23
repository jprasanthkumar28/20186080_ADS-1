import java.util.Scanner;
/**
 * Class for book details.
 */
class Book implements Comparable {
    /**
     * variable declaration.
     */
    private String name;
    /**
     * variable declaration.
     */
    private String author;
    /**
     * variable declaration.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      nm    The bookname
     * @param      au  The bookauthor
     * @param      cost   The bookprice
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
     * compare to method that returns integer.
     *
     * @param      object  The object
     *
     * @return  integer.
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
 * Class for binary search tree.
 */
class BinaryTree {
    /**
     * variable declaration.
     */
    private Node root;
    /**
     * Class for node.
     */
    private final class Node {
        /**
         * variable declaration.
         */
        private Book key;
        /**
         * variable declaration.
         */
        private int val;
        /**
         * variable declaration.
         */
        private Node left;
        /**
         * variable declaration.
         */
        private Node right;
        /**
         * variable declaration.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1   The value
         * @param      s  The size 1
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
     * size method.
     *
     * @return size.
     */
    public int size() {
        return size(root);
    }
    /**
     * size overloaded method.
     *
     * @param      x Node
     *
     * @return size.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * get method.
     * Time complexity is logN
     * @param      key   The key
     *
     * @return  integer.
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
     * Put.
     * Time complexity is logN
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final int val) {
        root = put(root, key, val);
    }
    /**
     * Put.
     * Time complexity is logN
     * @param      x   root node.
     * @param      key   The key
     * @param      val   The value
     *
     * @return root
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
     * deleteing minimum element.
     * Time complexity is 1.
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * deleting minimum element with node value.
     * Time complexity is logN.
     *
     * @param      x     Node variable.
     *
     * @return     return x value.
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Removes the largest key and associated value from the symbol table.
     * Time complexity is 1.
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * Removes the largest element with node value.
     * Time complexity is logN.
     *
     * @param      x     Node variable.
     *
     * @return     return x value.
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     * Time complexity is 1.
     *
     * @param      key   The key
     */
    public void delete(final Book key) {
        root = delete(root, key);
    }

    /**
     * delete the element that given.
     * Time complexity is N.
     *
     * @param      x     Node variable.
     * @param      key   The key
     *
     * @return     return x value.
     */
    private Node delete(final Node x, final Book key) {
        Node x1 = x;
        if (x1 == null) {
            return null;
        }
        int cmp = key.compareTo(x1.key);
        if (cmp < 0) {
            x1.left  = delete(x1.left,  key);
        } else if (cmp > 0) {
            x1.right = delete(x1.right, key);
        } else {
            if (x1.right == null) {
                return x1.left;
            }
            if (x1.left  == null) {
                return x1.right;
            }
            Node t = x1;
            x1 = min(t.right);
            x1.right = deleteMin(t.right);
            x1.left = t.left;
        }
        x1.size = size(x1.left) + size(x1.right) + 1;
        return x1;
    }
    /**
     * minimum.
     * Time complexity is 1.
     * @return minimum.
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * minimum.
     * Time complexity is logN
     * @param      x Node
     *
     * @return minimum.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * maximum.
     * Time complexity is 1.
     * @return maximum.
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * maximum.
     * Time complexity is logN
     * @param      x Node
     *
     * @return maximum.
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * floor.
     * Time complexity is 1.
     * @param      key   The key
     *
     * @return  key
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
     *
     * floor.
     * Time complexity is logN
     * @param      x Node
     * @param      key   The key
     *
     * @return floor.
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
     * ceiling.
     * Time complexity is 1.
     * @param      key   The key
     *
     * @return key.
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
     * ceiling..
     * Time complexity is logN
     * @param      x Node
     * @param      key   The key
     *
     * @return     return ceiling value.
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
     * Select.
     * Time complexity is 1.
     * @param      k     Integer
     *
     * @return     Book Object
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * Select.
     * Time complexity is logN.
     * @param      x     {Node}
     * @param      k     {Integer}
     *
     * @return     {Node}
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
     * rank.
     * Time complexity is 1.
     * @param      key   The key
     *
     * @return     {Integer}
     */
    public int rank(final Book key) {
        return rank(key, root);
    }
    /**
     * rank.
     * Time complexity is logN
     * @param      key   The key
     * @param      x     Node variable.
     *
     * @return     Integer
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
 * client program.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree bst = new BinaryTree();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            final int three = 3;
            final int four = 4;
            switch (tokens[0]) {
            case "put":
                Book books = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                bst.put(books, Integer.parseInt(tokens[four]));
            break;
            case "get":
                books = new Book(tokens[1], tokens[2],
                                        Float.parseFloat(tokens[three]));
                if (bst.get(books) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(books));
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
                books = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                System.out.println(bst.floor(books));
            break;
            case "ceiling":
                books = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                System.out.println(bst.ceiling(books));
            break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            case "delete":
                books = new Book(tokens[1], tokens[2],
                                        Float.parseFloat(tokens[three]));
                bst.delete(books);
                break;
            default:
            break;
            }
        }
    }
}
