package algorithm.dynamicprogramming.pattern1_0or1;

public class EqualSubsetPartitionProblemBottomUp {

    public static boolean subsetProblem(int[] a) {
        int sum = 0;
        for (int i=0;i<a.length;i++) {
            sum += a[i];
        }
        if (sum % 2 != 0) return false;
        boolean[][] dp = new boolean[a.length][sum];
        // 1st index: index 2nd index is sum

        // if sum is 0 that means we can't partition
        for (int i=0; i<a.length; i++) {
            dp[i][0] = true;
        }

        // if index is 0, mean sum is a[i]
        for (int i=0; i<sum; i++) {
            dp[0][i] = (a[0] == i) ? true: false;
        }

        for (int i=1; i<a.length; i++) {
            for (int s=1; s<sum; s++) {
                // we can get s without element i
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                }
                // if we can get s with element u
                else if(s >= a[i]) {
                    dp[i][s] = dp[i][s-a[i]];
                }
            }
        }
        return dp[a.length-1][sum];
    }

    public static void main(String[] args) {

    }
}
