package LeetcodeTop100.Top31__Top40;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name : 字符串转整数
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日14时58分
 *
 * @题目描述 : 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *            当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 *            假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *            该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 *            注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需
 *            要进行转换。
 *            在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *           说明：
 *              假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请
 *              返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * @链接 : https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * @示例 :  输入"42"，输出42；输入"   -42",输出42；输入"4193 with words",输出4193。
 *
 * @思路 : 1、将字符串转为charArray进行处理，只是要注意先要将前面非数字的提取出来。同时注意在计算res的过程中，随时注意可能会
 *            溢出，要添加额外的判断
 *
 *         2、利用正则表达式，匹配式子为："^[\\+\\-\\d]\\d*" 表示以+-或者数字开头，*表示匹配前面的字符，也就是数字\d多次。
 *
 *
 **/

public class Top34_No8 {
    public static void main(String[] args) {

        String s = "+1";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        //step 1: 将前面多余的空格去除，提取出正负。 这一步可以通过 s.trim() 快速实现
        char[] arr = str.toCharArray();
        int i = 0;
        while(i < arr.length && arr[i] != '-' && arr[i] != '+' && (arr[i] < '0' || arr[i] > '9')){
            if(arr[i] != ' ')
                return 0;
            i++;
        }
        if(i == arr.length)
            return 0;
        boolean isNeg = false;
        if(arr[i] == '-' || arr[i] == '+'){
            isNeg = arr[i] != '+';
            i++;
        }

        long res = 0;
        while(i < arr.length && '0' <= arr[i] && arr[i] <= '9'){
            res = res *  10 + arr[i] - '0';
            if(isNeg){
                if(res - 1> Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
            }
            else{
                if(res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
            i++;
        }
        int finalRes = (int)res;
        return isNeg? 0 - finalRes : finalRes;
    }

    private static int myAtoi_2(String s){
        s = s.trim();

        String pattern = "^[\\+\\-\\d]\\d*";  //表示匹配以正号或负号或数字开头，且后面是0个或多个数字的字符串
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        String res="";
        if(m.find()){//能匹配到
            res=s.substring(m.start(),m.end());
        }else{//不能匹配到
            return 0;
        }

        if(res.length() == 1 && (res.charAt(0) == '+' || res.charAt(0) == '-'))
            return 0;

        try{
            int anInt = Integer.parseInt(res);
            return anInt;
        } catch (Exception e){
            return res.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

}
