/**
 * Created by daimon on 13/03/2017.
 */

import org.omg.CORBA.INTERNAL;

import java.util.TreeMap;

/**
 * LinkedList class implements a doubly-linked list.
 */
public class LAB3<Type> implements Iterable<Type> {
    /**
     * This is the doubly-linked list node.
     */
    private static class Node<Type> {
        public Node(Type d, Node<Type> p, Node<Type> n) {
            data = d;
            prev = p;
            next = n;
        }

        public Type data;
        public Node<Type> prev;
        public Node<Type> next;
    }

    private int theSize;
    private Node<Type> first;
    private Node<Type> last;

    public LAB3() {
        clear();
    }

    public void clear() {
        first = new Node<Type>(null, null, null);
        last = new Node<Type>(null, first, null);
        first.next = last;
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds an item to this collection, at the end.
     *
     * @param x any object.
     * @return true.
     */
    public boolean add(Type x) {
        add(size(), x);
        return true;
    }

    public void addFirst(Type item)
    {
        // Node<Integer> newNode = new Node<>(item, null, get(0));

        // addBefore(getNode(0), item);

        add(0, item);
    }

    public void removeFirst(Type item)
    {
        remove(0);
    }

    public Integer getLast()
    {
        return (Integer) getNode(size() - 1).data;
    }

    /**
     * Adds an item to this collection, at specified position.
     * Items at or after that position are slid one position higher.
     *
     * @param x   any object.
     * @param idx position to add at.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */
    public void add(int idx, Type x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     *
     * @param p Node to add before.
     * @param x any object.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */
    private void addBefore(Node<Type> p, Type x) {
        Node<Type> newNode = new Node<Type>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
    }

    public Type get(int idx) {
        return getNode(idx).data;
    }

    public Type set(int idx, Type newVal) {
        Node<Type> p = getNode(idx);
        Type oldVal = p.data;

        p.data = newVal;
        return oldVal;
    }

    public boolean contain(Type key){
        Node<Type> tmp = first;
        while (tmp != null){
            if (tmp.data == key)
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * Gets the Node at position idx, which must range from 0 to size( ) - 1.
     *
     * @param idx index to search at.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size( ) - 1, inclusive.
     */
    private Node<Type> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper.
     *
     * @param idx   index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corrsponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between lower and upper, inclusive.
     */
    private Node<Type> getNode(int idx, int lower, int upper) {
        Node<Type> p;

        if (idx < lower || idx > upper)
            throw new IndexOutOfBoundsException("getNode index: " + idx + "; size: " + size());

        if (idx < size() / 2) {
            p = first.next;
            for (int i = 0; i < idx; i++)
                p = p.next;
        } else {
            p = last;
            for (int i = size(); i > idx; i--)
                p = p.prev;
        }

        return p;
    }

    public Type remove(int idx) {
        return remove(getNode(idx));
    }

    private Type remove(Node<Type> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;

        return p.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        for (Type x : this)
            sb.append(x + " ");
        sb.append("]");

        return new String(sb);
    }

    /**
     * Obtains an Iterator object used to traverse the collection.
     *
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<Type> iterator() {
        return new LinkedListIterator();
    }

    /**
     * This is the implementation of the LinkedListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyLinkedList.
     */
    private class LinkedListIterator implements java.util.Iterator<Type> {
        private Node<Type> current = first.next;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != last;
        }

        public Type next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            Type nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (!okToRemove)
                throw new IllegalStateException();

            LAB3.this.remove(current.prev);
            okToRemove = false;
        }
    }

}
