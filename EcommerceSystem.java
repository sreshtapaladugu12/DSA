public class EcommerceSystem {

    // ---------------- HEAP SORT ----------------

    static void heapify(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void heapSort(int arr[]) {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // ---------------- COUNTING SORT ----------------

    static void countingSort(int arr[]) {

        int max = arr[0];

        for (int x : arr)
            if (x > max)
                max = x;

        int count[] = new int[max + 1];

        for (int x : arr)
            count[x]++;

        int index = 0;

        for (int i = 0; i <= max; i++) {

            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // ---------------- RADIX SORT ----------------

    static int getMax(int arr[]) {

        int max = arr[0];

        for (int x : arr)
            if (x > max)
                max = x;

        return max;
    }

    static void countSort(int arr[], int exp) {

        int n = arr.length;

        int output[] = new int[n];
        int count[] = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {

            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixSort(int arr[]) {

        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    // ---------------- KNAPSACK ----------------

    static int knapsack(int W, int wt[], int val[], int n) {

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0)
                    dp[i][w] = 0;

                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);

                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W];
    }

    // ---------------- LCS ----------------

    static int lcs(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    // ---------------- MATRIX CHAIN ----------------

    static int matrixChain(int p[]) {

        int n = p.length;

        int dp[][] = new int[n][n];

        for (int len = 2; len < n; len++) {

            for (int i = 1; i < n - len + 1; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                            + dp[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }

        return dp[1][n - 1];
    }

    static void display(int arr[]) {

        for (int x : arr)
            System.out.print(x + " ");
    }

    public static void main(String[] args) {

        System.out.println("E-COMMERCE ORDER PROCESSING SYSTEM");
        System.out.println("=================================\n");

        // Heap Sort
        int orderPrices[] = {4500, 1200, 8900, 2300, 700};

        System.out.println("ORDER PRICES BEFORE SORTING");
        display(orderPrices);

        heapSort(orderPrices);

        System.out.println("\nORDER PRICES AFTER HEAP SORT");
        display(orderPrices);

        // Counting Sort
        int priorities[] = {3,1,2,2,1,3,1};

        countingSort(priorities);

        System.out.println("\n\nORDER PRIORITIES AFTER COUNTING SORT");
        display(priorities);

        // Radix Sort
        int orderIds[] = {5012,5001,5034,5020,5005};

        radixSort(orderIds);

        System.out.println("\n\nORDER IDS AFTER RADIX SORT");
        display(orderIds);

        // Knapsack
        int profit[] = {60,100,120};
        int weight[] = {10,20,30};

        System.out.println("\n\nTRUCK LOADING USING KNAPSACK");
        System.out.println("Maximum Profit = "
                + knapsack(50, weight, profit, profit.length));

        // LCS
        System.out.println("\nCUSTOMER SEARCH ANALYSIS");
        System.out.println("LCS Length = "
                + lcs("MOBILESHOP", "MOBILESALE"));

        // Matrix Chain
        int matrices[] = {10,20,30,40,30};

        System.out.println("\nREPORT OPTIMIZATION");
        System.out.println("Minimum Cost = "
                + matrixChain(matrices));

        System.out.println("\n\nCOMPLEXITIES");
        System.out.println("Heap Sort      : O(n log n)");
        System.out.println("Counting Sort  : O(n+k)");
        System.out.println("Radix Sort     : O(d(n+k))");
        System.out.println("Knapsack       : O(nW)");
        System.out.println("LCS            : O(m*n)");
        System.out.println("Matrix Chain   : O(n^3)");
    }
}