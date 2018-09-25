import java.util.Scanner;
/**
 * Class for percolation.
 * @author Prasanth...
 */
class Percolation {
    /**
     * varaibles size, n, first and last;
     */
    private int size, n, first, last, count;
    /**
     * for connected.
     */
    private boolean[] connected;
    /**
     * for weight object.
     */
    private WeightedQuickUnionUF weight;
    /**
     * Constructs the object.
     *
     * @param      n1    The n 1
     */
   protected Percolation(final int n1) {
    this.size = n1 * n1;
    this.first = size;
    this.last = size + 1;
    this.count = 0;
    this.n = n1;
    this.connected = new boolean[size];
    weight = new WeightedQuickUnionUF(size + 2);
    for (int i = 0; i < n; i++) {
        weight.union(first, i);
        weight.union(last, size - i - 1);
    }

   }

   /**
    * Searches for the first match.
    *
    * @param      i     { parameter_description }
    * @param      j     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
   private int indexOf(final int i, final int j) {
    return (n * (i - 1)) + (j - 1);
   }
   /**
    * Links open sites.
    *
    * @param      row   The row
    * @param      col   The col
    */
   private void linkOpenSites(final int row, final int col) {
        if (connected[col] && !weight.connected(row, col)) {
            weight.union(row, col);
        }
   }
   /**
    * Open function.
    *
    * @param      row   The row
    * @param      col   The col
    */
    // open site (row, col) if it is not open already
   public void open(final int row, final int col) {
        int index = indexOf(row, col);
        connected[index] = true;
        count++;
        int bottom = index + n;
        int top = index - n;
        if (n == 1) {
            weight.union(first, index);
            weight.union(first, index);
        }
        if (bottom < size) {
            linkOpenSites(index, bottom);
        }
        if (top >= 0) {
            linkOpenSites(index, top);
        }
        if (col == 1) {
            if (col != n) {
                linkOpenSites(index, index + 1);
            }
            return;
        }
        if (col == n) {
            linkOpenSites(index, index - 1);
            return;
        }
        linkOpenSites(index, index + 1);
        linkOpenSites(index, index - 1);
   }

   /**
    * Determines if open.
    *
    * @param      row   The row
    * @param      col   The col
    *
    * @return     True if open, False otherwise.
    */
   public boolean isOpen(final int row, final int col)  {
   // is site (row, col) open?
        return connected[indexOf(row, col)];

   }

   /**
    * Tells about number of sites.
    *
    * @return     { description_of_the_return_value }
    */
   public int numberOfOpenSites() {
   // number of open sites
    return count;

   }
   /**
    * { function_description }
    *
    * @return     { description_of_the_return_value }
    */
   public boolean percolates() {
    // does the system percolate?
    return weight.connected(first, last);
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
        //Empty Constructor.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // WeightedQuickUnionUF weight = new WeightedQuickUnionUF(n);
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Percolation perculation = new Percolation(n);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            perculation.open(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
        }
        System.out.println(perculation.percolates()
            && perculation.numberOfOpenSites() != 0);
    }
}
