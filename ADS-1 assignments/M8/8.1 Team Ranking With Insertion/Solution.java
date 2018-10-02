import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for cricket.
 */
class Cricket implements Comparable<Cricket> {
    /**
     * teamName varaible.
     */
    private String teamName;
    /**
     * wins varaible.
     */
    private int wins;
    /**
     * losses varaible.
     */
    private int losses;
    /**
     * draws varaible.
     */
    private int draws;
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    Cricket() {
        /**
         * teamName varaible..
         */
        this.teamName = null;
        /**
         * for wins varaible.
         */
        this.wins = 0;
        /**
         * losses variable.
         */
        this.losses = 0;
        /**
         * draws varaible.
         */
        this.draws = 0;
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      name  The name
     * @param      win   The window
     * @param      loss  The loss
     * @param      draw  The draw
     */
    Cricket(final String name, final int win, final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    /**
     * Gets the team name.
     * Time complexity is 1.
     *
     * @return     The team name.
     */
    public String getTeamName() {
        return this.teamName;
    }
    /**
     * Gets the wins.
     * Time complexity is 1.
     *
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the losses.
     * Time complexity is 1.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return this.losses;
    }
    /**
     * Gets the draws.
     * Time complexity is 1.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * Sets the name.
     * Time complexity is 1.
     *
     * @param      s     { parameter_description }
     */
    public void setName(final String s) {
        this.teamName = s;
    }
    /**
     * Sets the wins.
     * Time complexity is 1.
     *
     * @param      w     { parameter_description }
     */
    public void setWins(final int w) {
        this.wins = w;
    }
    /**
     * Sets the losses.
     * Time complexity is 1.
     *
     * @param      l     { parameter_description }
     */
    public void setLosses(final int l) {
        this.losses = l;
    }
    /**
     * Sets the draws.
     * Time complexity is 1.
     *
     * @param      d     { parameter_description }
     */
    public void setDraws(final int d) {
        this.draws = d;
    }
    /**
     * to compare the details based on wins,losses and draws.
     * Time complexity is 1.
     *
     * @param      that  The that
     *
     * @return     1 if it is true or else -1.
     */
    public int compareTo(final Cricket that) {
        if (this.getWins() < that.getWins()) {
            return 1;
        } else if (this.getWins() > that.getWins()) {
            return -1;
            // break;
        } else {
            if (this.getLosses() > that.getLosses()) {
                return 1;
            } else if (this.getLosses() < that.getLosses()) {
                return -1;
            } else {
                if (this.getDraws() < that.getDraws()) {
                    return 1;
                } else if (this.getDraws() > that.getDraws()) {
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
    }

}
/**
 * Class for selection sort.
 */
class InsertionSort {
    /**
     * to store the champions.
     */
    private Cricket[] champions;
    /**
     * for varaible ten.
     */
    private static final int TEN = 10;
    /**
     * to get the size.
     */
    private int size;
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    InsertionSort() {
        // final int x = 10;
        this.champions = new Cricket[TEN];
        this.size = 0;
    }
    /**
     * to resize the array.
     * Time complexity is 1.
     */
    public void resize() {
        champions = Arrays.copyOf(champions, 2 * champions.length);
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
    public void add(final Cricket t) {
        if (size == champions.length) {
            resize();
        }
        champions[size++] = t;
    }
    /**
     * to sort the elements based on wins, losses, draws.
     * Time complexity is N * N.
     */
    public void sort() {
        for (int i = 1; i < size; i++) {
            Cricket tour = champions[i];
            int j = i - 1;
            int count = tour.compareTo(champions[j]);
            while (j >= 0 && count == -1) {
                champions[j + 1] = champions[j];
                j--;
                if (j >= 0) {
                    count = tour.compareTo(champions[j]);
                }
            }
            champions[j + 1] = tour;
        }
    }
 //    private static boolean less(Cricket v, Cricket w) {
 //     return v.compareTo(w) < 0;
 //    }
 //    private static void exch(Cricket[] a, int i, int j) {
    //  Cricket swap = a[i];
    //  a[i] = a[j];
    //  a[j] = swap;
    // }
    // public void sort() {
    //  int N = champions.length;
    //  for (int i = 0; i < N; i++)
    //  for (int j = i; j > 0; j--)
    //  if (less(champions[j], champions[j-1]))
    //  exch(champions, j, j-1);
    //  else break;
    // }

    /**
     * to display the data of class.
     * Time complexity is N.
     */
    public void display() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(champions[i].getTeamName() + ",");
        }
        System.out.println(champions[i].getTeamName());
    }
}
/**
 * Class for solution.
 */
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
        InsertionSort match = new InsertionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            match.add(new Cricket(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1])));
        }
        match.sort();
        match.display();
    }
}
