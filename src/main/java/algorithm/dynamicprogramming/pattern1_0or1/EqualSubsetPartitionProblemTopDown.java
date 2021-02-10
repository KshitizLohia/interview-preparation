package algorithm.dynamicprogramming.pattern1_0or1;

/**
 * Given a set of positive numbers, find whether we can partition it into 2 subsets
 * i/p: {1, 2, 3, 4}
 * o/p: true
 *
 * a(n),b(n) = a(n-1)==b(n) | a(n)==b(n-1)
 */
public class EqualSubsetPartitionProblemTopDown {

    /**
     * Complexity: O(pow(2,n)) Space: O(n)
     *
     * @param a number
     * @param index index
     * @param sum sum of numbers
     * @return true or false whether we can partition of nor
     */
    public static boolean canSolveSubsetProblemRecursion(int[] a, int index, int sum) {
        if (sum == 0) return true;
        if (index >= a.length) return false;

        // include index in A bucket
        if (a[index] <= sum) {
            if (canSolveSubsetProblemRecursion(a, index+1, sum-a[index])) {
                return true;
            }
        }
        return canSolveSubsetProblemRecursion(a, index+1, sum);

    }

    public static boolean canPartitionSubsetProblemRecursion(int[] a) {
        int sum = 0;
        for (int i=0;i<a.length;i++) {
            sum += a[i];
        }
        if (sum % 2 !=0 ) return false;
        return canSolveSubsetProblemRecursion(a, 0, sum/2);
    }

    public static boolean canPartitionSubsetMemoization(Boolean[][] dp, int[] a, int index, int sum) {
        // base checks
        if (sum == 0) return true;
        if (index >= a.length || index == 0) return false;
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }
        // include a[i]
        if (sum >= a[index]) {
            Boolean check =  canPartitionSubsetMemoization(dp, a, index+1, sum - a[index]);
            if (check) {
                dp[index][sum] = true;
                return true;
            }
        }
        // don't include a[i]
        dp[index][sum] = canPartitionSubsetMemoization(dp, a, index+1, sum);
        return dp[index][sum];
    }

    public static boolean canPartitionSubsetMemoization(int[] a) {
        // find sum
        int sum = 0;
        for (int i=0;i<a.length;i++) {
            sum += a[i];
        }
        Boolean[][] dp = new Boolean[a.length][sum/2 + 1];
        return canPartitionSubsetMemoization(dp, a, 0, sum/2);
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(canPartitionSubsetProblemRecursion(a));
    }
}
