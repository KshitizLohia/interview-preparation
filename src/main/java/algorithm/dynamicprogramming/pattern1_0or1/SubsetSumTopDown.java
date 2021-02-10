package algorithm.dynamicprogramming.pattern1_0or1;

/**
 * Find a subset whose sum is equal to S
 *
 * a[i, s] = a[i-1, s],a[i,s-a[i]]
 */
public class SubsetSumTopDown {


    public static boolean subsetBoolean(int[] a, int sum, int index, Boolean dp[][]) {
        // base conditions
        if (sum == 0) return true;
        if (index >= a.length) return false;
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        if (a[index] <= sum) {
            dp[index][sum] = subsetBoolean(a, sum-a[index], index+1, dp);
            return dp[index][sum];
        }
        dp[index][sum] = subsetBoolean(a, sum, index+1, dp);
        return dp[index][sum];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int sum = 3;
        Boolean[][] dp = new Boolean[a.length][sum];
        subsetBoolean(a, sum, 0, dp);
    }
}
