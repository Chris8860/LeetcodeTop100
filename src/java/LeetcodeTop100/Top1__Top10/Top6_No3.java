package LeetcodeTop100.Top1__Top10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @思路 :此题可以选择从前往后遍历字符串，设置一个HashMap保存字符以及下标，设置一个变量j保存当前不含重复字符的第一个字符位置。
 *
 * */

public class Top6_No3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }
    static public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2)
            return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = 0;      //j用于指示当前不含重复字符的第一个字符位置
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);  //注意j有可能会比当前字符c之前存的位置大，比如fdsasdf,那么遍历到第二个f时，j为3，但是map.get(c)为0.
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }

}
