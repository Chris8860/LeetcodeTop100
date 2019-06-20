package LeetcodeTop100.Top11__Top20;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @date : 2019年6月20日16:59:39
 * @link : https://leetcode-cn.com/problems/3sum
 *
 * @思路 : 这题要求给出不重复的三元组，因此可以考虑将数组先排序，按照一定的下标前进。每次固定一个值，在后面搜索相加为其相反数的两个数。
 *         tips: 设置HashSet来存储固定过得值，以免出现重复判断。
 *               数组先排序后，从后往前固定某个值，当发现固定的值大于0时，停止循环，此时已经不可能出现和为0的三元组。
 *
 * */

public class Top11_No15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);

        System.out.println(res);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0)
                break;
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            //已经固定好当前的值，为nums[i]，需要从后面部分搜索相加为 0 - nums[i]的数
            int begin = i + 1, end = nums.length - 1, target = 0 - nums[i];
            while(begin < end){
                if(nums[begin] + nums[end] == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[begin]);
                    tmp.add(nums[end]);
                    res.add(tmp);
                    begin++;
                    end--;
                    while(begin < end && nums[begin] == nums[begin - 1])  //判断的作用是去重
                        begin++;
                    while(begin < end && nums[end] == nums[end + 1])
                        end--;
                }
                else if(nums[begin] + nums[end] > target)
                    end--;
                else
                    begin++;
            }
        }
        return res;
    }
}
