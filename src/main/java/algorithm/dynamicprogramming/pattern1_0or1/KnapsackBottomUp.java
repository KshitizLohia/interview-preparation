package algorithm.dynamicprogramming.pattern1_0or1;

public class KnapsackBottomUp {

    /**
     * * Bottom up:
     * * dp[i, c] = max(profit[i] + dp[i-1, c-w[i]], dp[i-1, c])
     */
    public static int knapsackBottomUp(int[] weights, int[] profits, int capacity) {
        int[][] profitsBestFit = new int[profits.length][capacity + 1];

        // if we have 0 capacity we have 0 profits
        for (int i = 0; i < profits.length; i++) {
            profitsBestFit[i][0] = 0;
        }
        // if we have 0 index, we have profit as  the price of item if weight of item is less than capacity
        for (int c = 0; c < capacity; c++) {
            if (weights[0] < capacity) {
                profitsBestFit[0][c] = profits[0];
            }
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 =0,profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + profitsBestFit[i - 1][capacity - weights[i]];
                }
                profit2 = profitsBestFit[i - 1][capacity];
                profitsBestFit[i][c] = Math.max(profit1, profit2);
            }
        }

        return profitsBestFit[profits.length - 1][capacity];
    }

    /**
     * Algorithm:
     *
     * Came from top element: find an element in same row such that profitsBestFit[i][c]-profit[i] == element
     * Didn't come from top element: row--
     *
     * @param profitsBestFit
     * @param weights
     * @param profits
     */
    private void printSelectedItem(int[][] profitsBestFit, int[] weights, int[] profits, int capacity) {
        int totalProfit = profitsBestFit[weights.length-1][capacity];
        for (int i=weights.length-1;i>=0;i--) {
            if (totalProfit != profitsBestFit[i-1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity = capacity - weights[i];
                totalProfit = totalProfit - profits[i];
            }
        }
        if(totalProfit != 0)
            System.out.print(" " + weights[0]);
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(knapsackBottomUp(weights, profits, 7));
    }
}
