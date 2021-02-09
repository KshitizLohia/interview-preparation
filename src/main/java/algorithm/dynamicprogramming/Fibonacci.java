package algorithm.dynamicprogramming;

public class Fibonacci {

    /**
     * Top down
     *
     * @param n input n
     * @return fibonacci of n
     */
    public static int calculateFibTopDown(int n) {
        if (n <= 1) return n;
        else return calculateFibTopDown(n-1) + calculateFibTopDown(n-2);
    }


    /**
     * Top down with memoization
     *
     * @param n input n
     * @return fibonacci of n
     */
    public static int calculateFibTopDownWithMemoization(int n) {
        return calculateFibWithMem(n, new int[n+1]);
    }

    public static int calculateFibWithMem(int n, int[] a) {
        if (n < 2) return n;
        if (a[n] != 0) return a[n];
        else {
            a[n] = calculateFibWithMem(n-1, a) + calculateFibWithMem(n-2, a);
            return a[n];
        }

    }

    /**
     * Calculate fib bottom up
     *
     * @param n number
     * @return fibonacci of number
     *
     */
    public static int calculateFibonacciBottomUp(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(calculateFibTopDown(7));
        System.out.println(calculateFibTopDownWithMemoization(7));
        System.out.println(calculateFibonacciBottomUp(7));
    }
}
