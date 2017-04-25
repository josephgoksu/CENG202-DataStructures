import java.util.*;

/**
 * Created by daimon on 27/03/2017.
 */
public class LAB5_Binary_Tree
{
    public Node root;

    // public Stack<Integer> stack;

    public LAB5_Binary_Tree(int data)
    {
        root = new Node(data);
    }

    public void add(Node parent, Node child, String orientation)
    {
        if (orientation.equals("left"))
        {
            parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }
    }

    void inorder(Node t){
        if (t != null){
            inorder(t.getLeft());
            System.out.print(t.getKey());
            System.out.print(" ");
            inorder(t.getRight());
        }
    }

    void iterative(Node t){
        if (t != null){
            Stack<Integer> stack = new Stack<Integer>();

            while (root != null){

                stack.push(root.getKey());
                root = root.getLeft();
//                while (root.getLeft() != null){
//                    Integer a = stack.pop();
//                    root.getKey() = a;
//                }
            }

            System.out.print(stack);

        }
    }

}

class Node {
    public int key;
    public Node left;
    public Node right;

    Node (int key) {
        this.key = key;
        right = null;
        left = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right ) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }


}