package algorithm.dynamicprogramming.pattern1_0or1;

/**
 * Input: {1, 2, 3, 9}
 * Output: 3
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 *
 * Input: {1, 2, 7, 1, 5}
 * Output: 0
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
 *
 * Input: {1, 3, 100, 4}
 * Output: 92
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
 *
 * s[i,sum1, sum2] = min(s[i-1, sum1+a[i], sum2], s[i-1, sum1, sum2+a[i]])
 *
 */
public class MinimumSubsetSumDifferenceTopDown {

    public static int minimumSubsetRecursion(int[] a, int sum1, int sum2, Integer[][] dp, int index) {
        // base cases
        if (index >= a.length) return Math.abs(sum1-sum2);
        if (dp[index][sum1] != null) {
            return dp[index][sum1];
        }
        // recursive cases
        int diff1 = minimumSubsetRecursion(a, sum1+a[index], sum2, dp, index+1);
        int diff2 = minimumSubsetRecursion(a, sum1, sum2+a[index], dp, index+1);
        dp[index][sum1] = Math.min(diff1, diff2);
        return dp[index][sum1];
    }

    public static int minimumSubset(int[] a) {
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            sum += a[i];
        }
        Integer dp[][] = new Integer[a.length][sum+1];
        return minimumSubsetRecursion(a, 0, 0, dp, 0);
    }

    public static void main(String[] args) {
        int[] a =  {1,2,3,9};
        System.out.println(minimumSubset(a));
    }
}
