package LeetcodeTop100.Top1__Top10;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 * @思路 : 题目要求找连续子数组中最大的子数组。这种带有子的问题，考虑使用动态规划解题：
 *         假如现在我们已经解算出了数组[0...i-1]范围的最大子数组，其包括两种：
 *            1、带有当前已遍历元素的最后一个元素的最大值:maxByEnd。
 *            2、当前已遍历元素的最大子数组和:maxCur。
 *         现在到了数组的[i]元素，更新这两个值，有如下算法：
 *            1、maxByEnd = max(maxByEnd+[i], [i]);
 *            2、maxCur = max(maxCur, maxByEnd);
 *         最终遍历结束后，得到有maxNum = maxCur
 * */

public class Top8_No53 {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] nums) {
        long maxCur = Integer.MIN_VALUE;
        long maxByEnd = Integer.MIN_VALUE;
        for(int i : nums){
            maxByEnd = Math.max(maxByEnd + i, i);
            maxCur = Math.max(maxCur, maxByEnd);
        }
        return (int)maxCur;
    }
}
