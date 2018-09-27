import java.util.Scanner;
/**
 * Linked Lists.
 */
class LinkedList {
    /**
     * Node variable.
     */
    private Node head;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * character for item.
         */
        private char item;
        /**
         * Node object for next.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }
    /**
     * to pop the element.
     *
     * @return     element on the top.
     */
    public char pop() {
        if (head != null) {
            char value = head.item;
            head = head.next;
            return value;
        }
        return '\0';
    }
    /**
     * to push the element.
     *
     * @param      value  The value
     */
    public void push(final char value) {
        Node oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
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
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int j = 0;
        while (j < n) {
            boolean value = check(scan);
            if (value) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            j++;
        }
    }
    /**
     * {Method to check whether the parenthesis are balanced}.
     *
     * @param      scan  The scanner object
     *
     * @return     {Boolean}
     */
public static boolean check(final Scanner scan) {
        boolean res = false;
        LinkedList llist = new LinkedList();
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                llist.push(ch);
            } else if (llist.isEmpty()) {
                res = false;
                return res;
            } else if (ch == ')') {
                if (llist == null || llist.pop() != '(') {
                    res = false;
                    return res;
                }
            } else if (ch == ']') {
                if (llist == null || llist.pop() != '[') {
                    res = false;
                    return res;
                }
            } else if (ch == '}') {
                if (llist == null || llist.pop() != '{') {
                    res = false;
                    return res;
                }
            }
        }
        if (llist.isEmpty()) {
            res = true;
            return res;
        } else {
            return res;
        }
    }
}
