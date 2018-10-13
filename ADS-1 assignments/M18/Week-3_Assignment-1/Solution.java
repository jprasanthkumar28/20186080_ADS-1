import java.util.*;
public class Solution {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
            int n = Integer.parseInt(scan.nextLine());
            // for (int k = 0; k < n; k++) {
            //     String[] tokens = scan.nextLine().split(",");
            InsertionSort data = new InsertionSort();
            while (scan.hasNext()) {
                int i = 1;
                String[] tokens = scan.nextLine().split(",");
                // System.out.println(Arrays.toString(tokens));
                data.add(new Stock(tokens[0], i));
                i++;
        }
        data.sort();
        data.display();

    }
}
class Stock implements Comparable<Stock> {
    /**
     * name variable.
     */
    private String name;
    /**
     * price variable.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      nm    for name.
     * @param      au    for author.
     * @param      pr    for price.
     */
    protected Stock(final String nm, final float pr) {
        this.name = nm;
        this.price = pr;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * to compare the books.
     *
     * @param      that  The that
     *
     * @return     1 if greater , -1 if lesser and 0 if equal.
     */
    public int compareTo(final Stock that) {
        if (this.getPrice() < that.getPrice()) {
            return 1;
        } else if (this.getPrice() > that.getPrice()) {
            return -1;
        }
        return 0;
    }
}
class InsertionSort {
    /**
     * to store the stocks.
     */
    private Stock[] stocks;
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
        this.stocks = new Stock[TEN];
        this.size = 0;
    }
    /**
     * to resize the array.
     * Time complexity is 1.
     */
    public void resize() {
        stocks = Arrays.copyOf(stocks, 2 * stocks.length);
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
    public void add(final Stock t) {
        if (size == stocks.length) {
            resize();
        }
        stocks[size++] = t;
    }
    /**
     * to sort the elements based on wins, losses, draws.
     * Time complexity is N * N.
     */
    public void sort() {
        for (int i = 1; i < size; i++) {
            Stock sto = stocks[i];
            int j = i - 1;
            int count = sto.compareTo(stocks[j]);
            while (j >= 0 && count == -1) {
                stocks[j + 1] = stocks[j];
                j--;
                if (j >= 0) {
                    count = sto.compareTo(stocks[j]);
                }
            }
            stocks[j + 1] = sto;
        }
    }
    public void display() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.println(stocks[i].getName() + " " + stocks[i].getPrice());
        }
        // System.out.println(stocks[i].getName());
    }
}












// import java.util.Scanner;
// import java.util.Arrays;
// import java.util.NoSuchElementException;
// public class Solution {
//     private Solution() {

//     }
//     // public static void main(final String[] args) {
//  //        Scanner scan = new Scanner(System.in);
//  //        int n = Integer.parseInt(scan.nextLine());

//  //        Stock[] stock = new Stock[n];
//  //        for (int k = 0; k < n; k++) {
//  //            String[] tokens = scan.nextLine().split(",");
//  //            stock[k] = new Stock(tokens[0], Float.parseFloat(tokens[1]));
//  //        }
//  //        MinPQ<Stock> pq = new MinPQ<Stock>();
//  //        for (int i = 0; i <= n; i++) {
//  //             pq.insert(new Stock(tokens));
//  //        }
//  //        // Insertion.sort(students);
//  //        // print(students);
//  //    }
    
//     //     public static void main(final String[] args) {
//     //     Scanner scan = new Scanner(System.in);
//     //     BinaryTreeST bt = new BinaryTreeST();
//     //     while (scan.hasNextLine()) {
//     //      String n = scan.nextLine();
//     //         String[] tokens = scan.nextLine().split(",");
//     //         switch (n) {
//     //             case "put":
//     //             Stock stock = new Stock(tokens[0], Float.parseFloat(tokens[1]));
//     //             bt.put(stock, Float.parseFloat(tokens[1]));
//     //             break;
//     //             case "get":
//     //             stock = new Stock(tokens[0], Float.parseFloat(tokens[1]));
//     //             System.out.println(bt.get(stock));
//     //             break;
//     //             default:
//     //             break;
//     //         }
//     //     }
//     // }
//         public static void main(final String[] args) {
//             Scanner scan = new Scanner(System.in);
//             int n = Integer.parseInt(scan.nextLine());
//             // Stock[] stock = new Stock[n];
//             for (int k = 0; k < n; k++) {
//                 String[] tokens = scan.nextLine().split(",");
//                 // stock[k] = new Stock(tokens[0], Float.parseFloat(tokens[1]));
//             }
//             MinPQ<Stock> pq = new MinPQ<Stock>();
//             for (int i = 0; i <= n; i++) {
//                  pq.insert(new Stock(tokens));
//             }
//             BinaryTreeST<String, Integer> binary =
//             new BinaryTreeST<String, Integer>();
//             String[] tokens = scan.nextLine().split(" ");
//             for (int i = 0; i < tokens.length; i++) {
//                 binary.put(tokens[i], i);
//             }
//             while (scan.hasNext()) {
//                 String[] check = scan.nextLine().split(" ");
//                 switch (check[0]) {
//                     case "max":
//                         System.out.println(binary.max());
//                         break;
//                     case "floor":
//                         System.out.println(binary.floor(check[1]));
//                         break;
//                     case "rank":
//                         System.out.println(binary.rank(check[1]));
//                         break;
//                     case "deleteMin":
//                         binary.deleteMin();
//                         break;
//                     case "contains":
//                         System.out.println(binary.contains(tokens[1]));
//                         break;
//                     case "keys":
//                         System.out.println(binary);
//                         break;
//                     case "get":
//                         System.out.println(binary.get(check[1]));
//                         break;
//                     default:
//                         break;
//                 }
//             }
//         }
//     }
// /**
//  * Class for binary search symbol table.
//  *
//  * @param      <Key>    The key.
//  * @param      <Value>  The value.
//  */
// class BinaryTreeST<Key extends Comparable<Key>, Value> {
//     /**
//      * { this is a capacity variable }.
//      */
//     private static final int INIT_CAPACITY = 2;
//     /**
//      * { this is a variable for keys }.
//      */
//     private Key[] keys;
//     /**
//      * {this is variable for values }.
//      */
//     private Value[] vals;
//     /**
//      * { this is a integer variable }.
//      */
//     private int n = 0;

