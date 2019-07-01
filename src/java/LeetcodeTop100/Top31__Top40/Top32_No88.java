package LeetcodeTop100.Top31__Top40;

/**
 * @Name : 合并两个有序数组
 * @Level : Easy
 * @Author : Chris
 * @Date : 2019年07月01日00时08分
 * @题目描述 : 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * @链接 : https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @示例 : 输入:
 *         nums1 = [1,2,3,0,0,0], m = 3
 *         nums2 = [2,5,6],       n = 3
 *         输出: [1,2,2,3,5,6]
 *
 * @思路 : 这题目一看原则就是，不能够创建新的数组，否则浪费了nums1中多余的空间，考虑怎么将nums1中的空间用上，是的总的消耗空间
 *         为O(1)。考虑将nums1与nums2从后往前遍历，将更大的数放置到nums1[m+n-1-i]上。注意循环到nums1或者nums2添加完毕后，后续
 *         应该将不为空的继续添加到nums1。
 *
 **/

public class Top32_No88 {
    public static void main(String[] args) {
        int[] nums1 = {1,4,6,8,9,0,0,0,0,0,0};
        int[] nums2 = {2,4,7};
        merge(nums1,5,nums2,3);
        System.out.println(123);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, start = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[start] = nums1[i];
                i--;
            }
            else{
                nums1[start] = nums2[j];
                j--;
            }
            start--;
        }
        if(i >= 0){
            while(i >= 0){
                nums1[start] = nums1[i];
                start--;
                i--;
            }
        }
        else{
            while(j >= 0){
                nums1[start] = nums2[j];
                start--;
                j--;
            }
        }
    }

}
