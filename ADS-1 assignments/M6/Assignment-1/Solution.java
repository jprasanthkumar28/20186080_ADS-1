import java.util.Scanner;
// import java.util.*;
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
        private String item;
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
    public String pop() {
        if (head != null) {
            String value = head.item;
            head = head.next;
            return value;
        }
        return null;
    }
    /**
     * to push the element.
     *
     * @param      value  The value
     */
    public void push(final String value) {
        Node oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
    }
}
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
	/**
	 * { function_description }
	 *
	 * @param      number  The number
	 *
	 * @return     the linked list object.
	 */
    public static LinkedList numberToDigits(String number) {
    LinkedList llist = new LinkedList();
    	llist.push(number);
    	// System.out.println(Arrays.toString(llist));
    	return llist;
    }

    /**
     * to convert digits to numbers.
     *
     * @param      list  The list
     *
     * @return     the String containing values of linked list.
     */
    public static String digitsToNumber(LinkedList list) {
    	// LinkedList llist = new LinkedList();
    	return list.pop();
    }

    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     the sum of the two linked lists.
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	LinkedList newlist1 = new LinkedList();
    	// LinkedList newlist2 = new LinkedList();
    	// newlist1 = list1.pop();
    	return newlist1;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
