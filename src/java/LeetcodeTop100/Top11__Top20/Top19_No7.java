package LeetcodeTop100.Top11__Top20;
/**
 * @Name : 整数反转
 * @Level : Easy
 * @Author : Chris
 * @Date : 2019年06月23日22时41分
 * 
 * @题目描述 : 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *            假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 *            请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @链接 : https://leetcode-cn.com/problems/reverse-integer/
 * @示例 :输入: 123
 *        输出: 321
 *
 * @思路 : 要根据整数进行翻转，则要依次分析出整数中有哪些位，将位进行倒转即可。
 *
 */
public class Top19_No7 {

    public static void main(String[] args) {

        System.out.println(reverse(1534236));
    }

    private static int reverse(int num){
        if(-10 < num && num< 10)
            return num;
        boolean isNeg = num < 0;
        int abs = Math.abs(num);
        String s = abs + "";
        int index = s.length() - 1;
        long res = 0;
        while(s.charAt(index) == 0){  //从后往前遍历s，将所有为0的先去除
            index--;
        }
        for(; index >= 0; --index){
            res += (s.charAt(index) - 48) * Math.pow(10,index);
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            res = 0;
        abs = (int)res;
        return isNeg ? 0 - abs : abs;
    }
}
