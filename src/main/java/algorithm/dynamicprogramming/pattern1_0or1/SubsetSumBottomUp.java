package algorithm.dynamicprogramming.pattern1_0or1;

/**
 * Find a subset whose sum is equal to S
 *
 * a[i, s] = a[i-1, s],a[i,s-a[i]]
 */
public class SubsetSumBottomUp {

    public static boolean subsetBooleanBottomUp(int[] a, int sum, int index) {
        boolean[][] dp = new boolean[a.length][sum+1];

        // we can always form sum of 0 with 0 set
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = true;
        }

        //
        for (int i = 0; i < sum; i++) {
            dp[0][i] = a[0] == sum;
        }

        for (int i=1;i<a.length;i++) {
            for (int s=1;s<=sum;s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s>=a[i]) {
                    dp[i][s] = dp[i-1][s-a[i]];
                }
            }
        }
        return dp[a.length-1][sum];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int sum = 3;
        System.out.println(subsetBooleanBottomUp(a, sum, 0));

    }
}
