package algorithm.dynamicprogramming.pattern2_unboundnedknapsack;

/**
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack
 * which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack.
 * The only difference between the 0/1 Knapsack problem and this problem is that we are allowed
 * to use an unlimited quantity of an item.
 *
 * Items: { Apple, Orange, Melon }
 * Weights: { 1, 2, 3 }
 * Profits: { 15, 20, 50 }
 * Knapsack capacity: 5
 *
 * Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.
 *
 * 5 Apples (total weight 5) => 75 profit
 * 1 Apple + 2 Oranges (total weight 5) => 55 profit
 * 2 Apples + 1 Melon (total weight 5) => 80 profit
 * 1 Orange + 1 Melon (total weight 5) => 70 profit
 *
 * This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit
 * and the total weight does not exceed the capacity.
 *
 */
public class UnboundedKnapsackTopDown {

    public static int knapsackRecursive(final int[] weights, final int[] profits, final int capacity,
                                        final int[][] dp, final int index) {
        // base condition
        if (index >= profits.length || capacity <= 0) return 0;

        // recursive conditions
        if (dp[index][capacity] != 0) {
            return dp[index][capacity];
        }

        // include index
        int profit1 = 0;
        if (capacity >= weights[index]) {
            profit1 = profits[index] + knapsackRecursive(weights, profits, capacity - weights[index],
                    dp, index);
        }

        // not include index
        int profit2 = knapsackRecursive(weights, profits, capacity, dp, index+1);

        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];

    }

    public static int solveKnapsack(final int[] weights, final int[] profits, final int capacity) {
        int[][] dp = new int[profits.length][capacity+1];
        return knapsackRecursive(weights, profits, capacity, dp, 0);
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] profits = {15, 20, 50};
        int capacity = 3;
        System.out.println(solveKnapsack(weights, profits, capacity));
    }
}
