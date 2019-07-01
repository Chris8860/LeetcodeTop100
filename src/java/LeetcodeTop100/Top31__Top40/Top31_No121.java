package LeetcodeTop100.Top31__Top40;

/**
 * @Name : 买股票最佳时机
 * @Level : Easy
 * @Author : Chris
 * @Date : 2019年7月1日00:07:51
 * @题目描述 : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。注意你不能在买入股票前卖出股票。
 *
 * @链接 : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *
 * @示例 : 输入: [7,1,5,3,6,4]
 *         输出: 5
 *         解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * @思路 : 从前往后遍历数组，保持一个curMin，为到当前日期的最便宜价格。后面每次更新，都要考虑价格是否为新的curMin，否则计算一
 *         次利润。
 *
 *
 **/

public class Top31_No121 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int curMin = prices[0];
        int maxPro = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] < curMin)
                curMin = prices[i];
            else{
                maxPro = Math.max(maxPro, prices[i] - curMin);
            }
        }
        return maxPro;
    }

}
