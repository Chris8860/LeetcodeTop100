package LeetcodeTop100.Top11__Top20;
/**
 * @Name : 盛最多水的容器
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年06月23日23时07分
 * 
 * @题目描述 : 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个
 *            端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *      说明: 你不能倾斜容器，且 n 的值至少为 2。
 *
 * @链接 : https://leetcode-cn.com/problems/container-with-most-water
 *
 * @示例 :输入: [1,8,6,2,5,4,8,3,7]
 *        输出: 49
 *
 * @思路 : 这题可想而知，计算能够容纳的水量的办法就是取两根线，即：min(l1, l2) * △x；此题简单的办法，就是遍历所有情况，但这
 *         是O(n^2)复杂度，没有必要，思考另一种解法：双指针解法
 *         两个指针分别指向左边与右边，刚开始比较大小，将小的往大的方向移动。为什么不移动大的呢？因此移动小的距离减小，但是可
 *         能得到更大的min(l1,l1)，可能会有益于面积的增肌；而要是直接移动大的，那么由于小的本身限制在那儿，距离减小最大高度又
 *         不能够增加，所以无益于面积的增加。
 *
 */
public class Top20_No11 {
    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0;
        while(start < end){
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));
            if(height[start] < height[end])  //移动比较小的那一个指针
                start++;
            else
                end--;
        }
        return maxArea;
    }
}
