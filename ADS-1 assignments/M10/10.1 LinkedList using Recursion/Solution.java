import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
	/**
	 * value varaible.
	 */
	public int value;
	/**
	 * next varaible.
	 */
	public Node next;
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 *
	 * @param      data  The data
	 */
	Node(int data) {
		value = data;
		next = null;
	}
	/**
	 * Gets the next.
	 * Time complexity is 1.
	 *
	 * @return     The next.
	 */
	public Node getNext() {
		return next;
	}
}
/**
 * List of linkeds.
 */
class LinkedList {
	/**
	 * head varaible.
	 */
	private Node head;
	/**
	 * size varaible.
	 */
	private int size;
	/**
	 * Constructs the object.
	 * Time complexity is 1.
	 */
	LinkedList() {
		head = null;
		size = 0;
	}
	/**
	 * to get the size of the list.
	 * Time complexity is 1.
	 *
	 * @return     size.
	 */
	public int length() {
		return size;
	}
	/**
	 * Determines if empty.
	 * Time complexity is 1.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return head == null;
	}
	/**
	 * to insert the element using position and value that to be inserted.
	 * Time complexity is 1.
	 * 
	 *
	 * @param      position  The position
	 * @param      value    The value 1
	 */
	public void insertAt(int position, int value) {
		insertAt(head, position, value);
	}
	private void insertAt(Node node, int position, int value) {
		if (position == 0 && head == null) {
			head = new Node(value);
		} else if (position == 0 && head != null) {
			Node oldhead = head;
			head = new Node(value);
			head.next = oldhead;
		} else {
			Node temp = head;
			for (int i = 0; i < position - 1; i++) {
				temp = temp.getNext();
			}
			Node nextNode = temp.getNext();
			node = new Node(value);
			temp.next = node;
			node.next = nextNode;
		}
		size++;
	}
	private Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
	public void reverse() {
		head = reverse(head);
	}
	public String toString() {
		String s = "";
		if (size != 0) {
			Node temp = head;
			while (temp != null) {
				s += temp.value + ", ";
				temp = temp.next;
			}
		}
		return s.substring(0, s.length() - 2);
	}

}
public class Solution {

	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "insertAt":
				if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                        tokens[1]) > list.length() + 1) {
                        System.out.println("Can't insert at this position.");
                    } else {
                        list.insertAt(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                        System.out.println(list.toString());
                    }
                    break;
			case "reverse":
				if (!list.isEmpty()) {
					list.reverse();
					System.out.println(list.toString());
				} else {
					System.out.println("No elements to reverse.");
					break;
				}
			}
		}

	}
}