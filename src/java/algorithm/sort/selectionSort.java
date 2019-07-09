package algorithm.sort;

/**
 * @Name : 选择排序
 * @Author : Chris
 * @Date : 2019年07月09日20时54分
 *
 * @思路 : 每次从未排序的区域中选出最大的元素，放在已排序序列的起始位置，之后从剩余未排序的数组中选出最大的元素，放在已排序
 *         的数组的前面。
 *
 **/

public class selectionSort {
    public static void main(String[] args) {
        int[] nums = {4,5,8,23,57,43,2,9,1,1};
        nums = SellectionSort(nums);
        for(int i : nums)
            System.out.println(i);
    }

    private static int[] SellectionSort(int[] nums){
        int maxIndex;  //记录每次选择最大元素的下标
        for(int i = 0; i < nums.length; ++i){
            maxIndex = 0;
            for(int j = 1; j < nums.length - i; ++j){
                if(nums[j] > nums[maxIndex])
                    maxIndex = j;
            }
            //将当前未排序元素的最大元素放到已排序数组的最前面。
            int t = nums[maxIndex];
            nums[maxIndex] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }
        return nums;
    }

}
