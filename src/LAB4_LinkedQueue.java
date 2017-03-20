/**
 * Created by daimon on 20/03/2017.
 */

import java.util.NoSuchElementException;

public class LAB4_LinkedQueue implements LAB4_Queue {

    class Node {
        Object data;
        Node next;

        Node(Object item) {
            data = item;
        }
    }

    Node front, rear;
    int count;

    @Override
    public void enqueue(Object o) {
        Node nptr = new Node(o);
        if (isEmpty()){
            nptr.next = front;
            front = nptr;
            rear = nptr;
        } else {
            rear.next = nptr;
            rear = nptr;
            rear.next = null;
        }
        count++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        Node ptr = front;
        front = ptr.next;
        if (front == null)
            rear = null;
        count--;
        return ptr.data;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void display() {
        if (count == 0)
        {
            return ;
        }
        Node ptr = front;
        while (ptr != null )
        {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }

    }
}