//     /**
//      * Constructs the object.
//      */
//     BinaryTreeST() {
//         this(INIT_CAPACITY);
//     }

//     /**
//      * Constructs the object.
//      *
//      * @param      capacity  The capacity
//      */
//     BinaryTreeST(final int capacity) {
//         keys = (Key[]) new Comparable[capacity];
//         vals = (Value[]) new Object[capacity];
//     }
//     /**
//      * { function for resize }.
//      *
//      * @param      capacity  The capacity
//      */
//     private void resize(final int capacity) {
//         Key[]   tempk = (Key[])   new Comparable[capacity];
//         Value[] tempv = (Value[]) new Object[capacity];
//         for (int i = 0; i < n; i++) {
//             tempk[i] = keys[i];
//             tempv[i] = vals[i];
//         }
//         vals = tempv;
//         keys = tempk;
//     }
//     /**
//      * { size function }.
//      *
//      * @return     { returns the size }.
//      */
//     public int size() {
//         return n;
//     }
//     /**
//      * Determines if empty.
//      *
//      * @return     True if empty, False otherwise.
//      */
//     public boolean isEmpty() {
//         return size() == 0;
//     }
//     /**
//      * { contains functions }.
//      *
//      * @param      key   The key
//      *
//      * @return     { boolean value }.
//      */
//      public boolean contains(final Key key) {
//         if (key == null) {
//         throw new IllegalArgumentException("argument to contains() is null");
//             }
//         return get(key) != null;
//     }
//     /**
//      * { gets the value pair with key }.
//      *
//      * @param      key   The key
//      *
//      * @return     { key value pair is returned }.
//      */
//     public Value get(final Key key) {
//         if (key == null) {
//             throw new IllegalArgumentException("argument to get() is null");
//         }
//         if (isEmpty()) {
//             return null;
//         }
//         int i = rank(key);
//         if (i < n && keys[i].compareTo(key) == 0) {
//             return vals[i];
//         }
//         return null;
//     }
//     /**
//      * { rank function }.
//      *
//      * @param      key   The key
//      *
//      * @return     { rank is returned }.
//      */
//      public int rank(final Key key) {
//         if (key == null) {
//             throw new IllegalArgumentException("argument to rank() is null");
//         }

//         int lo = 0, hi = n - 1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             int cmp = key.compareTo(keys[mid]);
//             if (cmp < 0) {
//             hi = mid - 1;
//             } else if (cmp > 0) {
//                 lo = mid + 1;
//             } else {
//                 return mid;
//             }
//         }
//         return lo;
//     }
//     /**
//      * { function for put }.
//      *
//      * @param      key   The key
//      * @param      val   The value
//      */
//     public void put(final Key key, final Value val)  {
//         if (key == null) {
//             throw new IllegalArgumentException(
//             "first argument to put() is null");
//         }

//         if (val == null) {
//             delete(key);
//             return;
//         }

//         int i = rank(key);
//         if (i < n && keys[i].compareTo(key) == 0) {
//             vals[i] = val;
//             return;
//         }

//         if (n == keys.length) {
//             resize(2 * keys.length);
//         }

//         for (int j = n; j > i; j--)  {
//             keys[j] = keys[j - 1];
//             vals[j] = vals[j - 1];
//         }
//         keys[i] = key;
//         vals[i] = val;
//         n++;
//         assert check();
//     }
//     /**
//      * { delete function }.
//      *
//      * @param      key   The key
//      */
//     public void delete(final Key key) {
//         if (key == null) {
//             throw new IllegalArgumentException("argument to delete() is null");
//         }
//         if (isEmpty()) {
//             return;
//         }

//         // compute rank
//         int i = rank(key);

//         // key not in table
//         if (i == n || keys[i].compareTo(key) != 0) {
//             return;
//         }

