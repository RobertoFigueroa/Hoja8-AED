import java.util.Vector;

/**
 * @param <E> This class is a vector that implements the priorityQueue
 */
public  class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> data; // the data, kept in heap order
    private int size;

    /**
     * The VectorHeap constructor
     */
    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     * @param i Receives an integer
     * @return Returns the integer minus 1 and divided by 2, wich is the parent
     */
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i - 1) / 2;
    }

    /**
     * @param i Receives an integer
     * @return Returns the integer times 2 and plus 1, wich is the left
     */
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2 * i + 1;
    }

    /**
     * @param i Receives an integer
     * @return Returns the integer times 2 and plus 2, wich is the right
     */
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return 2 * i + 2;
    }

    /**
     * @param leaf this method searches the important nodes and make them the root
     */
    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }


    /**
     * @param value Receives a type E value
     *Takes de value and ads it to the vector
     */
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size() - 1);
        size ++;
    }

    /**
     * @param root Takes the root from the vectorheap
     * Moves the root node down to make it a subtree
     */
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos + 1)).compareTo
                                (data.get(childpos)) < 0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root, value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * @return Returns the minimum value
     * takes the minimum value and returns it
     */
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    @Override
    public E getFirst() {
        return data.firstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {

    }
}