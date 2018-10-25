import java.util.Scanner;
/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SequentialSearchST<Key, Value> {
	/**
	 * n variable.
	 */
	private int n;
	/**
	 * first node variable.
	 */
	private Node first;
	/**
	 * Class Node.
	 */
	private class Node {
	/**
	 * key variable.
	 */
	private Key key;
	/**
	 * val variable.
	 */
	private Value val;
	/**
	 * next variable.
	 */
	private Node next;
	/**
	 * Constructs the object.
	 *
	 * @param      key1   The key 1
	 * @param      vall   The vall
	 * @param      nextt  The nextt
	 */
   Node(final Key key1, final Value vall, final Node nextt)  {
            this.key  = key1;
            this.val  = vall;
            this.next = nextt;
        }
    }
    /**
     * Constructs the object.
     */
   	SequentialSearchST() {
        //empty constructor.
    }
    /**
     * size function.
     *
     * @return     size.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * contains function.
     *
     * @param      key   The key
     *
     * @return     true or false based on key found.
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * get function.
     *
     * @param      key   The key
     *
     * @return     the key value.
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }
    /**
     * put function.
     *
     * @param      key   The key
     * @param      val   The value
     */
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
	/**
	 * delete function.
	 *
	 * @param      key   The key
	 */
	public void delete(final Key key) {
        first = delete(first, key);
    }
	/**
	 * delete function.
	 *
	 * @param      x     { parameter_description }
	 * @param      key   The key
	 *
	 * @return     node value.
	 */
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
    /**
     * Iterable function.
     *
     * @return     key.
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}
/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
	/**
	 * for capacity.
	 */
    private static final int INIT_CAPACITY = 4;
    /**
     * n varaible.
     */
    private int n;
    /**
     * m varible.
     */
    private int m;
    /**
     * sequential search.
     */
    private SequentialSearchST<Key, Value>[] st;
    /**
     * Constructs the object.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Constructs the object.
     *
     * @param      m1    The m 1
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    /**
     * resize function.
     *
     * @param      chains  The chains
     */
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

    /**
     * hash function.
     *
     * @param      key   The key
     *
     * @return     hash value.
     */
    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 
    /**
     * size function.
     *
     * @return     size.
     */
    public int size() {
        return n;
    } 
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * contains function.
     *
     * @param      key   The key
     *
     * @return     true or false based on value found.
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
            "argument to contains() is null");
        }
        return get(key) != null;
    } 
    /**
     * get function.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        int i = hash(key);
        return st[i].get(key);
    } 
    /**
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     */
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
    /**
     * { function_description }
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) throw new IllegalArgumentException(
            "argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
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
	/**
	 * Constructs the object.
	 */
    private Solution() {
        //empty constructor.
    }
    /**
     * client function.
     *
     * @param      args  The arguments
     */
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
