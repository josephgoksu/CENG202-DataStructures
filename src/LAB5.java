/**
 * Created by daimon on 27/03/2017.
 */
public class LAB5 {

    public static void main(String args[]) {
        // Node root = new Node(40);
        Node n10 = new Node(10);
        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n50 = new Node(50);
        Node n60 = new Node(60);
        Node n70 = new Node(70);

        LAB5_Binary_Tree tree = new LAB5_Binary_Tree(40);

        // LEFT PART
        tree.add(tree.root, n20, "left");
        tree.add(n20, n10, "left");
        tree.add(n20, n30, "right");

        // Right PART
        tree.add(tree.root, n60, "right");
        tree.add(n60, n50, "left");
        tree.add(n60, n70, "right");

        System.out.println("Binary Tree with inorder");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("Binary Tree with iterative");
        tree.iterative(tree.root);
    }

}