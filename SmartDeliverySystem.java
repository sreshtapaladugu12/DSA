class TreeNode {

    int locationId;
    TreeNode left, right;

    TreeNode(int id) {
        locationId = id;
        left = right = null;
    }
}

public class SmartDeliverySystem {

    // BST INSERTION

    static TreeNode insert(TreeNode root, int id) {

        if (root == null)
            return new TreeNode(id);

        if (id < root.locationId)
            root.left = insert(root.left, id);
        else
            root.right = insert(root.right, id);

        return root;
    }

    static void inorder(TreeNode root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.locationId + " ");
            inorder(root.right);
        }
    }

    // DYNAMIC PROGRAMMING - KNAPSACK

    static int knapsack(int capacity, int wt[],
                        int profit[], int n) {

        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                if (i == 0 || w == 0)
                    dp[i][w] = 0;

                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(
                            profit[i - 1]
                                    + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);

                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][capacity];
    }

    // GREEDY - ACTIVITY SELECTION

    static void activitySelection(int start[],
                                  int finish[], int n) {

        System.out.println("\nSelected Delivery Slots:");

        int i = 0;

        System.out.println("Slot 1");

        for (int j = 1; j < n; j++) {

            if (start[j] >= finish[i]) {

                System.out.println("Slot " + (j + 1));
                i = j;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("SMART DELIVERY MANAGEMENT SYSTEM");
        System.out.println("================================\n");

        // NON-LINEAR DATA STRUCTURE

        TreeNode root = null;

        int locations[] = {
                105, 102, 110,
                101, 104, 108, 115
        };

        System.out.println("DELIVERY LOCATIONS INSERTED");

        for (int x : locations) {

            System.out.print(x + " ");
            root = insert(root, x);
        }

        System.out.println("\n");

        System.out.println("BST TRAVERSAL");
        System.out.println("=============");

        inorder(root);

        // DYNAMIC PROGRAMMING

        int profits[] = {60, 100, 120};
        int weights[] = {10, 20, 30};
        int capacity = 50;

        System.out.println("\n\nPACKAGE OPTIMIZATION");
        System.out.println("====================");

        int maxProfit = knapsack(
                capacity,
                weights,
                profits,
                profits.length);

        System.out.println("Vehicle Capacity : "
                + capacity);

        System.out.println("Maximum Profit   : "
                + maxProfit);

        // GREEDY

        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};

        System.out.println("\nDELIVERY SCHEDULING");
        System.out.println("===================");

        activitySelection(
                start,
                finish,
                start.length);

        // EVALUATION

        System.out.println("\n\nSYSTEM EVALUATION");
        System.out.println("=================");

        System.out.println("BST Search/Insert : O(log n)");
        System.out.println("Knapsack DP       : O(nW)");
        System.out.println("Greedy Selection  : O(n)");

        System.out.println("\nAdvantages:");
        System.out.println("- Fast location management");
        System.out.println("- Maximum delivery profit");
        System.out.println("- Efficient scheduling");
    }
}