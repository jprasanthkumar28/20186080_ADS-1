import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        private int value;
        private Node next;
        private int size = 0;
    }
    Steque() {
        head = null;
        tail = null;
    }
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
    public int pop() {
        if (head != null) {
            int value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return head == null || tail == null;
    }
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
public final class Solution {
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