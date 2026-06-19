public class CargoLoadingKnapsack {

    public static void main(String[] args) {

        int[] weights = {4, 6, 3, 7, 5, 2};   // A, B, C, D, E, F
        int[] profits = {35, 45, 25, 50, 40, 20};

        char[] orders = {'A', 'B', 'C', 'D', 'E', 'F'};

        int capacity = 20;
        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {

                if (weights[i - 1] <= w) {

                    int include =
                            profits[i - 1]
                            + dp[i - 1][w - weights[i - 1]];

                    int exclude =
                            dp[i - 1][w];

                    if (include > exclude)
                        dp[i][w] = include;
                    else
                        dp[i][w] = exclude;

                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("==================================");
        System.out.println(" 0/1 KNAPSACK OPTIMAL SOLUTION");
        System.out.println("==================================");

        System.out.println("\nVan Capacity : " + capacity + " kg");
        System.out.println("Maximum Profit : ₹" + dp[n][capacity] + "k");

        System.out.println("\nSelected Orders:\n");

        int w = capacity;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                System.out.println(
                        orders[i - 1]
                        + " (Weight=" + weights[i - 1]
                        + ", Profit=₹" + profits[i - 1] + "k)");

                w = w - weights[i - 1];
            }
        }
    }
}