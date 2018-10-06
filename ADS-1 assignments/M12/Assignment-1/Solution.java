import java.util.Scanner;
import java.util.Arrays;
class Student implements Comparable<Student> {
    private String studentName;
    private String dob;
    private double marks1;
    private double marks2;
    private double marks3;
    private double total;
    private String category;
    Student() {
        this.studentName = null;
        this.dob = null;
        this.marks1 = 0.0;
        this.marks2 = 0.0;
        this.marks3 = 0.0;
        this.total = 0.0;
        this.category = null;
    }
    Student(final String name, final String birth, final double m1,
        final double m2, final double m3, final double full,
        final String cat) {
        this.studentName = name;
        this.dob = birth;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.total = full;
        this.category = cat;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public String getDob() {
            return this.dob;
    }
    public double getMarks1() {
            return this.marks1;
    }
    public double getMarks2() {
        return this.marks2;
    }
    public double getMarks3() {
        return this.marks3;
    }
    public double getTotal() {
        return this.total;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setStudentName(final String s) {
        this.studentName = s;
    }
    public void setDob(final String d) {
        this.dob = d;
    }
    public void setMarks1(final double mm1) {
        this.marks1 = mm1;
    }
    public void setMarks2(final double mm2) {
        this.marks2 = mm2;
    }
    public void setMarks3(final double mm3) {
        this.marks3 = mm3;
    }
    public void setTotal(final double t) {
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
    private static final int Hundred = 100;
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
        this.students = new Student[Hundred];
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
    // public void sort() {
    //  int N = students.length;
    //  for (int i = 0; i < N; i++)
    //  for (int j = i; j > 0; j--)
    //  if (less(students[j], students[j-1]))
    //  exch(students, j, j-1);
    //  else break;
    // }

    /**
     * to display the data of class.
     * Time complexity is N.
     */
    public void display() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(students[i].getStudentName() + ",");
        }
        System.out.println(students[i].getStudentName());
    }
}
public final class Solution {
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
        int n = Integer.parseInt(scan.nextLine());
        // System.out.println(n);
        int vacancies = scan.nextInt();
        // System.out.println(vacancies);
        int unreserved = scan.nextInt();
        // System.out.println(unreserved);
        int categoryBC = scan.nextInt();
        // System.out.println(categoryBC);
        int categorySC = scan.nextInt();
        // System.out.println(categorySC);
        int categoryST = scan.nextInt();
        // System.out.println(categoryST);
        
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(", ");
            stu.add(new Student(tokens[0], tokens[1],
                Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),
                Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), tokens[6]));
        //     final String name, final String birth, final double m1,
        // final double m2, final double m3, final double full,
        // final String cat
        }
        // System.out.println(Arrays.toString(tokens));
        stu.sort();
        stu.display();
    }
}