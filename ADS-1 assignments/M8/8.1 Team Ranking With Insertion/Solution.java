import java.util.Scanner;
import java.util.Arrays;
class Cricket implements Comparable<Cricket> {
    private String teamName;
    private int wins;
    private int losses;
    private int draws;
    Cricket() {
        this.teamName = null;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    Cricket(final String name, final int win, final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    public String getTeamName() {
        return this.teamName;
    }
    public int getWins() {
        return this.wins;
    }
    public int getLosses() {
        return this.losses;
    }
    public int getDraws() {
        return this.draws;
    }
    public void setName(final String s) {
        this.teamName = s;
    }
    public void setWins(final int w) {
        this.wins = w;
    }
    public void setLosses(final int l) {
        this.losses = l;
    }
    public void setDraws(final int d) {
        this.draws = d;
    }
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
     //    	|| (this.getLosses() > that.getLosses()
     //    		|| (this.getDraws() < that.getDraws())))  {
     //        return 1;
    	// } else {
     //    	return -1;
    	// }
    }

}
class SelectionSort {
    private Cricket[] champions;
    private int size;
    SelectionSort() {
        final int x = 10;
        this.champions = new Cricket[10];
        this.size = 0;
    }
    public void resize() {
        champions = Arrays.copyOf(champions, 2 * champions.length);
    }
    public int getSize() {
        return this.size;
    }
    public void add(final Cricket t) {
        if (size == champions.length) {
            resize();
        }
        champions[size++] = t;
    }
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
 //    	return v.compareTo(w) < 0;
 //    }
 //    private static void exch(Cricket[] a, int i, int j) {
	// 	Cricket swap = a[i];
	// 	a[i] = a[j];
	// 	a[j] = swap;
	// }
	// public void sort() {
	// 	int N = champions.length;
	// 	for (int i = 0; i < N; i++)
	// 	for (int j = i; j > 0; j--)
	// 	if (less(champions[j], champions[j-1]))
	// 	exch(champions, j, j-1);
	// 	else break;
	// }

    public void display() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(champions[i].getTeamName() + ",");
        }
        System.out.println(champions[i].getTeamName());
    }
}
public class Solution {
    private Solution() {
        //Empty Contructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SelectionSort match = new SelectionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            match.add(new Cricket(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        }
        match.sort();
        match.display();
    }
}