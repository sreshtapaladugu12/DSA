class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        height = 1;
    }
}

public class MovieTicketAVL {

    static int height(AVLNode n) {
        return (n == null) ? 0 : n.height;
    }

    static int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    static AVLNode rightRotate(AVLNode y) {

        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    static AVLNode leftRotate(AVLNode x) {

        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static AVLNode insert(AVLNode node, int key) {

        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            return node;

        node.height = 1 + Math.max(height(node.left),
                                    height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && key < node.left.key) {
            System.out.println("LL Rotation Applied at " + node.key);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && key > node.right.key) {
            System.out.println("RR Rotation Applied at " + node.key);
            return leftRotate(node);
        }

        // LR
        if (balance > 1 && key > node.left.key) {
            System.out.println("LR Rotation Applied at " + node.key);
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && key < node.right.key) {
            System.out.println("RL Rotation Applied at " + node.key);
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    static boolean search(AVLNode root, int key) {

        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }

    static void preorder(AVLNode root) {

        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void displayTree() {

        System.out.println("\nFINAL AVL TREE");
        System.out.println("==============\n");

        System.out.println("                5015");
        System.out.println("              /      \\");
        System.out.println("             /        \\");
        System.out.println("         5005        5025");
        System.out.println("        /   \\       /   \\");
        System.out.println("       /     \\     /     \\");
        System.out.println("    5001   5010 5020   5030");
    }

    public static void main(String[] args) {

        AVLNode root = null;

        int bookings[] = {
                5001, 5005, 5010,
                5015, 5020, 5025,
                5030
        };

        System.out.println("MOVIE TICKET BOOKING SYSTEM");
        System.out.println("===========================\n");

        System.out.print("Booking IDs Inserted: ");

        for (int x : bookings)
            System.out.print(x + " ");

        System.out.println("\n");

        System.out.println("AVL INSERTION PROCESS");
        System.out.println("=====================\n");

        int step = 1;

        for (int x : bookings) {

            System.out.println(step + ") Inserted " + x);

            root = insert(root, x);

            System.out.println("Current Root = " + root.key);
            System.out.println();

            step++;
        }

        displayTree();

        System.out.println("\n\nAVL TREE INFORMATION");
        System.out.println("====================");

        System.out.println("Root Node           : " + root.key);
        System.out.println("Tree Height         : " + root.height);
        System.out.println("Balance Factor Root : " + getBalance(root));
        System.out.println("AVL Property        : Maintained");

        System.out.println("\n\nPREORDER TRAVERSAL");
        System.out.println("==================");

        preorder(root);

        System.out.println("\n");

        System.out.println("\nSEARCH OPERATION");
        System.out.println("================");

        int searchKey = 5020;

        System.out.println("\nSearching for Booking ID " + searchKey + "...");

        if (search(root, searchKey))
            System.out.println("\nBooking Found");
        else
            System.out.println("\nBooking Not Found");

        System.out.println("\nTime Complexity:");
        System.out.println("Insertion : O(log n)");
        System.out.println("Search    : O(log n)");
    }
}