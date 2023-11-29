# Climbing Stairs as an example of Fibonacci task

The base cases are when we are on the 1st stair (only one way to reach it) 
and the 2nd stair (two ways to reach it).

By summing up the number of ways to reach the (n-1)th and (n-2)th stairs, 
we can compute the total number of ways to climb the stairs. This allows us to solve the 
problem efficiently using various dynamic programming techniques such as 
- recursion, 
- memoization, 
- tabulation, 
- space optimization.

## Recursion
```puml
                    -------------------0--------------------
                    |                                      |
           ---------1---------                       ------2-------
           |                  |                      |             |
      -----2------         ---3---              -----3-----    ----4----
      |          |         |      |             |         |    |       |
   ---3---    ---4---   ---4---  [5]         ---4---     [5]  [5]      x
   |     |    |     |   |     |              |     |
 --4--  [5]  [5]    x  [5]    x             [5]    x
 |   |
[5]  x
```
We can see that the roots for 4, 3, 2 are the same, so there are redundant calculations.

This solution has exponential time complexity (O(2^n)) due to redundant calculations.
```java
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
```

## Memoization

To avoid redundant calculations we can create a cash (memo).
Before making a recursive call we can check if memo contains the required data.
```java
class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }
        return memo.get(n);
    }
}
```

## Tabulation

Tabulation eliminates recursion and uses a Bottom-Up approach.

It creates a DP table (dp) of size `n+1` to store the number of ways to reach each step. 
The base cases (0 and 1 steps) are initialized to `1` since there is only 
one way to reach them. Then, it iterates from `2` to `n`, 
filling in the DP table by summing up the values for the previous two steps. 
Finally, it returns the value in the last cell of the DP table, 
which represents the total number of ways to reach the top.

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```

## Space Optimization

Instead of an entire DP table, this solution uses only two variables.
It initializes `prev` and `curr` to `1` since there is only one way 
to reach the base cases (0 and 1 steps). Then, in each iteration, 
it updates prev and curr by shifting their values. 
`curr` becomes the sum of the previous two values, 
and `prev` stores the previous value of `curr`.

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
```