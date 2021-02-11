### Dynamic Programming
1. Optimal solution to overall problems depend on optimal solution to sub-problems


#### Overlapping problems
fib(4)
fib(3)       |      fib(2)
fib(2) + fib(1)     fib(1) + fib(0)

#### Knapsack
```
dp[i][c] = max (dp[i-1][c], profits[i] + dp[i-1][c-weights[i]]) 
```

#### Count Problem
```
dp[index][sum] = dp[index-1][sum] + dp[index-1][sum-num[index]])
```

##### Iterative
```
// populate the sum=0 columns, as we will always have an empty set for zero sum
int n = num.length;
int[][] dp = new int[n][sum + 1];
for(int i=0; i < n; i++)
  dp[i][0] = 1;

// with only one number, we can form a subset only when the required sum is equal to its value
for(int s=1; s <= sum ; s++) {
  dp[0][s] = (num[0] == s ? 1 : 0);
}

for(int i=1; i < num.length; i++) {
      for(int s=1; s <= sum; s++) {
        // exclude the number
        dp[i][s] = dp[i-1][s];
        // include the number, if it does not exceed the sum
        if(s >= num[i])
          dp[i][s] += dp[i-1][s-num[i]];
      }
    }
```

##### Recursion
```
private int countSubsetsRecursive(Integer[][] dp, int[] num, int sum, int currentIndex) {
    // base checks
    if (sum == 0)
      return 1;

    if(num.length == 0 || currentIndex >= num.length)
      return 0;

    // check if we have not already processed a similar problem
    if(dp[currentIndex][sum] == null) {
      // recursive call after choosing the number at the currentIndex
      // if the number at currentIndex exceeds the sum, we shouldn't process this
      int sum1 = 0;
      if( num[currentIndex] <= sum )
        sum1 = countSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);

      // recursive call after excluding the number at the currentIndex
      int sum2 = countSubsetsRecursive(dp, num, sum, currentIndex + 1);

      dp[currentIndex][sum] = sum1 + sum2;
    }

    return dp[currentIndex][sum];
  }
```