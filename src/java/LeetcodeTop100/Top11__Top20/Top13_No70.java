package LeetcodeTop100.Top11__Top20;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @date : 2019年6月20日17:39:15
 * @link ：https://leetcode-cn.com/problems/climbing-stairs
 *
 * @思路 : 这题是最经典的动态规划题目，使用递归会出现时间不够，因此把递归改成动态规划。
 *         设置从下往上的递归法，依次统计出1、2、3、4、5...台阶所需要的步数。
 * */

public class Top13_No70 {
    public static void main(String[] args) {
        System.out.println(climbStairs_2(10));
    }

    private static int climbStairs_2(int n){
        if(n < 3) return n;
        int step1 = 1;
        int step2 = 2;
        int step3 = 0;
        for(int i = 3; i <= n; ++i){
            step3 = step2 + step1;
            step1 = step2;
            step2 = step3;
        }
        return step3;
    }

    private static int climbStairs_1(int n){
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        for(int i = 3; i <= n; ++i){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

}
