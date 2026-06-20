class BookNode {

    int bookId;
    BookNode left, right;

    BookNode(int id) {
        bookId = id;
        left = right = null;
    }
}

public class LibraryBST {

    static BookNode insert(BookNode root, int id) {

        if (root == null)
            return new BookNode(id);

        if (id < root.bookId)
            root.left = insert(root.left, id);

        else if (id > root.bookId)
            root.right = insert(root.right, id);

        return root;
    }

    static boolean search(BookNode root, int id) {

        if (root == null)
            return false;

        if (root.bookId == id)
            return true;

        if (id < root.bookId)
            return search(root.left, id);

        return search(root.right, id);
    }

    static void inorder(BookNode root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.bookId + " ");
            inorder(root.right);
        }
    }

    static void displayTree() {

        System.out.println("\nBST STRUCTURE");
        System.out.println("=============\n");

        System.out.println("           105");
        System.out.println("         /     \\");
        System.out.println("       102     110");
        System.out.println("      /   \\    /  \\");
        System.out.println("    101 104 108 115");
    }

    public static void main(String[] args) {

        BookNode root = null;

        int books[] = {
                105, 102, 110,
                101, 104, 108, 115
        };

        System.out.println("LIBRARY BOOK MANAGEMENT SYSTEM");
        System.out.println("==============================\n");

        System.out.print("Book IDs Inserted : ");

        for (int x : books) {

            System.out.print(x + " ");
            root = insert(root, x);
        }

        displayTree();

        System.out.println("\n\nBOOKS IN SORTED ORDER");
        System.out.println("=====================");

        inorder(root);

        int searchId = 108;

        System.out.println("\n\nSEARCH OPERATION");
        System.out.println("================");

        System.out.println("Searching Book ID : "
                + searchId);

        if (search(root, searchId))
            System.out.println("Book Found");
        else
            System.out.println("Book Not Found");

        System.out.println("\nTIME COMPLEXITY");
        System.out.println("Insertion : O(log n)");
        System.out.println("Search    : O(log n)");
        System.out.println("Traversal : O(n)");
    }
}