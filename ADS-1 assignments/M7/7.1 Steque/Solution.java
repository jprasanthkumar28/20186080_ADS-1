import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
	/**
	 * head varible.
	 */
    private Node head;
    /**
     * tail node.
     */
    private Node tail;
    /**
     * size.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        private int value;
        private Node next;
        private int size = 0;
    }
    /**
     * Constructs the object.
     */
    Steque() {
        head = null;
        tail = null;
    }
    /**
     * to push.
     *
     * @param      value  The value
     */
    public void push(final int value) {
        Node newnode = new Node();
        if (head == null) {
            newnode.value = value;
            newnode.next = null;
            head = newnode;
            tail = newnode;
        } else {
            Node oldHead = head;
            newnode.value = value;
            newnode.next = oldHead;
            head = newnode;
        }
        size++;
    }
    /**
     * to enqueue the data.
     *
     * @param      value  The value
     */
    public void enqueue(final int value) {
        Node temp = new Node();
        if (tail == null || head == null) {
            temp.value = value;
            temp.next = null;
            head = temp;
            tail = temp;
        } else {
            Node oldtail = tail;
            temp.value = value;
            temp.next = null;
            oldtail.next = temp;
            tail = temp;
        }
        size++;
    }
    /**
     * to pop the data.
     *
     * @return     the value on the top.
     */
    public int pop() {
        if (head != null) {
            int value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return 0;
    }
    /**
     * size function.
     *
     * @return     size.
     */
    public int size() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null || tail == null;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}
/**
 * Solution class.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
    private Solution() {
        //empty constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Steque stqueue = new Steque();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "push":
                    stqueue.push(Integer.parseInt(tokens[1]));
                    System.out.println(stqueue.toString());
                    break;

                case "pop":
                    stqueue.pop();
                    // if (stqueue.isEmpty()) {
                    //     System.out.println("Steque is empty.");
                    // } else {
                    //     System.out.println(stqueue.toString());
                    // }
                    break;

                case "enqueue":
                    stqueue.enqueue(Integer.parseInt(tokens[1]));
                    System.out.println(stqueue.toString());
                    break;

                default:
                    break;
                }

                if (tokens[0].equals("")) {
                    System.out.println();
                    break;
                }
            }
        }
    }
}