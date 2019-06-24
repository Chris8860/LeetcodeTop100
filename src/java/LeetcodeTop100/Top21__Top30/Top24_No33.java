package LeetcodeTop100.Top21__Top30;
/**
 * @Name : 搜索旋转排序数组
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年06月24日00时42分
 * 
 * @题目描述 : 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *             ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *             搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *             你可以假设数组中不存在重复的元素。
 *             你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @链接 : https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @示例 : 输入: nums = [4,5,6,7,0,1,2], target = 0
 *         输出: 4
 *
 * @思路 : 一看到时间复杂度，直接想到二分搜索了。每次二分的时候，根据目标值在左半边或者右半边分两种情况，同时根据mid在左半边或
 *        者右半边，在分两种情况，因此每次二分的时候要分四种情况讨论。
 *
 *
 */
public class Top24_No33 {
    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(search(nums,2));
    }

    private static int search(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int lo = 0, hi = nums.length;
        boolean tarInLeft = target > nums[nums.length - 1];
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            boolean midInLeft = nums[mid] > nums[nums.length - 1];
            if(nums[mid] == target)
                return mid;
            if(tarInLeft){
                if(nums[mid] > target){
                    hi = mid;
                }
                else{
                    if(midInLeft)
                        lo = mid + 1;
                    else
                        hi = mid;
                }
            }
            else{
                if(nums[mid] > target){
                    if(midInLeft)
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                else{
                    lo = mid + 1;
                }
            }
        }
        return -1;

    }
}
