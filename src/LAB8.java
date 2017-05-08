import java.util.Arrays;

interface PriorityQueue<T> {

    public void add(T value);

    public boolean isEmpty();

    public T peek();

    public T remove();
}


class BinaryHeap<T extends Comparable<T>> implements PriorityQueue<T> {
    private static final int DEFAULT_CAPACITY = 11;
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    BinaryHeap() {
        // Java doesn't allow construction of arrays of placeholder data types
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }


    public void add(T value) {
        // grow array if needed
        if (size > array.length - 1) {
            array = this.resize();
        }

        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;

        bubbleUp();
    }


    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return array[1];
    }


    /**
     * Removes and returns the minimum element in the heap.
     */
    public T remove() {
        // what do want return?
        T result = peek();

        // get rid of the last leaf/decrement
        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown();

        return result;
    }


    /**
     * Returns a String representation of BinaryHeap with values stored with
     * heap structure and order properties.
     */
    public String toString() {
        return Arrays.toString(array);
    }


    /**
     * Performs the "bubble down" operation to place the element that is at the
     * root of the heap in its correct place so that the heap maintains the
     * min-heap order property.
     */
    private void bubbleDown() {
        int index = 1;

        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);

            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index)
                    && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            }

            if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }

            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }
    }


    /**
     * Performs the "bubble up" operation to place a newly inserted element
     * (i.e. the element that is at the size index) in its correct place so
     * that the heap maintains the min-heap order property.
     */
    private void bubbleUp() {
        int index = this.size;

        while (hasParent(index)
                && (parent(index).compareTo(array[index]) > 0)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }


    private boolean hasParent(int i) {
        return i > 1;
    }


    private int leftIndex(int i) {
        return i * 2;
    }


    private int rightIndex(int i) {
        return i * 2 + 1;
    }


    private boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }


    private boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }


    private T parent(int i) {
        return array[parentIndex(i)];
    }


    private int parentIndex(int i) {
        return i / 2;
    }


    private T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }


    private void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}

class LAB8 {
    public static void main(String args[]) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();

        System.out.println(heap);

        heap.add(10);
        heap.add(12);
        heap.add(1);
        heap.add(14);
        heap.add(6);
        heap.add(5);
        heap.add(8);
        heap.add(15);
        heap.add(3);
        heap.add(9);

        System.out.println("Heap: ");
        System.out.println(heap);
        System.out.println();

        System.out.println("Removed Smallest One: 1");
        heap.remove();
        System.out.println(heap);
        System.out.println();


        System.out.println("Removed Smallest One: 3");
        heap.remove();
        System.out.println(heap);
        System.out.println();


        System.out.println("Removed Smallest One: 5");
        heap.remove();
        System.out.println(heap);
    }
}