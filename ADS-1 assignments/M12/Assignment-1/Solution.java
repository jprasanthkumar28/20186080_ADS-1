import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * student name varaible.
     */
    private String studentName;
    /**
     * dob varaible.
     */
    private String dob;
    /**
     * marks1 varaible.
     */
    private int marks1;
    /**
     * marks2 varaible.
     */
    private int marks2;
    /**
     * marks3 varaible.
     */
    private int marks3;
    /**
     * total marks varaible.
     */
    private int total;
    /**
     * to category varaible.
     */
    private String category;
    /**
     * Constructs the object.
     */
    Student() {
        this.studentName = null;
        this.dob = null;
        this.marks1 = 0;
        this.marks2 = 0;
        this.marks3 = 0;
        this.total = 0;
        this.category = null;
    }
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      birth  The birth
     * @param      m1     The m 1
     * @param      m2     The m 2
     * @param      m3     The m 3
     * @param      full   The full
     * @param      cat    The cat
     */
    Student(final String name, final String birth, final int m1,
        final int m2, final int m3, final int full,
        final String cat) {
        this.studentName = name;
        this.dob = birth;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.total = full;
        this.category = cat;
    }
    /**
     * Gets the student name.
     *
     * @return     The student name.
     */
    public String getStudentName() {
        return this.studentName;
    }
    /**
     * Gets the dob.
     *
     * @return     The dob.
     */
    public String getDob() {
            return this.dob;
    }
    /**
     * Gets the marks 1.
     *
     * @return     The marks 1.
     */
    public int getMarks1() {
            return this.marks1;
    }
    /**
     * Gets the marks 2.
     *
     * @return     The marks 2.
     */
    public int getMarks2() {
        return this.marks2;
    }
    /**
     * Gets the marks 3.
     *
     * @return     The marks 3.
     */
    public int getMarks3() {
        return this.marks3;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return this.total;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * Sets the student name.
     *
     * @param      s     { parameter_description }
     */
    public void setStudentName(final String s) {
        this.studentName = s;
    }
    /**
     * Sets the dob.
     *
     * @param      d     { parameter_description }
     */
    public void setDob(final String d) {
        this.dob = d;
    }
    /**
     * Sets the marks 1.
     *
     * @param      mm1   The millimeters 1
     */
    public void setMarks1(final int mm1) {
        this.marks1 = mm1;
    }
    /**
     * Sets the marks 2.
     *
     * @param      mm2   The millimeters 2
     */
    public void setMarks2(final int mm2) {
        this.marks2 = mm2;
    }
    /**
     * Sets the marks 3.
     *
     * @param      mm3   The millimeters 3
     */
    public void setMarks3(final int mm3) {
        this.marks3 = mm3;
    }
    /**
     * Sets the total.
     *
     * @param      t     { parameter_description }
     */
    public void setTotal(final int t) {
        this.total = t;
    }
    /**
     * to compare the details based on wins,losses and draws.
     * Time complexity is 1.
     *
     * @param      that  The that
     *
     * @return     1 if it is true or else -1.
     */
    public int compareTo(final Student that) {
        if (this.getTotal() < that.getTotal()) {
            return 1;
        } else if (this.getTotal() > that.getTotal()) {
            return -1;
            // break;
        } else {
            if (this.getMarks3() > that.getMarks3()) {
                return 1;
            } else if (this.getMarks3() < that.getMarks3()) {
                return -1;
            } else {
                if (this.getMarks2() < that.getMarks2()) {
                    return 1;
                } else if (this.getMarks2() > that.getMarks2()) {
                    return -1;
                }
            }
        }
        return 0;
     //    if ((this.getWins() < that.getWins())
     //     || (this.getLosses() > that.getLosses()
     //         || (this.getDraws() < that.getDraws())))  {
     //        return 1;
        // } else {
     //     return -1;
        // }
     // else {
                //     if (this.getDob() < that.getDob()) {
                //         return 1;
                // } else if (this.getDob() > that.getDob()) {
                //     return -1;
                // }
    }

}
/**
 * Class for selection sort.
 */
class SelectionSort {
    /**
     * to store the students.
     */
    private Student[] students;
    /**
     * for varaible ten.
     */
    private static final int HUN = 100;
    /**
     * to get the size.
     */
    private int size;
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    SelectionSort() {
        // final int x = 10;
        this.students = new Student[HUN];
        this.size = 0;
    }
    /**
     * to resize the array.
     * Time complexity is 1.
     */
    public void resize() {
        students = Arrays.copyOf(students, 2 * students.length);
    }
    /**
     * Gets the size.
     * Time complexity is 1.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * to add the data of cricket class.
     * Time complexity is 1.
     *
     * @param      t     { parameter_description }
     */
    public void add(final Student t) {
        if (size == students.length) {
            resize();
        }
        students[size++] = t;
        // System.out.println(students);
    }
    /**
     * to sort the elements based on wins, losses, draws.
     * Time complexity is N * N.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (students[j].compareTo(students[min]) == -1) {
                    min = j;
                }
            }
            exch(students, i, min);
        }
    }
    /**
     * to swap.
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     * Tie complexity is N.
     */
    public void exch(final Student[] a, final int i, final int j) {
        Student swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * to display the data of class.
     * Time complexity is N.
     */
    public void display() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(students[i].getStudentName() + ","
                + students[i].getTotal() + "," + students[i].getCategory());
        }
        System.out.println();
        // for (i = 0; i < size - 1; i++) {
        //     System.out.print(students[i] + ",");
        // }

    }
}
/**
 * client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    /**
     * variable five.
     */
    private static final int FIVE = 5;
    /**
     * varible six.
     */
    private static final int SIX = 6;
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty Contructor.
    }
    /**
     * client function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SelectionSort stu = new SelectionSort();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            int vacancies = scan.nextInt();
            int unreserved = scan.nextInt();
            int categoryBC = scan.nextInt();
            int categorySC = scan.nextInt();
            int categoryST = scan.nextInt();
            String[] tokens = line.split(",");
            // stu.add(new Student(tokens[0], tokens[1],
            //     Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]),
            //     Integer.parseInt(tokens[2 + 2]),
            //     Integer.parseInt(tokens[FIVE]), tokens[SIX]));
            stu.add(new Student());
            System.out.println(Arrays.toString(tokens));
        }
        stu.sort();
        stu.display();
    }
}
