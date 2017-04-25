package homework_1;


public class MyDeque<T> implements Queue {
    Node head;
    Node tail;
    int count;

    class Node {
        Object data;
        Node next, pre;

        Node(Object item) {
            this.data = item;
        }
    }

    public void push(Object o) {
        Node newNode = new Node(o);
        if (tail != null && head != null) {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        count++;
    }

    public Object pop() {
        Object t = head.data;
        if (isEmpty()) {
            System.out.println("Q is empty");
        } else {
            head = head.next;
            --count;
            head.pre = null;
        }
        return t;

    }

    public Object eject() {
        Object t = null;
        if (tail != null) {
            t = tail.data;
            tail = tail.pre;
            --count;
        }
        if (isEmpty()) {
            System.out.println("Q is empty");
        }

        return t;
    }


    public void inject(Object o) {
        Node newNode = new Node(o);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (tail != null) {
            tail.next = newNode;
            newNode.pre = tail;
        }
        tail = newNode;
        newNode.next = null;
        count++;
    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean a() {
        Node n = head;
        System.out.print("printing the list: ");
        System.out.print("Head: ");
        while (n != null) {
            System.out.print(n.data);
            System.out.print(", ");
            n = n.next;
        }
        System.out.println(" :Tail");
        return true;
    }

    public int size() {
        return this.count;
    }
}