package LeetcodeTop100.Top11__Top20;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @date : 2019年6月21日17:02:12
 * @link ：https://leetcode-cn.com/problems/permutations
 *
 * @思路 ： 这题很明显是要用回溯法来做
 *
 * */

public class Top15_No46 {

    public static void main(String[] args) {
        permute(new int[]{0,1,2});
    }

    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private static void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));   //如果此处直接将tmp添加，则是添加了一个引用，固定不变的，会导致res内容全部指向一个集合。
        }
        else{
            for (int num : nums) {
                if (tmp.contains(num))
                    continue;
                tmp.add(num);
                backtrace(res, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
