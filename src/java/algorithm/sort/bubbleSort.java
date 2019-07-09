package algorithm.sort;

/**
 * @Name : 冒泡排序
 * @Author : Chris
 * @Date : 2019年07月09日20时44分
 *
 * @思路 : 每一此选出一个最大的元素放到末尾。选择n次即可。
 *
 * @分析 ：时间复杂度O(n^2)
 *
 **/

public class bubbleSort {
    public static void main(String[] args) {
        int[] nums = {4,5,8,23,57,43,2,9,1,1};
        nums = BubbleSort(nums);
        for(int i : nums)
            System.out.println(i);
    }

    private static int[] BubbleSort(int[] nums){

        for(int i = 0; i < nums.length; ++i){
            //注意每次后面都会是已经排序好，因此j < nums.length -i - 1。
            for(int j = 0; j < nums.length - i - 1; ++j){
                if(nums[j] > nums[j + 1]){
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
        return nums;
    }

}
