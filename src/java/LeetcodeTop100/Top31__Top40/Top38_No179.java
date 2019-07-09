package LeetcodeTop100.Top31__Top40;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Name : 最大数
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日14时59分
 *
 * @题目描述 : 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * @链接 : https://leetcode-cn.com/problems/largest-number/
 *
 * @示例 : 输入[10, 2]、输出210；输入[3,30,34,5,9]、输出9534330
 *
 * @思路 : 1、不能用枚举法，肯定会超时，考虑使用贪心算法。每一次寻找一个最大的数，即每次找的都是最大的.寻找逻辑，每次使用冒泡
 *         算法，求出最大的一个值，关键就是怎么比较两个整数哪个放在前面哪个放在后面，逻辑如下：
 *           a) 将数字转换为String，如果从前往后按位比较，在相等的长度内，如果找到不一样的位，直接就能返回结果。
 *           b) 如果两个数有相同的前缀，且其中一个数就等于这个前缀，那么要继续比较。比较逻辑如下描述：
 *              s1 --- xxx..y   s2 --- xxx 以s1作为前面，即认为s1比较大的话，则后面几位是yxxx,反之认为s2比较大，则为xxxy。
 *              直接比较xxxy与yxxx的大小即可。
 *           c) 最后，记得对前面多余的0进行简化，如果第一个字符串是0，则直接返回0，因为后面都是0。
 *        2、不要把问题想复杂了，对于两个数的拼接，无非就是o1+o2与o2+o1，那么显然可以自定义一个比较器，将数组中的数按照拼接
 *        逻辑进行重新排序。最终保证相邻两个数，拼接后更大的数放在前面即可，也就是一种降序排列，降序的话是o2-o1。
 *
 *
 **/

public class Top38_No179 {
    public static void main(String[] args) {

        int[] nums = {0,0,0};
        System.out.println("------------");
        System.out.println(largestNumber_2(nums));

        String s1 = "12";
        String s2 = "121";
        System.out.println(isS1BigerThanS2(s1, s2));
    }

    private static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; ++i){
            String curMax = "-1";
            int curInd = -1;
            for(int j = 0; j < nums.length; ++j){
                if(nums[j] == -1)           //选过的数置为-1，跳过下一次挑选
                    continue;
                String t = nums[j] + "";
                if(isS1BigerThanS2(t, curMax)){
                    curMax = t;
                    curInd = j;
                }
            }
            sb.append(curMax);
            nums[curInd] = -1;
        }
        String s =  sb.toString();
        int sub = 0;
        for(int i = 0; i < s.length() - 1; ++i){
            if(s.charAt(i) == '0')
                sub = i + 1;
            else
                break;
        }
        return s.substring(sub);
    }

    private static boolean isS1BigerThanS2(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int i = 0, j = 0;
        for(; i < arr1.length && j < arr2.length; ++i, ++j){
            if(arr1[i] > arr2[j])
                return true;
            if(arr1[i] < arr2[j])
                return false;
        }
        if(i == arr1.length && j == arr2.length)   //两者长度相等，返回false，因为是相等的。
            return false;
        //处理两个字符串有相同前缀的情况，对拼接后的后半部分进行比较，判断s1与s2哪个更大，大的放前面
        //arr1比arr2长
        if(arr1.length > arr2.length){
            String a = new String(arr1);   //以s2作为前的后缀
            String b = new String(arr2);   //以s1作为前的后缀
            b = a.substring(i) + b;
            return Integer.parseInt(b) > Integer.parseInt(a);
        }
        //arr2比arr1长
        else{
            String a = new String(arr1);   //以s2作为前缀
            String b = new String(arr2);   //以s1作为前缀
            a = b.substring(i) + a;
            return Integer.parseInt(b) > Integer.parseInt(a);
        }
    }
    private static String largestNumber_2(int[] nums) {
        String[] data = new String[nums.length];
        for(int i = 0; i < nums.length; ++i)
            data[i] = nums[i] + "";
        //此时o1与o2都还是字符，因此直接o2+o1就是拼接这两个数字，利用字符串的compareTo方法，即可按位比较字符串。
        Arrays.sort(data, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        StringBuilder res = new StringBuilder();
        for(String s : data){
            if(s.charAt(0) == '0')    //第一位为0，代表之后每一位都是零，拼接成的数字最大也就是为"0"。
                return "0";
            res.append(s);
        }
        return res.toString();
    }


}
