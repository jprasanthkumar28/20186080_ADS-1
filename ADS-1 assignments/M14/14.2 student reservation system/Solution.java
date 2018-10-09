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
     * @param students list.
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
                                 int vacancies,
                                 int noCategry,
                                 int noBC,
                                 int noSC,
                                 int noST) {
        int i = 0;
        int k = 0;
        int n = students.length;
        Student[] alloted = new Student[vacancies];

        for (i = 0; i < n; i++) {
            if (vacancies == 0) {
                break;
            }

            if (noCategry > 0) {
                noCategry--;
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }

            if (noBC > 0) {
                if (students[i].getRc().equals("BC") &&
                        students[i].getAlloted() != true) {
                    noBC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("SC") &&
                        students[i].getAlloted() != true) {
                    noSC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("ST") &&
                        students[i].getAlloted() != true) {
                    noST--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (vacancies > 0 && students[i].getRc().equals("Open") &&
                    students[i].getAlloted() == false) {
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
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
    private String studentName;
    private Date db;
    private int m1;
    private int m2;
    private int m3;
    private int tm;
    private String rc;
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
     * @param      studentName  Student Name
     * @param      dateOfBirth  Date of Birth
     * @param      m1           Marks in first subject.
     * @param      m2           Marks in second subject.
     * @param      m3           Marks in third subject.
     * @param      tm           Total Marks.
     * @param      rc           Reservation Category.
     */
    Student(String studentName, String dateOfBirth,
                   int m1, int m2, int m3, int tm,
                   String rc) {
        this.studentName = studentName;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.tm = tm;
        this.rc = rc;
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
     * @param student.
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

class Heap {

    private Heap() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }
    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}