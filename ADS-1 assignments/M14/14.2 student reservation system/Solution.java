import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Solution class for alloting the seats based on the given
 * criteria.
 */
public final class Solution {

    /**
     * Default constructor.
     */
    private Solution() {

    }

    /**
     * main method to demostrate the solution.
     * @param args the command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int noCategry = Integer.parseInt(scan.nextLine());
        int noOfBC = Integer.parseInt(scan.nextLine());
        int noOfSC = Integer.parseInt(scan.nextLine());
        int noOfST = Integer.parseInt(scan.nextLine());

        Student[] students = new Student[n];
        for (int k = 0; k < n; k++) {
            String[] tokens = scan.nextLine().split(",");
            students[k] = new Student(
                tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[2 + 1]),
                Integer.parseInt(tokens[2 + 2]),
                Integer.parseInt(tokens[2 + 2 + 1]),
                tokens[2 + 2 + 2]);
        }

        Heap.sort(students);
        print(students);

        allotment(students, vacancies, noCategry, noOfBC,
                  noOfSC, noOfST);
    }

    /**
     * prints the student details to the console.
     *
     * @param      students  list.
     */
    public static void print(final Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    /**
     * Alloting the seats to the students based on merit.
     * @param students  list of students.
     * @param vacancies number of vacancies.
     * @param noCategry Un-reserved category.
     * @param noBC      Number of BC seats.
     * @param noSC      Number of SC seats.
     * @param noST      Number of ST seats.
     */
    public static void allotment(final Student[] students,
                                final int vacancies,
                                final int noCategry,
                                final int noBC,
                                final int noSC,
                                final int noST) {
        int v = vacancies;
        int n1 = noCategry;
        int nb = noBC;
        int ns = noSC;
        int nt = noST;
        int i = 0;
        int k = 0;
        int n = students.length;
        Student[] alloted = new Student[v];

        for (i = 0; i < n; i++) {
            if (v == 0) {
                break;
            }

            if (n1 > 0) {
                n1--;
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                v--;
            }

            if (nb > 0) {
                if (students[i].getRc().equals("BC")
                    && !students[i].getAlloted()) {
                    nb--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }

            if (ns > 0) {
                if (students[i].getRc().equals("SC")
                    && !students[i].getAlloted()) {
                    ns--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }

            if (ns > 0) {
                if (students[i].getRc().equals("ST")
                    && !students[i].getAlloted()) {
                    nt--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (v > 0 && students[i].getRc().equals("Open")
                && !students[i].getAlloted()) {
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                v--;
            }
        }

        Heap.sort(alloted);
        print(alloted);
    }
}
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * student name variable.
     */
    private String studentName;
    /**
     * date variable.
     */
    private Date db;
    /**
     * for marks1 variable.
     */
    private int m1;
    /**
     * for marks2 variable.
     */
    private int m2;
    /**
     * for mark3 variable.
     */
    private int m3;
    /**
     * for total marks variable.
     */
    private int tm;
    /**
     * for reservation variable.
     */
    private String rc;
    /**
     * Seats allocated variable.
     */
    private boolean alloted;
    /**
     * returns true, if the student is already alloted,
     * otherwise false.
     *
     * @return true if alloted, otherwise false.
     */
    public boolean getAlloted() {
        return alloted;
    }

    /**
     * Changes the alloted status to true once the allotment is done.
     *
     * @param      allot  should be either true or false.
     */
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }

    /**
     * Gets the data of birth.
     * @return date of birth.
     */
    public Date getDb() {
        return db;
    }

    /**
     * sets the student's date of birth.
     *
     * @param      b     [description]
     */
    public void setDb(final Date b) {
        this.db = b;
    }

    /**
     * gets the date of birth.
     *
     * @return     the student's date of birth.
     */
    public String getRc() {
        return rc;
    }

    /**
     * Sets the student's reservation category.
     *
     * @param      r     { parameter_description }
     */
    public void setRc(final String r) {
        this.rc = r;
    }

    /**
     * gets the total marks.
     * @return returns the total marks of the student.
     */
    public int getTm() {
        return tm;
    }

    /**
     * sets the student's total marks.
     *
     * @param      m     { parameter_description }
     */
    public void setTm(final int m) {
        this.tm = m;
    }

    /**
     * Constructs the object based on the parameters.
     *
     * @param      stuName      Student Name
     * @param      dateOfBirth  Date of Birth
     * @param      mm1          Marks in first subject.
     * @param      mm2          Marks in second subject.
     * @param      mm3          Marks in third subject.
     * @param      total        The total
     * @param      res          The resource
     */
    Student(final String stuName, final String dateOfBirth,
                   final int mm1, final int mm2, final int mm3, final int total,
                   final String res) {
        this.studentName = stuName;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.m1 = mm1;
        this.m2 = mm2;
        this.m3 = mm3;
        this.tm = total;
        this.rc = res;
        this.alloted = false;
    }

    /**
     * Gets the marks in subject 3.
     *
     * @return     m3 Marks in subject 3.
     */
    public int getM3() {
        return m3;
    }

    /**
     * Sets the m3 to the 3rd subject.
     *
     * @param      m     { parameter_description }
     */
    public void setM3(final int m) {
        this.m3 = m;
    }

    /**
     * Gets the marks in subject 2.
     *
     * @return     marks in subject 2.
     */
    public int getM2() {
        return m2;
    }

    /**
     * Sets marks in subject 2.
     *
     * @param      m     { parameter_description }
     */
    public void setM2(final int m) {
        this.m2 = m;
    }

    /**
     * Gets the marks in subject 1.
     * @return marks in subject 1.
     */
    public int getM1() {
        return m1;
    }

    /**
     * Sets the marks to subject 1.
     *
     * @param      m     { parameter_description }
     */
    public void setM1(final int m) {
        this.m1 = m;
    }

    /**
     * Gets the student name.
     * @return the student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * When required the student's name can be updated.
     *
     * @param      student  The student
     */
    public void setStudentName(final String student) {
        this.studentName = student;
    }

    /**
     * Compares two objects of types students.
     * @param  that second Student.
     * @return integer based on the requirements.
     */
    public int compareTo(final Student that) {
        if (this.getTm() > that.getTm()) {
            return -1;
        }
        if (this.getTm() < that.getTm()) {
            return 1;
        }
        if (this.getM3() > that.getM3()) {
            return -1;
        }
        if (this.getM3() < that.getM3()) {
            return 1;
        }
        if (this.getM2() > that.getM2()) {
            return -1;
        }
        if (this.getM2() < that.getM2()) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) < 0) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) > 0) {
            return -1;
        }
        return 0;
    }

    /**
     * Gets the String version of the Students.
     * @return String version of object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTm() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}

/**
 * Class for heap.
 */
final class Heap {
    /**
     * Constructs the object.
     */
    private Heap() {
    /**
     * empty constructer.
     */
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * Time complexity is N log N.
     *
     * @param      pq    the array to be sorted
     */
    public static void sort(final Comparable[] pq) {
        int n = pq.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }
    /**
     * to sink the values.
     * Time complexity is log N.
     *
     * @param      pq    { parameter_description }
     * @param      k     { parameter_description }
     * @param      n     { parameter_description }
     */
    private static void sink(final Comparable[] pq, final int k, final int n) {
        int l = k;
        while (2 * l <= n) {
            int j = 2 * l;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, l, j)) {
                break;
            }
            exch(pq, l, j);
            l = j;
        }
    }

    /**
     * to compare the values.
     * Time complexity is 1.
     *
     * @param      pq    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private static boolean less(final Comparable[] pq, final int i,
        final int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    /**
     * to exchange the values.
     * Time complexity is N.
     *
     * @param      pq    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private static void exch(final Object[] pq, final int i, final int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    /**
     * to display the data.
     * Time complexity is N.
     *
     * @param      a     { parameter_description }
     */
    private static void show(final Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
