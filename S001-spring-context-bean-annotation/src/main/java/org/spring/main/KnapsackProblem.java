package org.spring.main;
import java.util.*;

public class KnapsackProblem {

    private static final int MOD = 1_000_000_007;

    public static int calculateMaximumProfit(int[] cost, int x) {
        int n = cost.length;

        // Find maximum budget needed for relevant items
        int maxCost = 0;
        for (int c : cost) {
            maxCost += c;
            if (maxCost > x) {
                maxCost = x; // Only consider relevant costs
                break;
            }
        }

        // DP array for the maximum budget we care about
        int[] dp = new int[maxCost + 1];

        for (int i = 0; i < n; i++) {
            int profit = modPower(2, i, MOD); // Calculate 2^i % MOD
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], (dp[j - cost[i]] + profit) % MOD);
            }
        }

        return dp[Math.min(x, maxCost)];
    }

    // Function to calculate (base^exp) % mod using modular exponentiation
    private static int modPower(int base, int exp, int mod) {
        long result = 1;
        long power = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * power) % mod;
            }
            power = (power * power) % mod;
            exp >>= 1;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the cost array
        int n = sc.nextInt();
        int[] cost = new int[n];

        // Input cost array
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        // Input total money available (x)
        int x = sc.nextInt();

        // Calculate and print the maximum profit
        int maxProfit = calculateMaximumProfit(cost, x);
        System.out.println(maxProfit);
    }
}
