/**
 * Created by daimon on 03/04/2017.
 */

public class LAB6 {
    public Node root;
    public Integer counter = 0;

    public int allElemNode(Node node) {

        if (root != null) {
            allElemNode(root.getLeft());
            allElemNode(root.getRight());
        }
        return 0;
    }

    public int countLeafNode(Node node) {

        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            counter = counter + 1;
            return 1;
        } else {
            countLeafNode(node.getRight());
            countLeafNode(node.getLeft());
        }
        return 0;
    }

    public void insert(int key) {
        Node node = new Node(key);

        if (root == null) {
            root = node;
            return;
        }

        insertRec(root, node);

    }

    private void insertRec(Node latestRoot, Node node) {

        if (latestRoot.key > node.key) {

            if (latestRoot.left == null) {
                latestRoot.left = node;
            } else {
                insertRec(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }

    /**
     * Printing the contents of the tree in an inorder way.
     */
    public void printInorder() {
        printInOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in an inorder way
     */
    private void printInOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.key + ", ");
        printInOrderRec(currRoot.right);
    }

    public static void main(String args[]) {

        LAB6 obje = new LAB6();

        int[] array = new int[]{45, 25, 15, 10, 20, 30, 65, 55, 50, 60, 75, 80};

        System.out.print("Array eleman sayisi: ");
        System.out.println(array.length);


        for (int i = 0; i <= 11; i++) {
            obje.insert(array[i]);
        }

        System.out.println("BSTnode first node");
        System.out.println(obje.root.getKey());

        System.out.println("Print Inorder: ");
        obje.printInorder();

        obje.countLeafNode(obje.root);
        System.out.println("Number Of Leaf Nodes: ");
        System.out.println(obje.counter);


        System.out.println("Yeni node olusturuluyor...");
        obje.insert(obje.root.getKey());


    }
}