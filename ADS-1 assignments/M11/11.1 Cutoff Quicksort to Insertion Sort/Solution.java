import java.util.Scanner;
class Sorting {
    Sorting() {

    }
    public void insertion(final Comparable[] array, final int low,
     final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }
    public void swap(final Comparable[] array, final int j, final int min) {
        Comparable temp = array[j];
        array[j] = array[min];
        array[min] = temp;
    }
    public String toString(final Comparable[] array) {
        String str = "[";
        for (int i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[array.length - 1] + "]";
        return str;
    }
    public void sort(final Comparable[] array, final int low,
     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(array, low, high);
        System.out.println(toString(array));
        sort(array, low, k - 1, cutOff);
        sort(array, k + 1, high, cutOff);
    }
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
    public int partition(final Comparable[] array,
     final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}

public final class Solution {

    private Solution() {
        
    }
public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Sorting sort = new Sorting();
        int testcases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i <= testcases; i++) {
            int j = Integer.parseInt(scan.nextLine());
            // scan.nextLine();
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[ ]");
            } else {
                sort.sort(tokens, j);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}