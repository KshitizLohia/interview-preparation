package algorithm.dynamicprogramming.pattern2_unboundnedknapsack;

public class UnboundedKnapsackBottomUp {

    public static int solveKnapsackBottomup(int[] weights, int[] profits, int capacity) {
        // base conditions
        if (capacity <= 0) return 0;
        int[][] dp = new int[weights.length][capacity+1];

        // if capacity is 0 profit is 0
        for (int i=0; i< weights.length; i++) {
            dp[i][0] = 0;
        }

        // if index is 0, profit is
        for (int c=0;c<=capacity;c++) {
            if (c >= weights[0]) {
                dp[0][c] = profits[0];
            }
        }

        for(int i=1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                }
                profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        return dp[weights.length-1][capacity];

    }

    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] profits = {15, 20, 50};
        int capacity = 3;
        System.out.println(solveKnapsackBottomup(weights, profits, capacity));
    }
}
