import java.util.Scanner;
class SequentialSearchST<Key, Value> {
   private int n;
   private Node first;
   private class Node {
   private Key key;
   private Value val;
   private Node next;
   Node(final Key key1, final Value vall, final Node nextt)  {
            this.key  = key1;
            this.val  = vall;
            this.next = nextt;
        }
    }
   SequentialSearchST() {
        //empty constructor.
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
	public void delete(final Key key) {
        first = delete(first, key);
    }
	private Node delete(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}
class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 
    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(final int chains) {
        SeparateChainingHashST<Key, Value> temp = new
        SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 
    public int size() {
        return n;
    } 
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
            "argument to contains() is null");
        }
        return get(key) != null;
    } 
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        int i = hash(key);
        return st[i].get(key);
    } 
    public void put(final Key key, final Value val) {
        if (key == null) throw new IllegalArgumentException(
            "first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 
    public void delete(final Key key) {
        if (key == null) throw new IllegalArgumentException(
            "argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}
public class Solution {
    private Solution() {
        //empty constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> hash = new
                    SeparateChainingHashST<String, Integer>();
        String integer = scan.nextLine();
        String[] array = scan.nextLine().split(" ");
        for(int i = 0; i < array.length; i++) {
            if (hash.contains(array[i])) {
                hash.put(array[i], hash.get(array[i]) + 1); 
            } else {
                hash.put(array[i], 1);
            }
        }

        String[] strarray = scan.nextLine().split(" ");
        for (int i = 0; i < strarray.length; i++) {
            if (hash.contains(strarray[i]) ) {
                if(hash.get(strarray[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    hash.put(strarray[i], hash.get(strarray[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
