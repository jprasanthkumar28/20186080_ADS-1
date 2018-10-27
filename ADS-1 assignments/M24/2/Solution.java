import java.util.Scanner;
import java.util.*;
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
		int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(",");
            // Student st = new Student(tokens[0], Integer.parseInt(tokens[1]),Double.parseDouble(tokens[2]));
            System.out.println(Arrays.toString(tokens));
        }
        int n1 = Integer.parseInt(scan.nextLine());
        // System.out.println(n1);
        while (n1 != 0) {
            String[] val = scan.nextLine().split(",");
            System.out.println(Arrays.toString(val));
            n1--;
        //     switch (val[0]) {
        //     case "BE":
        //         for (double d = Double.parseDouble(val[1]); d <= Double.parseDouble(val[2]); d++) {
        //             System.out.println("hi");
        //         }
        //     break;
        //     default:
        //     break;
        // }
        }
    }
}

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