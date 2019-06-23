package LeetcodeTop100.Top21__Top30;

import java.util.Arrays;

/**
 * @Name : 零钱兑换
 * @Level : medium
 * @Author : Chris
 * @Date : 2019年06月23日23时37分
 * 
 * @题目描述 : 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任
 *            何一种硬币组合能组成总金额，返回 -1。
 *
 * @链接 : https://leetcode-cn.com/problems/coin-change
 *
 * @示例 : 输入: coins = [1, 2, 5], amount = 11
 *         输出: 3
 *         解释: 11 = 5 + 5 + 1
 *
 * @思路 : 这是一道比较经典的动态规划题，很显然，对于不同数额钱的硬币兑换，我们都能够得到一个结果，或是最少硬币数量或是无法兑换
 *         从数额比较小，一直到数额比较大，依次分析，用数组记录下，不能够兑换的就用-1.这样避免递归运算的重复计算。
 *
 *
 */
public class Top21_No322 {

    public static void main(String[] args) {

        int[] coins = {3,5};
        System.out.println(coinChange(coins,4));
    }

    private static int coinChange(int[] coins, int amount) {
        if(amount <= 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int value : coins) {
            if (value >= dp.length)
                continue;
            dp[value] = 1;
        }
        for(int i = 1; i < dp.length; ++i){
            for(int coin : coins){
                if(i - coin > 0) {
                    if (dp[i - coin] != -1) {
                        if(dp[i] == -1)
                            dp[i] = dp[i - coin] + 1;
                        else
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }

//Solution 2: 备忘录式动态规划

    private static int coinChange_2(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, -2);                //为什么是-2呢？因为-1代表了一种结果，而备忘录的初始值是不能为其中一种可能的结果的
        return helper(coins, amount, mem);

    }

    private static int helper(int[] coins, int amount, int[] mem){
        if(amount == 0) return 0;
        if(mem[amount] != -2)
            return mem[amount];
        int num = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount - coin < 0) continue;
            int cur = helper(coins, amount - coin, mem);
            if(cur == -1) continue;
            num = Math.min(num, cur + 1);
        }
        mem[amount] = num == Integer.MAX_VALUE ? -1 : num;
        return mem[amount];
    }



}
