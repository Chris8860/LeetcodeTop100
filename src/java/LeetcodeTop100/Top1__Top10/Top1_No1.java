package LeetcodeTop100.Top1__Top10;


/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * link: https://leetcode-cn.com/problems/two-sum/
 *
 * */

import java.util.HashMap;
import java.util.Map;

/**
 * 这题思路比较多：
 * 一是使用穷举法，直接O(n^2)时间复杂度遍历数组
 * 二是使用HashMap，首先将所有的元素及其下标存入HashMap，在依次查找HashMap中是否存在target - nums[i]
 *
 * */

public class Top1_No1 {
    public static void main(String[] args) {
        System.out.println("aaaa");
    }


    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i)
            map.put(i, nums[i]);

        for(int i = 0; i < nums.length; ++i){
            if(map.containsValue(target - nums[i])){  //注意不能重复利用相同的元素
                for(Map.Entry<Integer,Integer> m : map.entrySet()){
                    int a = m.getKey();
                    int b = m.getValue();
                    if(b == target - nums[i] && a != i)
                        return new int[]{i, a};
                }
            }
        }
        return null;
    }

}
