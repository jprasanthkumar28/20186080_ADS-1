import java.util.Scanner;
public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        else if (this.sum == that.sum) {
            System.out.println("----->" + sum);
            // break;
        }
        else if (this.i > that.i) return -1;
        else if (this.j < that.j) return 1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // initialize priority queue
        
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        pq.insert(new CubeSum(0,0));
        for (int i = 1; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }

        // find smallest sum, print it out, and update
        int count = 0;
        CubeSum[] cubeSum = new CubeSum[2];
        while (!pq.isEmpty()) {
            //System.out.println(pq);
            CubeSum s = pq.delMin();

            // System.out.println(s);
            if (s.j <= n) {
                pq.insert(new CubeSum(s.i, s.j + 1));
            }       
        }
    }
}