//         for (int j = i; j < n - 1; j++)  {
//             keys[j] = keys[j + 1];
//             vals[j] = vals[j + 1];
//         }

//         n--;
//         keys[n] = null;  // to avoid loitering
//         vals[n] = null;

//         // resize if 1/4 full
//         if (n > 0 && n == keys.length / (2 + 2)) {
//             resize(keys.length / 2);
//         }
//         assert check();
//         }
//     /**
//     * { delete min function }.
//     */
//     public void deleteMin() {
//         if (isEmpty()) {
//             throw new NoSuchElementException("Symbol table underflow error");
//         }
//         delete(min());
//     }
//     /**
//      * { delete max function }.
//      */
//     public void deleteMax() {
//         if (isEmpty()) {
//             throw new NoSuchElementException("Symbol table underflow error");
//         }
//         delete(max());
//     }
//     /**
//      * { min function }.
//      *
//      * @return     { min is returned }.
//      */
//     public Key min() {
//         if (isEmpty()) {
//             throw new NoSuchElementException(
//                 "called min() with empty symbol table");
//         }
//         return keys[0];
//     }
//     /**
//      * { max function }.
//      *
//      * @return     { max returned }.
//      */
//     public Key max() {
//         if (isEmpty()) {
//             throw new NoSuchElementException(
//                 "called max() with empty symbol table");
//         }
//         return keys[n - 1];
//     }
//     /**
//      * { select function }.
//      *
//      * @param      k     {int k }.
//      *
//      * @return     { smallest key in this symbol table }.
//      */
//     public Key select(final int k) {
//         if (k < 0 || k >= size()) {
//             throw new IllegalArgumentException(
//                 "called select() with invalid argument: " + k);
//         }
//         return keys[k];
//     }
//     /**
//      * { floor function }.
//      *
//      * @param      key   The key
//      *
//      * @return     { largest key in this symbol table less than or equal to }.
//      */
//     public Key floor(final Key key) {
//         if (key == null) {
//             throw new IllegalArgumentException("argument to floor() is null");
//         }
//         int i = rank(key);
//         if (i < n && key.compareTo(keys[i]) == 0) {
//             return keys[i];
//         }
//         if (i == 0) {
//             return null;
//         } else {
//             return keys[i - 1];
//         }
//     }
//     /**
//      * { size function }.
//      *
//      * @param      lo    The lower
//      * @param      hi    The higher
//      *
//      * @return     { size is returned }.
//      */
//     public int size(final Key lo, final Key hi) {
//         if (lo == null) {
//             throw new IllegalArgumentException(
//                 "first argument to size() is null");
//         }
//         if (hi == null) {
//             throw new IllegalArgumentException(
//                 "second argument to size() is null");
//         }
//         if (lo.compareTo(hi) > 0) {
//             return 0;
//         }
//         if (contains(hi)) {
//             return rank(hi) - rank(lo) + 1;
//         } else {
//             return rank(hi) - rank(lo);
//         }
//     }
//     /**
//      * { check function }.
//      *
//      * @return     { boolean is returned }.
//      */
//     private boolean check() {
//         return isSorted() && rankCheck();
//     }
//     /**
//      * Determines if sorted.
//      *
//      * @return     True if sorted, False otherwise.
//      */
//     private boolean isSorted() {
//         for (int i = 1; i < size(); i++) {
//             if (keys[i].compareTo(keys[i - 1]) < 0)  {
//                 return false;
//             }
//         }
//         return true;
//     }
//     /**
//      * { check that rank }.
//      *
//      * @return     { boolean is returned }.
//      */
//     private boolean rankCheck() {
//         for (int i = 0; i < size(); i++) {
//             if (i != rank(select(i))) {
//                 return false;
//             }
//         }
//         for (int i = 0; i < size(); i++) {
//             if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     /**
//      * Returns a string representation of the object.
//      *
//      * @return     String representation of the object.
//      */
//     public String toString() {
//         String s = "";
//         int i = 0;
//         for (i = 0; i < size() - 1; i++) {
//             s += keys[i] + " " + vals[i] + "\n";
//         }
//         s += keys[i] + " " + vals[i];
//         return s;
//     }
// }
// class Stock implements Comparable<Stock> {
//     /**
//      * name variable.
//      */
//     private String name;
//     /**
//      * price variable.
//      */
//     private float price;
//     /**
//      * Constructs the object.
//      *
//      * @param      nm    for name.
//      * @param      au    for author.
//      * @param      pr    for price.
//      */
//     protected Stock(final String nm, final float pr) {
//         this.name = nm;
//         this.price = pr;
//     }
//     /**
//      * Gets the name.
//      *
//      * @return     The name.
//      */
//     public String getName() {
//         return this.name;
//     }
//     /**
//      * Gets the price.
//      *
//      * @return     The price.
//      */
//     public float getPrice() {
//         return this.price;
//     }
//     /**
//      * to compare the books.
//      *
//      * @param      that  The that
//      *
//      * @return     1 if greater , -1 if lesser and 0 if equal.
//      */
//     public int compareTo(final Stock that) {
//         return this.name.compareTo(that.name);
//     }
// }