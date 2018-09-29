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
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
    LinkedList llist = new LinkedList();
    	// LinkedList l;
    	llist.push(number);
    	return llist;
    }

    public static String digitsToNumber(LinkedList list) {
    	// LinkedList llist = new LinkedList();
    	
    	return list.pop();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	LinkedList list = new LinkedList();
    	return list;
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
                LinkedList pDigits1 = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits2 = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits1, qDigits2);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
