package algorithm.dynamicprogramming.pattern1;


/**
 * Given weights and profit of n Items, we are asked to put items in knapsack that has capacity C
 * Goal: To maximise the profit from m items
 * <p>
 * Example: [Apple, Orange, Banana, Melon]
 * Weights: [2, 3, 1, 4]
 * Profits: [4, 5, 3, 7]
 * Knapsack capacity
 * <p>
 * Ans: Banana + Melon
 */
public class Knapsack {

    /**
     * for each item i:
     * create a set which includes i and recursive process items
     * create a set which does not include i and recursive process items
     * return from the two set with the higher profit
     *
     * @param weights  weights
     * @param profits  profits
     * @param capacity capacity n
     * @return profit
     */
    public static int solveKnapsackRecursive(int[] weights, int[] profits, int capacity) {
        return knapsackRecursive(weights, profits, capacity, 0);
    }

    private static int knapsackRecursive(int[] weights, int[] profits, int capacity, int currentIndex) {
        // base condition
        if (capacity <= 0 || currentIndex >= profits.length) return 0;
        // recursive condition

        // add item to list
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] +
                    knapsackRecursive(
                            weights,
                            profits,
                            capacity - weights[currentIndex],
                            currentIndex + 1);
        }


        // don't add item to list
        int profit2 = knapsackRecursive(
                weights,
                profits,
                capacity,
                currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static int solveKnapsackWithMemoization(int[] weights, int[] profits, int capacity) {
        int memorize[][] = new int[profits.length][capacity+1];
        return knapsackWithMemoization(weights, profits, capacity, 0, memorize);
    }

    private static int knapsackWithMemoization(int[] weights, int[] profits, int capacity, int index, int[][] memoize) {
        // base case
        if (capacity <= 0 || index >= profits.length) return 0;
        int profit1 = 0;
        if (memoize[index][capacity] != 0) return memoize[index][capacity];
        if (capacity >= weights[index]) {
            profit1 = profits[index] +
                    knapsackWithMemoization(weights, profits, capacity-weights[index], index+1, memoize);
        }
        int profit2 = knapsackWithMemoization(weights, profits, capacity, index+1, memoize);
        memoize[index][capacity] = Math.max(profit1, profit2);
        return memoize[index][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(solveKnapsackRecursive(weights, profits, 7));
        System.out.println(solveKnapsackRecursive(weights, profits, 6));
        System.out.println(solveKnapsackWithMemoization(weights, profits, 6));
        System.out.println(solveKnapsackWithMemoization(weights, profits, 6));
    }
}
