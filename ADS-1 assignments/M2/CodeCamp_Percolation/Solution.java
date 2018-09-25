import java.util.Scanner;
/**
 * Class for percolation.
 * @author Prasanth...
 */
class Percolation {
	private int size, n, first, last;
	private boolean[] connected;
	private WeightedQuickUnionUF weight;
	// create n-by-n grid, with all sites blocked
   public Percolation(int n1) {
   	this.first = size;
   	this.last = size + 1;
   	this.n = n1;
   	this.size = n1 * n1;
   	this.connected = new boolean[size];
   	this.weight = new WeightedQuickUnionUF(size + 2);
   	for (int i = 0; i < n; i++) {
   		weight.union(first, i);
   		weight.union(first, size - i - 1);
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
   	return n * (i - 1) + j - 1;
   }
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
   		if (n == 1) {
   			weight.union(first, index);
   			weight.union(last, index);
   			return;
   		}
   		int bottom = index + n;
   		int top = index - n;
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
   public boolean isOpen(final int row, final int col)  { // is site (row, col) open?
   		
   		return connected[indexOf(row, col)];

   }

   // /**
   //  * Determines if full.
   //  *
   //  * @param      row   The row
   //  * @param      col   The col
   //  *
   //  * @return     True if full, False otherwise.
   //  */
   //  // is site (row, col) full?
   // public boolean isFull(final int row, fianl int col)  {
	  //  	return false;
   // }

   // /**
   //  * Tells about number of sites.
   //  *
   //  * @return     { description_of_the_return_value }
   //  */
   // public int numberOfOpenSites() {
   // // number of open sites
   // 	return 0;

   // }
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
	private Solution() {
		//Empty Constructor.
	}
	public static void main(final String[] args) {
		// WeightedQuickUnionUF weight = new WeightedQuickUnionUF(n);
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Percolation perculation = new Percolation(n);
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			perculation.open(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
		}
		System.out.println(perculation.percolates());
	}
}
// You can implement the above API to solve the problem