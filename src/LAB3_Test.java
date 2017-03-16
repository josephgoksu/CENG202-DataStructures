/**
 * Created by daimon on 13/03/2017.
 */
public class LAB3_Test {
    public static void main(String args[]){
        LAB3<Integer> myNode = new LAB3<Integer>();

        myNode.add(4);

        myNode.add(7);

        myNode.add(10);

        myNode.addFirst(5);

        myNode.removeFirst(5);

        System.out.print(myNode);

        System.out.println(myNode.getLast());
    }
}
