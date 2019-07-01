package LeetcodeTop100.Top21__Top30;

import java.util.Arrays;

/**
 * @Name : 最长上升子序列
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日00时02分
 * @题目描述 : 给定一个无序的整数数组，找到其中最长上升子序列的长度。存在多个子序列时输出长度即可，算法时间复杂度为o(n^2)
 * @链接 : https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @示例 : 输入: [10,9,2,5,3,7,101,18]
 *         输出: 4
 *         解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * @思路 : 1、对于这种涉及到子的问题，要想到使用动态规划来自底向上解决问题。令第i位置的最长上升子序列为Lis[i],同时该Lis必须包
 *           含第i位这个数，那么新遍历到一个数时，从前往后遍历Lis[0...i-1]，如果nums[i] > nums[j]，则Lis[i] = Lis[j] + 1;
 *           可知Lis[i] = max(Lis[j]) + 1 -- 并且要满足：nums[i] > nums[j]。
 *        2、
 *
 **/

public class Top30_No300 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

    private static int lengthOfLIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        int[] Lis = new int[nums.length];
        Arrays.fill(Lis, 1);
        Lis[0] = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; ++i){
            int max = 0;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j])
                    max = Math.max(max, Lis[j]);
            }
            Lis[i] = max + 1;
            maxLen = Math.max(maxLen, Lis[i]);
        }
        return maxLen;
    }


}
