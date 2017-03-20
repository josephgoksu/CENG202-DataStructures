/**
 * Created by daimon on 20/03/2017.
 */

public class LAB4_LinkedQueueDemo {

    public static void main(String[] args) {

        LAB4_LinkedQueue q = new LAB4_LinkedQueue();

        q.display();
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        q.display();

        System.out.println("dequeue(): " + q.dequeue());
        q.display();

        System.out.println("peek(): " + q.peek());

        q.enqueue('E');
        q.enqueue('F');

        System.out.println("dequeue(): " + q.dequeue());
        q.display();

        System.out.println("size(): " + q.size());

    }

}

