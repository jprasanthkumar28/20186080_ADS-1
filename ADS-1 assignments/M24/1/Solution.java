import java.util.Scanner;
import java.util.*;
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * name variable.
     */
    private String name;
    /**
     * rollNum variable.
     */
    private int rollNum;
    /**
     * total variable.
     */
    private double total;
    protected Student(final String nm, final int num, final double tm) {
        this.name = nm;
        this.rollNum = num;
        this.total = tm;
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
     * Gets the rollNum.
     *
     * @return     The rollNum.
     */
    public int getNumber() {
        return this.rollNum;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public double getMarks() {
        return this.total;
    }
    /**
     * to compare the students.
     *
     * @param      that  The that
     *
     * @return     1 if greater , -1 if lesser and 0 if equal.
     */
    public int compareTo(final Student that) {
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
         * Student class object for key.
         */
        private Student mainKey;
        /**
         * value variable.
         */
        private String value;
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
        Node(final Student key, final String value1) {
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
    public void put(final Student key, final String value) {
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
    public Node put(final Node a, final Student key, final String value) {
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
    public String get(final Student key) {
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
            System.out.println(Arrays.toString(tokens));
            switch (tokens[0]) {
                case "put":
                Student student = new Student(tokens[1], Integer.parseInt(tokens[2]),Double.parseDouble(tokens[2 + 2]));
                bt.put(student, tokens[2 + 2]);
                break;
                case "get":
                student = new Student(tokens[1], Integer.parseInt(tokens[2]),Double.parseDouble(tokens[2 + 1]));
                System.out.println(bt.get(student));
                break;
                default:
                break;
            }
        }
    }
}
